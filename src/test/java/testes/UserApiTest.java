package testes;

import api.teste.pojo.User.UserPOJO;
import api.teste.utils.RESTUtils;
import commons.ConstantsUsers;
import commons.Urls;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UserApiTest {

    @Test
    public void postCreateUser() {
        UserPOJO user = new UserPOJO(ConstantsUsers.name, ConstantsUsers.job);
        RESTUtils util = new RESTUtils();

        Response response = util.post(Urls.urlUsers, user);

        response.then().log().all()
                .statusCode(201)
                .body("name", equalTo(ConstantsUsers.name)) // Valida o campo 'name'
                .body("job", equalTo(ConstantsUsers.job)) // Valida o campo 'job'
                .body("id", notNullValue()) // Verifica se o campo 'id' está presente
                .body("createdAt", notNullValue()); // Verifica se o campo 'createdAt' está presente
    }

}