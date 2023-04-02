package ui.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class PasswordRecoveryPage extends BasePageClass{
    @FindBy(how = How.XPATH,using = "//a[@href='/login']")
    private SelenideElement loginLink;
    @FindBy(how = How.XPATH,using = "//button[text()='Восстановить']")
    private SelenideElement recoveryButton;

    @Step("Click link login")
    public LoginPage clickLoginLink () {
        loginLink.click();
        return loadLoginPage();
    }

    @Override
    public PasswordRecoveryPage waitForLoadPage() {
        recoveryButton.shouldBe(visible);
        return this;
    }
}