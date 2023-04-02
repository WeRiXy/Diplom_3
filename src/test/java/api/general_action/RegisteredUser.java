package api.general_action;

import api.generators.GeneratorTestUser;
import api.generators.GeneratorUserRegistryData;
import api.jsonobjects.user.User;
import api.jsonobjects.user.UserResponse;
import io.restassured.response.Response;
import api.jsonobjects.user.UserRegistryData;
import api.requests.UserAPI;

import static org.apache.http.HttpStatus.SC_OK;

public class RegisteredUser {
    public final User user;
    public final UserResponse userResponse;
    public final UserRegistryData userRegistryData;
   {
       user = GeneratorTestUser.getValidUser();
       Response response = UserAPI.createUser(user);
       response.then().statusCode(SC_OK);
       userResponse = response.body().as(UserResponse.class);
       userRegistryData = GeneratorUserRegistryData.getRegistryDataFromUser(user);
    }
}
