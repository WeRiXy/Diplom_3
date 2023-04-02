package ui.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

public class ConstructorPage extends BasePageClass{
    @FindBy(how = How.XPATH,using = "//button[text()='Войти в аккаунт']")
    private SelenideElement accountButton;
    @FindBy(how = How.XPATH,using = "//button[text()='Оформить заказ']")
    private SelenideElement createOrderButton;
    @FindBy(how = How.XPATH,using = "//*[text()='Соберите бургер']")
    private SelenideElement burgerText;
    @FindBy(how = How.XPATH,using = "//span[text()='Булки']/parent::div")
    private SelenideElement bunsSection;
    @FindBy(how = How.XPATH,using = "//span[text()='Соусы']/parent::div")
    private SelenideElement sousesSection;
    @FindBy(how = How.XPATH,using = "//span[text()='Начинки']/parent::div")
    private SelenideElement fillingsSection;
    @FindBy(how = How.XPATH,using = "//section[contains(@class,'BurgerIngredients')]//div[contains(@class,'current')]")
    private SelenideElement selectedSection;

    @Step("Wait until is displayed button create order")
    public void waitUntilDisplayedCreateOrderButton() { createOrderButton.shouldBe(visible); }

    @Step("Get options selected burger section")
    public String getOptionsOfSelectedBurgerSection () {
        return selectedSection.getCssValue("box-shadow");
    }

    @Step("Click logging button")
    public LoginPage clickAccountButton () {
        accountButton.click();
        return loadLoginPage();
    }

    @Step("Click on buns section")
    public ConstructorPage clickBunsSection () {
        bunsSection.click();
        return this;
    }

    @Step("Click on souses section")
    public ConstructorPage clickSousesSection () {
        sousesSection.click();
        return this;
    }

    @Step("Click on fillings section")
    public ConstructorPage clickFillingsSection () {
        fillingsSection.click();
        return this;
    }

    @Step("Wait until active buns section")
    public ConstructorPage waitUntilSelectedBunsSection(String options) {
        bunsSection
                .shouldHave(attributeMatching("class",".*current.*"))
                .should(match("wait focused",bunsSection -> bunsSection.getCssValue("box-shadow").equals(options)), Duration.ofSeconds(30));
        return this;
    }

    @Step("Wait until active souses section")
    public ConstructorPage waitUntilSelectedSousesSection(String options) {
        sousesSection
                .shouldHave(attributeMatching("class",".*current.*"))
                .should(match("wait focused",sousesSection -> sousesSection.getCssValue("box-shadow").equals(options)), Duration.ofSeconds(30));
        return this;
    }

    @Step("Wait until active fillings section")
    public ConstructorPage waitUntilSelectedFillingsSection(String options) {
        fillingsSection
                .shouldHave(attributeMatching("class",".*current.*"))
                .should(match("wait focused",fillingsSection -> fillingsSection.getCssValue("box-shadow").equals(options)), Duration.ofSeconds(30));
        return this;
    }

    @Override
    public ConstructorPage waitForLoadPage() {
        burgerText.shouldBe(visible);
        return this;
    }
}