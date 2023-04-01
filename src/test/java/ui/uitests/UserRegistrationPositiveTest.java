package ui.uitests;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
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

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static ui.constants.URL.LOGIN;

@Feature(value = "User registration")
@Story(value = "Positive tests")
@RunWith(Parameterized.class)
public class UserRegistrationPositiveTest extends Browser {
    private User user;
    private String password;

    public UserRegistrationPositiveTest(String password) {
        this.password = password;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getData() {
        return new Object[][] {
                {new Faker().internet().password(6,7)},
                {new Faker().internet().password(8,50)},
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
                .loadLoginPage();
        webdriver().shouldHave(url(LOGIN));
    }

    @After
    public void deleteTestData() {
        UserAction.delete(user);
    }
}