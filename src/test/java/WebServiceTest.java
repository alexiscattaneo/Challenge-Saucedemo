import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import steps.WebServiceSteps;

public class WebServiceTest {

    WebServiceSteps webServiceSteps = new WebServiceSteps();

    @Test
    @Feature("Web Services")
    @Story("Verificacion de departamentos en Mercado Libre")
    @Description("Verifica que el servicio web de departamentos de mercado libre contenga información")
    public void mercadoLibreDepartamentsService(){
        webServiceSteps.realizarPeticionGetADepartamentosML();
        webServiceSteps.validarServicioMLDepartamentos();    
    }

}
