import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class LoginPageTest extends BaseTestActions {

    @Test
    @DisplayName("Вход по кнопке 'Войти в аккаунт' на главной")
    public void testEntranceLoginButton() {
        mainPage.clickLoginButton();
        loginPage.waitForLoadLoginPage();
        loginPage.logInUser(user.getEmail(), user.getPassword());
        mainPage.waitForLoadMain();

        Assert.assertTrue("Элемент отсутствует", driver.findElement(mainPage.inscriptionMakeBurger).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    public void testEntranceAccountButton() {
        mainPage.clickAccountButton();
        loginPage.logInUser(user.getEmail(), user.getPassword());
        mainPage.waitForLoadMain();
        Assert.assertTrue("Элемент отсутствует", driver.findElement(mainPage.inscriptionMakeBurger).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void testEntranceFromRegisterPage() {
        mainPage.clickAccountButton();
        loginPage.clickRegistrationLink();
        registrationPage.clickLoginLink();
        loginPage.logInUser(user.getEmail(), user.getPassword());
        mainPage.waitForLoadMain();
        Assert.assertTrue("Элемент отсутствует", driver.findElement(mainPage.inscriptionMakeBurger).isDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void testEntranceFromRecoveryPage() {
        mainPage.clickAccountButton();
        loginPage.clickPasswordRestoreLink();
        passwordRestorePage.waitForLoadRestore();
        passwordRestorePage.clickLoginLink();
        loginPage.logInUser(user.getEmail(), user.getPassword());
        mainPage.waitForLoadMain();
        Assert.assertTrue("Элемент отсутствует", driver.findElement(mainPage.inscriptionMakeBurger).isDisplayed());
    }

}