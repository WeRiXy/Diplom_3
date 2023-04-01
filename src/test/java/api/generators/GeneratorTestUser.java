package api.generators;

import api.jsonobjects.user.User;
import io.qameta.allure.Step;
import com.github.javafaker.Faker;

public class GeneratorTestUser {

    public static String name() { return new Faker().name().username();}
    public static String password() { return new Faker().internet().password(6,7);}
    public static String passwordInvalid() { return new Faker().internet().password(5,6);}
    public static String email() { return new Faker().internet().emailAddress();}

    @Step("Generate valid user")
    public static User getValidUser() {
        return new User(name(), password(), email());
    }
    @Step("Generate invalid user")
    public static User getUserWithInvalidPassword() {
        return new User(name(), passwordInvalid(), email());
    }
    @Step("Generate invalid user")
    public static User getWithoutPassword() {
        return new User(name(), null, email());
    }

    public static User getWithoutName() {
        return new User(null, password(), email());
    }

    public static User getWithoutEmail() {
        return new User(name(), password(), null);

    }
}
