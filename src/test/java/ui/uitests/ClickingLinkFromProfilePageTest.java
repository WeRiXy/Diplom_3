package ui.uitests;

import api.general_action.RegisteredUser;
import api.general_action.UserAction;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ui.page.HeaderPage;
import ui.page.ProfilePage;
import ui.settings.Browser;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static ui.constants.URL.*;

@Feature(value = "Clicking on links")
public class ClickingLinkFromProfilePageTest extends Browser {
    private RegisteredUser registeredUser;

    @Before
    public void setUp() {
        registeredUser = new RegisteredUser();
        open(MAIN);
        localStorage().setItem("accessToken",registeredUser.userResponse.getAccessToken());
        localStorage().setItem("refreshToken",registeredUser.userResponse.getRefreshToken());
        WebDriverRunner.driver().getWebDriver().navigate().to(ACCOUNT);
    }
    @After
    public void deleteTestData() {
        UserAction.delete(registeredUser.userResponse);
    }

    @Test
    @DisplayName("Click constructor link from profile")
    public void clickConstructorLinkFromProfile() {
        page(HeaderPage.class)
                .clickConstructorButton()
                .shouldBeDisplayedCreateOrderButton();

        webdriver().shouldHave(url(MAIN));
    }

    @Test
    @DisplayName("Click logo image link from profile")
    public void clickLogoFromProfile() {
        page(HeaderPage.class)
                .clickLogoImage()
                .shouldBeDisplayedCreateOrderButton();

        webdriver().shouldHave(url(MAIN));
    }

    @Test
    @DisplayName("Check Log out user")
    public void logoutUser() {
        page(ProfilePage.class)
                .clickExitButton()
                .shouldBeDisplayedLoginButton();

        webdriver().shouldHave(url(LOGIN));
    }
}