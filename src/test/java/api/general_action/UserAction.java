package api.general_action;

import api.generators.GeneratorUserRegistryData;
import api.jsonobjects.user.User;
import api.jsonobjects.user.UserResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import api.requests.UserAPI;

public class UserAction {
    @Step("Delete User")
    public static void delete(UserResponse userResponse) {
        String token = userResponse.getAccessToken();
        if (token != null) {
            UserAPI.deleteUser(token).then().statusCode(202);
        }
    }

    @Step("Delete User")
    public static void delete(Response response) {
        String token = response.then().extract().path("accessToken");
        if (token != null) {
            UserAPI.deleteUser(token);
        }
    }

    @Step("Delete User")
    public static void delete(User user) {
        String token = UserAPI.loginUser(GeneratorUserRegistryData.getRegistryDataFromUser(user)).path("accessToken");
        if (token != null) {
            UserAPI.deleteUser(token);
        }
    }
}
