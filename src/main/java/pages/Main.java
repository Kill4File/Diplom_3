package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Main {
    private final WebDriver driver;

    public Main(WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы
    //Главная страница отображается
    private final By stellarBurgerMain = By.xpath(".//h1[text()='Соберите бургер']");
    //Кнопка "Войти в аккаунт"
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка "Личный кабинет"
    private final By accountButton = By.xpath(".//a[@href='/account']");
    //Кнопка перехода к разделу "Булки"
    private final By bunsButton = By.xpath(".//span[@class='text text_type_main-default'][text()='Булки']");
    //Кнопка перехода к разделу "Соусы"
    private final By sauceButton = By.xpath(".//span[@class='text text_type_main-default'][text()='Соусы']");
    //Кнопка перехода к разделу "Начинки"
    private final By fillingButton = By.xpath(".//span[@class='text text_type_main-default'][text()='Начинки']");
    //Текущего раздела
    private final By currentSection = By.xpath("//div[starts-with(@class, 'tab_tab__1SPyG tab_tab_type_current__2BEPc')]//span");
    //Надпись "Соберите бургер"
    public final By inscriptionMakeBurger = By.xpath(".//h1[text()='Соберите бургер']");


    @Step("Ожидание загрузки главной страницы")
    public void waitForLoadMain() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(stellarBurgerMain));
    }

    @Step("Нажатие на кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажатие на кнопку'Личный кабинет'")
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    @Step("Нажатие на кнопку 'Булки'")
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }

    @Step("Нажатие на кнопку 'Соусы'")
    public void clickSauceButton() {
        driver.findElement(sauceButton).click();
    }

    @Step("Нажатие на кнопку 'Начинки'")
    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }

    @Step("Узнаём в каком разделе находимся")
    public String getTextCurrentSection() {
        return driver.findElement(currentSection).getText();
    }
}