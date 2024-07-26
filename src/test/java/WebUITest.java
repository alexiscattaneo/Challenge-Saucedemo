import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Description;
import org.example.listeners.BrowserTestLifecycleListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.CarritoSteps;
import steps.HeaderSteps;
import steps.HomeSteps;
import steps.LoginSteps;

@ExtendWith(BrowserTestLifecycleListener.class)
public class WebUITest {

    LoginSteps loginSteps = new LoginSteps();
    HomeSteps homeSteps = new HomeSteps();
    HeaderSteps headerSteps = new HeaderSteps();
    CarritoSteps carritoSteps = new CarritoSteps();

    @Test //ID Test Case: 3
    @Feature("Inicio de sesión")
    @Story("Credenciales inválidas")
    @Description("Verifica que la página muestra un mensaje de error al intentar iniciar sesión con credenciales inválidas")
    public void credencialesInvalidas(){
        loginSteps.ingresarALaPagina();
        loginSteps.iniciarSesion("nonexistent_user", "invalidPassword");
        loginSteps.validarMensajeCredencialesInvalidas();
    }

    @Test //ID Test Case: 15
    @Feature("Carrito")
    @Story("Eliminar todos los productos del carrito")
    @Description("Verifica que el usuario puede eliminar todos los productos")
    public void eliminarTodosLosProductosDelCarrito(){
        //Precondicion
        loginSteps.ingresarALaPagina();
        loginSteps.iniciarSesion("standard_user", "secret_sauce");
        homeSteps.validarInicioDeSesion();
        homeSteps.agregarProductoAlCarrito("Sauce Labs Backpack");
        homeSteps.agregarProductoAlCarrito("Sauce Labs Bike Light");
        homeSteps.agregarProductoAlCarrito("Sauce Labs Bolt T-Shirt");
        //Test
        headerSteps.ingresarAlCarrito();
        carritoSteps.validarTituloDelCarrito();
        carritoSteps.eliminarTodosLosProductosDelCarrito();
    }

    @Test //ID Test Case: 15 (fallo intencional)
    @Feature("Carrito")
    @Story("Eliminar todos los productos del carrito (fallo intencional)")
    @Description("Verifica que el usuario puede eliminar todos los productos (fallo intencional)")
    public void testFalloIntencional(){
        //Precondicion
        loginSteps.ingresarALaPagina();
        loginSteps.iniciarSesion("standard_user", "secret_sauce");
        homeSteps.validarInicioDeSesion();
        homeSteps.agregarProductoAlCarrito("Sauce Labs Backpack");
        homeSteps.agregarProductoAlCarrito("Sauce Labs Bike Light");
        homeSteps.agregarProductoAlCarrito("Sauce Labs Bolt T-Shirt");
        //Test
        headerSteps.ingresarAlCarrito();
        carritoSteps.validarTituloDelCarrito();
        carritoSteps.falloIntencional();
    }
}
