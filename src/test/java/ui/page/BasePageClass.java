package ui.page;

import static com.codeborne.selenide.Selenide.page;

public abstract class BasePageClass {
    public abstract <T> T waitForLoadPage();

    public HeaderPage loadHeaderPage() {
        return page(HeaderPage.class).waitForLoadPage();
    }

    public LoginPage loadLoginPage() {
        return page(LoginPage.class).waitForLoadPage();
    }

    public ConstructorPage loadConstructorPage() {
        return page(ConstructorPage.class).waitForLoadPage();
    }

    public PasswordRecoveryPage loadPasswordRecoveryPage() { return page(PasswordRecoveryPage.class).waitForLoadPage(); }

    public ProfilePage loadProfilePage() {
        return page(ProfilePage.class).waitForLoadPage();
    }

    public RegistryPage loadRegistryPage() {
        return page(RegistryPage.class).waitForLoadPage();
    }

    public boolean isLoadPage(Class<? extends BasePageClass> page) { page(page).waitForLoadPage(); return true; }
}