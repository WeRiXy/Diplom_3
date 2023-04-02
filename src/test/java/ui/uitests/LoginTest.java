package ui.uitests;

import api.general_action.RegisteredUser;
import api.general_action.UserAction;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Test;
import ui.page.ConstructorPage;
import ui.page.HeaderPage;
import ui.page.PasswordRecoveryPage;
import ui.page.RegistryPage;
import ui.settings.Browser;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static ui.constants.Url.*;

@Feature(value = "Login user")
public class LoginTest extends Browser {
    private static RegisteredUser registeredUser = new RegisteredUser();

    @AfterClass
    public static void deleteTestData() {
        UserAction.delete(registeredUser.userResponse);
    }


    @Test
    @DisplayName("Login user from MainPage")
    public void loginFromMainPageByButton() {

        open(MAIN, ConstructorPage.class)
                .clickAccountButton()
                .loginValidUser(registeredUser.user)
                .waitUntilDisplayedCreateOrderButton();

        webdriver().shouldHave(url(MAIN));
    }

    @Test
    @DisplayName("Login user from HeaderPage")
    public void loginFromMainPageByLink() {

        open(MAIN, HeaderPage.class)
                .clickPersonalAccountButton()
                .loginValidUser(registeredUser.user)
                .waitUntilDisplayedCreateOrderButton();

        webdriver().shouldHave(url(MAIN));
    }

    @Test
    @DisplayName("Login user from RegistryPage")
    public void loginFromRegistryPageByLink() {

        open(REGISTRY, RegistryPage.class)
                .clickLoginLink()
                .loginValidUser(registeredUser.user)
                .waitUntilDisplayedCreateOrderButton();

        webdriver().shouldHave(url(MAIN));
    }

    @Test
    @DisplayName("Login user from PasswordRecoveryPage")
    public void loginFromPasswordRecoveryPageByLink() {

        open(RECOVERY_PASSWORD, PasswordRecoveryPage.class)
                .clickLoginLink()
                .loginValidUser(registeredUser.user)
                .waitUntilDisplayedCreateOrderButton();

        webdriver().shouldHave(url(MAIN));
    }
}