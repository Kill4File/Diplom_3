package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login {
    private final WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы
    //Кнопки "Конструктор"
    private final By constructorButton = By.xpath(".//a/p[text()='Конструктор']");
    //Кнопки "Логотип Stellar Burgers"
    private final By logoButton = By.xpath(".//div/a[@href='/']");
    //Заголовка "Вход"
    public final By headerEntrance = By.xpath(".//main/div/h2[text()='Вход']");
    //Поля "Email"
    private final By emailField = By.xpath(".//input[@name='name']");
    //Поля "Пароль"
    private final By passwordField = By.xpath(".//input[@name='Пароль']");
    //Кнопки "Войти"
    private final By entranceButton = By.xpath(".//button[text()='Войти']");
    //Cсылки "Зарегистрироваться"
    private final By registrationLink = By.xpath(".//a[@href='/register' and text()='Зарегистрироваться']");
    //Ссылки "Восстановить пароль"
    private final By passwordRestoreLink = By.xpath(".//a[@href='/forgot-password' and text()='Восстановить пароль']");

    @Step("Ожидание загрузки страницы 'Вход'")
    public Login waitForLoadLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> (driver.findElement(headerEntrance).getText() != null
                && !driver.findElement(headerEntrance).getText().isEmpty()
        ));
        return this;
    }

    @Step("Нажатие на кнопку 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажатие на лого 'Stellar Burger'")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }

    @Step("Метод заполняет поле 'Email'")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Метод заполняет поле 'Пароль'")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажатие на кнопку 'Войти'")
    public void clickEntranceButton() {
        driver.findElement(entranceButton).click();
    }

    @Step("Авторизация пользователя")
    public void logInUser(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickEntranceButton();
    }

    @Step("Нажатие на ссылку 'Зарегистрироваться'")
    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    @Step("Нажатие на ссылку 'Восстановить пароль'")
    public void clickPasswordRestoreLink() {
        driver.findElement(passwordRestoreLink).click();
    }
}