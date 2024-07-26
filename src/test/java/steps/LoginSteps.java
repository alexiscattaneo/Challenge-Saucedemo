package steps;

import io.qameta.allure.Step;
import org.example.providers.WebDriverProvider;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Step("Ingresar a saucedemo")
    public void ingresarALaPagina() {
        WebDriverProvider.getDriver().get(loginPage.url);
        validarCargaPaginaLogin();
    }

    @Step("Iniciar sesión")
    public void iniciarSesion(String username, String password) {
        loginPage.username().sendKeys(username);
        loginPage.password().sendKeys(password);
        loginPage.loginButton().click();
    }

    @Step("Validar carga de la página de login")
    public void validarCargaPaginaLogin() {
        Assertions.assertTrue(loginPage.titulo().isDisplayed());
    }

    @Step("Validar mensaje de error: credenciales inválidas")
    public void validarMensajeCredencialesInvalidas() {
        Assertions.assertTrue(loginPage.invalidCredentialsMessage().isDisplayed());
    }
}
