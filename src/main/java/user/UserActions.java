package user;

import constants.*;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserActions {

    @Step("Создание пользователя")
    public static Response createUser(User user) {
        return given().log().all()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .post(Base.URL + Base.CREATE_USER);
    }

    @Step("Авторизация пользователя")
    public static Response loginUser(User user) {
        return given().log().all()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .post(Base.URL + Base.LOGIN_USER);
    }

    @Step("Удаление пользователя")
    public static Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(Base.URL + Base.DELETE_USER);
    }

}
