package pages;

import org.example.providers.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HeaderPage {

    public WebElement carrito(){
        return WebDriverProvider.getDriver().findElement(By.id("shopping_cart_container"));
    }

}
