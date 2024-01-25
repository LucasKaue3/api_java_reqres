package api.teste.utils;


import api.teste.pojo.User.UserPOJO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RESTUtils {

    public Response post(String url, UserPOJO user){
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .log().all() // Loga a requisição
                .body(user)
                .post(url)
                .then()
                .log().all() // Loga a resposta completa, incluindo status code e corpo
                .extract()
                .response(); // Extrai a resposta

        return response;
    }
}
