package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//////////////////////////////////////////////////////////////////////////////
//Старое решение с драйверами из папки с проектом
//
// public class WebDrivers {
//     public WebDriver getWebdriver(String browserName) {
//         switch (browserName.toLowerCase(Locale.ROOT)) {
//             case "chrome":
//                 System.setProperty("webdriver.chrome.driver", "src/test/res/chromedriver.exe");
//                 return new ChromeDriver();
//             case "yandex":
//                 System.setProperty("webdriver.chrome.driver", "src/test/res/yandexdriver.exe");
//                 return new ChromeDriver();
//             default:
//                 throw new IllegalArgumentException("invalid browser name" + browserName);
//         }
//     }
// }
//////////////////////////////////////////////////////////////////////////////


//Новое решение с выбором браузера из системной переменной и т.п
public class WebDrivers {

    public static WebDriver createWebDriver() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            return createChromeDriver();
        }

        switch (browser) {
            case "yandex":
                return createYandexDriver();
            case "chrome":
            default:
                return createChromeDriver();
        }
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }

    private static WebDriver createYandexDriver() {
        System.setProperty("webdriver.chrome.driver",
        String.format("%s/%s", System.getenv("WEBDRIVERS"),
        System.getenv("YANDEX_BROWSER_DRIVER_FILENAME")));

        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getenv("YANDEX_BROWSER_PATH"));
        return new ChromeDriver(options);
    }

}