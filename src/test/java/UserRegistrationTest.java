import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import constants.*;

public class UserRegistrationTest extends BaseTestActions {

    @Test
    @DisplayName("Регистрация пользователя - позитивный кейс")
    public void testPositiveRegistration() {
        driver.get(Base.BASE_URL);
        mainPage.clickLoginButton();
        loginPage.clickRegistrationLink();
        registrationPage.waitForLoadRegister();
        registrationPage.registerUser(user.getName(), user.getEmail(), user.getPassword());
        loginPage.waitForLoadLoginPage();
        loginPage.logInUser(user.getEmail(), user.getPassword());
        mainPage.waitForLoadMain();
        Assert.assertTrue("Элемент отсутствует", driver.findElement(mainPage.inscriptionMakeBurger).isDisplayed());
    }

    @Test
    @DisplayName("Регистрация пользователя - негативный кейс")
    public void testNegativeRegistration() {
        driver.get(Base.BASE_URL);
        mainPage.clickLoginButton();
        loginPage.clickRegistrationLink();
        registrationPage.waitForLoadRegister();
        registrationPage.registerUser(user.getName(), user.getEmail(), "pass");
        Assert.assertTrue("Текст с ошибкой отсутствует", driver.findElement(registrationPage.uncorrectPasswordText).isDisplayed());

    }
}