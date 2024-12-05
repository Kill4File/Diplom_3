package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Locale;

public class WebDrivers {

    public WebDriver getWebdriver(String browserName) {
        switch (browserName.toLowerCase(Locale.ROOT)) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/res/chromedriver.exe");
                return new ChromeDriver();
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/res/yandexdriver.exe");
                return new ChromeDriver();
            default:
                throw new IllegalArgumentException("invalid browser name" + browserName);
        }
    }
}
