package testes;

import api.teste.pojo.User.UserPOJO;
import api.teste.utils.RESTUtils;
import commons.ConstantsUsers;
import commons.Urls;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class UserApiTest {

    @Test
    public void postCreateUser() {
        UserPOJO user = new UserPOJO(ConstantsUsers.name, ConstantsUsers.job);
        RESTUtils util = new RESTUtils();

        Response response = util.post(Urls.urlUsers, user);

        // Loga a resposta completa, incluindo status code e corpo, após a requisição
        response.then().log().all().statusCode(201);
    }

}