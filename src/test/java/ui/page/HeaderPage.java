package ui.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class HeaderPage extends BasePageClass{
    @FindBy(how = How.XPATH,using = "//a[@href='/account']")
    private SelenideElement personalAccountButton;
    @FindBy(how = How.XPATH,using = "//p[text()='Конструктор']")
    private SelenideElement constructorButton;
    @FindBy(how = How.XPATH,using = "//div[contains(@class,'AppHeader_header__logo')]")
    private SelenideElement logoImage;

    @Step("Click account Button from header page")
    public LoginPage clickPersonalAccountButton() {
        personalAccountButton.click();
        return loadLoginPage();
    }

    @Step("Click account Button from header page")
    public ProfilePage clickAccountAuthButton() {
        personalAccountButton.click();
        return loadProfilePage();
    }

    @Step("Click Constructor Button from header page")
    public ConstructorPage clickConstructorButton() {
        constructorButton.click();
        return loadConstructorPage();
    }

    @Step("Click Image logo from header page")
    public ConstructorPage clickLogoImage() {
        logoImage.click();
        return loadConstructorPage();
    }

    @Override
    public HeaderPage waitForLoadPage() {
        logoImage.shouldBe(visible);
        return this;
    }
}