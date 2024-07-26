package pages;

import org.example.providers.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebElement titulo(){
        return WebDriverProvider.getDriver().findElement(By.xpath("//div[@class='app_logo']"));
    }

    public By getBtnAddToCartFromTitleProduct(String titleProduct){
        return By.xpath("//div[@data-test='inventory-item']//div[text()='" + titleProduct + "']/ancestor::div[@data-test='inventory-item-description']//button[contains(@id,'add-to-cart')]");
    }

    public By getBtnRemoveToCartFromTitleProduct(String titleProduct){
        return By.xpath("//div[@data-test='inventory-item']//div[text()='" + titleProduct + "']/ancestor::div[@data-test='inventory-item-description']//button[contains(@id,'remove')]");
    }

}
