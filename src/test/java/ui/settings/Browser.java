package ui.settings;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Browser {
    private enum Driver{ YANDEX, CHROME }
    private static final String PATH_YANDEX_DRIVER = "src/test/resources/driver/yandexdriver.exe";
    private static final String PATH_CHROME_DRIVER = "src/test/resources/driver/chromedriver.exe";
    private Driver driver;

    {
         setYandexDriver();
        // setChromeDriver();
    }

    private void setYandexDriver() {
        System.setProperty("webdriver.chrome.driver", PATH_YANDEX_DRIVER);
        WebDriverRunner.setWebDriver(new ChromeDriver());
        driver = Driver.YANDEX;
    }
    private void setChromeDriver() {
        System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        driver = Driver.CHROME;
    }
    @After
    public void closeYaBrowser()
    {
        if(driver!= null && driver==Driver.YANDEX) {
            WebDriverRunner.closeWindow();
            WebDriverRunner.closeWebDriver();
        }
    }
}