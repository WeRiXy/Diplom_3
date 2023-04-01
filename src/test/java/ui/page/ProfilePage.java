package ui.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class ProfilePage extends BasePageClass{
    @FindBy(how = How.XPATH,using = "//a[@href='/account/profile']")
    private SelenideElement profileLink;
    @FindBy(how = How.XPATH,using = "//p[text()='Конструктор']")
    private SelenideElement mainLink;

    @FindBy(how = How.XPATH,using = "//button[text()='Выход']")
    private SelenideElement exitButton;
    @Step("Click button exit from profile")
    public LoginPage clickExitButton () {
        exitButton.shouldBe(enabled).click();
        return loadLoginPage();
    }
    @Step("Click button Constructor")
    public ConstructorPage clickMainLink () {
        mainLink.click();
        return loadConstructorPage();
    }

    @Step("Check profile link is displayed")
    public ProfilePage shouldBeDisplayedProfileLink() { profileLink.shouldBe(visible); return this; }

    @Override
    public ProfilePage waitForLoadPage() {
        profileLink.shouldBe(visible);
        return this;
    }
}