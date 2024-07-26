package steps;

import io.qameta.allure.Step;
import org.example.providers.WebDriverProvider;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Step("Validar inicio de sesion")
    public void validarInicioDeSesion(){
        Assertions.assertTrue(homePage.titulo().isDisplayed());
    }

    @Step("Agregar producto '{0}' al carrito")
    public void agregarProductoAlCarrito(String nombreProducto){
        Assertions.assertTrue(WebDriverProvider.getDriver().findElement(homePage.getBtnAddToCartFromTitleProduct(nombreProducto)).isDisplayed());
        WebDriverProvider.getDriver().findElement(homePage.getBtnAddToCartFromTitleProduct(nombreProducto)).click();
        Assertions.assertTrue(WebDriverProvider.getDriver().findElement(homePage.getBtnRemoveToCartFromTitleProduct(nombreProducto)).isDisplayed());
    }
}
