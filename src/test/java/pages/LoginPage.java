package pages;

import org.example.providers.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public String url = "https://www.saucedemo.com/";

    public WebElement titulo(){
        return WebDriverProvider.getDriver().findElement(By.xpath("//div[@class='login_logo']"));
    }

    public WebElement username(){
        return WebDriverProvider.getDriver().findElement(By.id("user-name"));
    }

    public WebElement password(){
        return WebDriverProvider.getDriver().findElement(By.id("password"));
    }

    public WebElement loginButton(){
        return WebDriverProvider.getDriver().findElement(By.id("login-button"));
    }

    public WebElement invalidCredentialsMessage(){
        return WebDriverProvider.getDriver().findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match any user in this service')]"));
    }

}
