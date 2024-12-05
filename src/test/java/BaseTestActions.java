
import user.*;
import constants.*;
import webdriver.*;
import pages.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTestActions extends WebDrivers {

    public User user;
    public String accessToken;
    WebDriver driver;
    Main mainPage;
    Login loginPage;
    Registration registrationPage;
    Account accountPage;
    PasswordRestore passwordRestorePage;

     @Before
    public void setUp() {
        WebDrivers browserPage = new WebDrivers();
        driver = browserPage.getWebdriver("chrome");
        driver.get(Base.BASE_URL);
        user = User.makeUser();
        UserActions.createUser(user);
        mainPage = new Main(driver);
        loginPage = new Login(driver);
        registrationPage = new Registration(driver);
        accountPage = new Account(driver);
        passwordRestorePage = new PasswordRestore(driver);
    }

    @After
    public void cleanUp() {
        if (accessToken != null) {
            UserActions.deleteUser(accessToken);
        }
        driver.quit();
    }
}