package ui.uitests;

import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ui.page.ConstructorPage;
import ui.page.PasswordRecoveryPage;
import ui.settings.Browser;

import static com.codeborne.selenide.Selenide.*;
import static ui.constants.URL.MAIN;

@Feature(value = "Clicking on links")
public class SectionTransitionsConstructorTest extends Browser {

    @Test
    @DisplayName("Check open sections of constructor")
    public void openSectionConstructor() {
        String optionsOfSelectedBurgerSection = open(MAIN, ConstructorPage.class).getOptionsOfSelectedBurgerSection();

        page(ConstructorPage.class)
                .clickSousesSection().shouldBeSelectedSousesSection(optionsOfSelectedBurgerSection)
                .clickFillingsSection().shouldBeSelectedFillingsSection(optionsOfSelectedBurgerSection)
                .clickBunsSection().shouldBeSelectedBunsSection(optionsOfSelectedBurgerSection);
    }
}