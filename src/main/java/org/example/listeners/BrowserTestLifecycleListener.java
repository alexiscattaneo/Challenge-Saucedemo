package org.example.listeners;

import io.qameta.allure.Allure;
import org.example.providers.WebDriverProvider;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import java.io.InputStream;

//
public class BrowserTestLifecycleListener implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        String browser = System.getProperty("browser", "chrome");
        if ("edge".equalsIgnoreCase(browser)) {
            WebDriverProvider.setupEdgeDriver();
        } else {
            WebDriverProvider.setupChromeDriver();
        }
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        WebDriver driver = WebDriverProvider.getDriver();
        if (driver != null) {
            Throwable throwable = context.getExecutionException().orElse(null);
            if (throwable != null) {
                captureScreenshot("Captura del fallo");
            }
            driver.quit();
            WebDriverProvider.removeDriver();
        }
    }

    private void captureScreenshot(String attachmentName) {
        try (InputStream is = WebDriverProvider.takeScreenshot()) {
            if (is != null) {
                Allure.addAttachment(attachmentName, "image/png", is, "png");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
