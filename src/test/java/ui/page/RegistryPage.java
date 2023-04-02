package ui.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import api.jsonobjects.user.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class RegistryPage extends BasePageClass {

    @FindBy(how = How.XPATH,using = "//*[text()='Имя']/parent::*/input")
    private SelenideElement nameField;
    @FindBy(how = How.XPATH,using = "//*[text()='Email']/parent::*/input")
    private SelenideElement emailField;
    @FindBy(how = How.XPATH,using = "//input[@type='password']")
    private SelenideElement passwordField;
    @FindBy(how = How.XPATH,using = "//button[text()='Зарегистрироваться']")
    private SelenideElement signInButton;
    @FindBy(how = How.XPATH,using = "//p[text()='Некорректный пароль']")
    private SelenideElement wrongPasswordText;
    @FindBy(how = How.XPATH,using = "//a[@href='/login']")
    private SelenideElement loginLink;

    private void setName(String name) {
        nameField.setValue(name);
    }

    private void setEmail(String email) {
        emailField.setValue(email);
    }

    private void setPassword(String password) {
        passwordField.setValue(password);
    }

    @Step("Click button registration")
    public void clickSignButton() {
        signInButton.shouldBe(visible).click();
    }

    @Step("Click link to open login page")
    public LoginPage clickLoginLink () {
        loginLink.click();
        return loadLoginPage();
    }

    public RegistryPage register(User user) {
        return register(user.getName(),user.getEmail(), user.getPassword());
    }

    @Step("Registry user: name-{name},email-{email},password-{password}")
    public RegistryPage register(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
        clickSignButton();
        return this;
    }

    @Step("Wait until password error is displayed")
    public RegistryPage waitUntilDisplayedWrongPasswordText() { wrongPasswordText.shouldBe(visible); return this; }


    @Override
    public RegistryPage waitForLoadPage() {
        signInButton.shouldBe(visible);
        return this;
    }

}