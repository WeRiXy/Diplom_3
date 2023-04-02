package ui.uitests;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import ui.constants.Url;
import api.general_action.UserAction;
import api.generators.GeneratorTestUser;
import api.jsonobjects.user.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ui.page.LoginPage;
import ui.settings.Browser;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static ui.constants.Url.LOGIN;

@Feature(value = "User registration")
@Story(value = "Negative tests")
@RunWith(Parameterized.class)
public class UserRegistrationNegativeTest extends Browser {
    private User user;
    private String password;

    public UserRegistrationNegativeTest(String password) {
        this.password = password;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getData() {
        return new Object[][] {
                {new Faker().internet().password(1,2)},
                {new Faker().internet().password(2,5)},
                {new Faker().internet().password(5,6)},
        };
    }

    @Before
    public void setUp() {
        user = GeneratorTestUser.getWithoutPassword();
        user.setPassword(password);
    }

    @Test
    public void registrationUser() {
        open(LOGIN, LoginPage.class)
                .clickRegistryLink()
                .register(user)
                .waitUntilDisplayedWrongPasswordText();
        webdriver().shouldHave(url(Url.REGISTRY));
    }

    @After
    public void deleteTestData() {
        UserAction.delete(user);
    }
}