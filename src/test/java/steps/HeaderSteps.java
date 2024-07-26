package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import pages.HeaderPage;

public class HeaderSteps {

    HeaderPage headerPage = new HeaderPage();

    @Step("Ingresar al carrito")
    public void ingresarAlCarrito(){
        Assertions.assertTrue(headerPage.carrito().isDisplayed());
        headerPage.carrito().click();
    }
}
