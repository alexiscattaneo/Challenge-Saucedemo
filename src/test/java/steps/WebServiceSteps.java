package steps;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.jupiter.api.Assertions;
import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;


public class WebServiceSteps {

    private Response departamentosResponse;


    @Step("Realiza peticion get a 'https://www.mercadolibre.com.ar/menu/departments'")
    public void realizarPeticionGetADepartamentosML(){
        RestAssured.baseURI = "https://www.mercadolibre.com.ar";
        departamentosResponse = given()
        .when()
        .get("/menu/departments")
        .then()
        .statusCode(200)
        .extract()
        .response();
    }

    @Step("Valida que la respuesta del servicio contenga información de departamentos")
    public void validarServicioMLDepartamentos(){
        List<Map> departamentosKey = departamentosResponse.path("departments");
        Assertions.assertFalse(departamentosKey.isEmpty(), "El body de respuesta no contiene información de departamentos.");

        Map departamentosValue = departamentosKey.get(0);
        Assertions.assertFalse(departamentosValue.isEmpty(), "La key 'departamentos' del body de respuesta no contiene información.");
    }
}
