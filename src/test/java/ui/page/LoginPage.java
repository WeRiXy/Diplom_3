package ui.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import api.jsonobjects.user.User;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends BasePageClass{

    @FindBy(how = How.NAME,using = "name")
    private SelenideElement emailField;
    @FindBy(how = How.NAME,using = "Пароль")
    private SelenideElement passwordField;
    @FindBy(how = How.XPATH,using = "//button[text()='Войти']")
    private SelenideElement loginButton;
    @FindBy(how = How.XPATH,using = "//a[text()='Зарегистрироваться']")
    private SelenideElement registryLink;
    @Step("Enter the email")
    public void setEmail(String email) {
        emailField.setValue(email);
    }
    @Step("Enter the password")
    public void setPassword(String password) {
        passwordField.setValue(password);
    }
    @Step("Click login button")
    public void clickEnterButton() {
        loginButton.click();
    }

    @Step("Click link registry")
    public RegistryPage clickRegistryLink() {
        registryLink.click();
        return loadRegistryPage();
    }

    public LoginPage login(String email, String Password) {
        setEmail(email);
        setPassword(Password);
        clickEnterButton();
        return this;
    }

    public LoginPage login(User user) {
        login(user.getEmail(),user.getPassword());
        return this;
    }

    public ConstructorPage loginValidUser(User user) {
        login(user.getEmail(),user.getPassword());
        return loadConstructorPage();
    }

    @Step("Wait until login button is displayed")
    public LoginPage waitUntilDisplayedLoginButton() { loginButton.shouldBe(visible); return this; }

    @Override
    public LoginPage waitForLoadPage() {
        loginButton.shouldBe(visible);
        return this;
    }
}