import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class AccountPageTransitionsTest extends BaseTestActions {

    @Test
    @DisplayName("Переход в личный кабинет по клику на 'Личный кабинет'")
    public void testTransitionToAccountPage() {
        mainPage.waitForLoadMain();
        mainPage.clickLoginButton();
        loginPage.waitForLoadLoginPage();
        Assert.assertTrue(driver.findElement(loginPage.headerEntrance).isDisplayed());
    }

    @Test
    @DisplayName("Переход из ЛК в конструктор")
    public void testTransitionFromAccountPageToConstructor() {
        mainPage.waitForLoadMain();
        mainPage.clickLoginButton();
        loginPage.waitForLoadLoginPage();
        loginPage.clickConstructorButton();
        mainPage.waitForLoadMain();
        Assert.assertTrue(driver.findElement(mainPage.inscriptionMakeBurger).isDisplayed());
    }

    @Test
    @DisplayName("Переход по нажатию на логотип Stellar Burgers")
    public void testTransitionFromAccountPageToMainPageViaLogo() {
        mainPage.clickLoginButton();
        loginPage.waitForLoadLoginPage();
        loginPage.clickLogoButton();
        mainPage.waitForLoadMain();
        Assert.assertTrue(driver.findElement(mainPage.inscriptionMakeBurger).isDisplayed());
    }

    @Test
    @DisplayName("Выход из личном кабинета по кнопке 'Выйти'")
    public void testExitAccountPage() {
        mainPage.clickAccountButton();
        loginPage.waitForLoadLoginPage();
        loginPage.logInUser(user.getEmail(), user.getPassword());
        mainPage.waitForLoadMain();
        mainPage.clickAccountButton();
        accountPage.waitForLoadAccount();
        accountPage.clickExitButton();
        loginPage.waitForLoadLoginPage();
        Assert.assertTrue(driver.findElement(loginPage.headerEntrance).isDisplayed());
    }
}