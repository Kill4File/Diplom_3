package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Account {

    private final WebDriver driver;

    public Account(WebDriver driver) {
        this.driver = driver;
    }

    //Локаторы
    //Раздела смены персональных данных
    public final By profileInscription = By.xpath(".//nav/p[text()='В этом разделе вы можете изменить свои персональные данные']");
    //Кнопки "Выход"
    private final By exitButton = By.xpath(".//button[text()='Выход']");

    @Step("Ожидание загрузки страницы ЛК")
    public void waitForLoadAccount() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(profileInscription));
        driver.findElement(profileInscription);
    }

    @Step("Нажатие по кнопке Выйти")
    public void clickExitButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }
}