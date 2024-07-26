package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import pages.CarritoPage;

public class CarritoSteps {

    CarritoPage carritoPage = new CarritoPage();

    @Step("Validar título del carrito")
    public void validarTituloDelCarrito(){
        Assertions.assertTrue(carritoPage.titulo().isDisplayed());
    }

    @Step("Eliminar todos los productos del carrito")
    public void eliminarTodosLosProductosDelCarrito(){

        //Validar existencia de productos en el carrito
        Assertions.assertFalse(carritoPage.productosEnCarrito().isEmpty());

        //Validar existencia del icono de cantidad de productos en el carrito
        Assertions.assertFalse(carritoPage.iconoCantidadCarrito().isEmpty());

        //Eliminar productos del carrito
        for(WebElement eliminarDelCarrito: carritoPage.botonesEliminarDelCarrito()){
            eliminarDelCarrito.click();
        }

        //Validar inexistencia de productos en el carrito
        Assertions.assertTrue(carritoPage.productosEnCarrito().isEmpty());

        //Validar inexistencia del icono de cantidad de productos en el carrito
        Assertions.assertTrue(carritoPage.iconoCantidadCarrito().isEmpty());
    }

    @Step("Carrito: fallo intencional")
    public void falloIntencional(){
        Assertions.assertTrue(false);
    }
}
