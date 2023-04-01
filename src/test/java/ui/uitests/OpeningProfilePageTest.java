package ui.uitests;

import api.general_action.RegisteredUser;
import api.general_action.UserAction;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ui.page.HeaderPage;
import ui.settings.Browser;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static ui.constants.URL.*;

@Feature(value = "Clicking on links")
public class OpeningProfilePageTest extends Browser {
    private RegisteredUser registeredUser;

    @Before
    public void setUp() {
        registeredUser = new RegisteredUser();
        open(MAIN);
        localStorage().setItem("accessToken",registeredUser.userResponse.getAccessToken());
        localStorage().setItem("refreshToken",registeredUser.userResponse.getRefreshToken());
    }
    @After
    public void deleteTestData() {
        UserAction.delete(registeredUser.userResponse);
    }

    @Test
    @DisplayName("Check open profile")
    public void openProfilePage() {
        page(HeaderPage.class)
                .clickAccountAuthButton()
                .shouldBeDisplayedProfileLink();
        webdriver().shouldHave(url(PROFILE));
    }
}