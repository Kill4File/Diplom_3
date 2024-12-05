package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Registration {
    private final WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    //Локатор
    //Перехода на страницу "Регистрация"
    public final By registrationPage = By.xpath(".//div/h2[text()='Регистрация']");
    //Поля "Имя"
    private final By nameField = By.xpath(".//div[./label[text()='Имя']]/input[@name='name']");
    //Поля "Email"
    private final By emailField = By.xpath(".//div[./label[text()='Email']]/input[@name='name']");
    //Поля "Пароль"
    private final By passwordField = By.xpath(".//div[./label[text()='Пароль']]/input[@name='Пароль']");
    //Кнопка "Зарегистрироваться"
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //Текст "Некорректный пароль"
    public final By uncorrectPasswordText = By.className("input__error");
    //Ссылка "Войти"
    private final By loginLink = By.xpath(".//div/p/a[@href='/login' and text()='Войти']");

    @Step("Заполняем поле 'Имя'")
    public void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Заполняем поле 'Email'")
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполняем поле 'Пароль'")
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Нажатие на гиперссылку Войти")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    @Step("Ожидание загрузки страницы регистрации")
    public Registration waitForLoadRegister() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(registrationPage));
        return this;
    }

    @Step("Заполняем форму регистрации")
    public void registerUser(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegistrationButton();
    }
}