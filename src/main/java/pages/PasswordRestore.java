package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
    
public class PasswordRestore {
    private final WebDriver driver;
    
    public PasswordRestore(WebDriver driver) {
        this.driver = driver;
    }
    
    //Локаторы
    //Ссылка "Войти"
    private final By loginLink = By.xpath(".//div/p/a[@href='/login' and text()='Войти']");
    //Заголовок "Восстановление пароля"
    public final By passwordRestore = By.xpath(".//main/div/h2[text()='Восстановление пароля']");
    
        @Step("Метод ожидания загрузки страницы восстановления пароля")
        public PasswordRestore waitForLoadRestore() {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(passwordRestore));
            return this;
        }
    
        @Step("Нажатие на гиперссылку Войти")
        public void clickLoginLink() {
            driver.findElement(loginLink).click();
        }
    }