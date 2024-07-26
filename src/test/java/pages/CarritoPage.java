package pages;

import org.example.providers.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CarritoPage {

    public WebElement titulo() {
        return WebDriverProvider.getDriver().findElement(By.xpath("//span[text()='Your Cart']"));
    }

    public List<WebElement> productosEnCarrito() {
        return WebDriverProvider.getDriver().findElements(By.xpath("//div[@data-test='inventory-item']"));
    }

    public List<WebElement> botonesEliminarDelCarrito() {
        return WebDriverProvider.getDriver().findElements(By.xpath("//button[text()='Remove']"));
    }

    public List<WebElement> iconoCantidadCarrito(){
        return WebDriverProvider.getDriver().findElements(By.xpath("//span[@data-test='shopping-cart-badge']"));
    }
}
