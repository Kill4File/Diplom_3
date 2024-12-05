import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class ConstructorTransitionsTest extends BaseTestActions {

    @Test
    @DisplayName("Переход в раздел 'Булки'")
    public void testTransitionSectionBuns() {
        mainPage.waitForLoadMain();
        mainPage.clickSauceButton();
        mainPage.clickBunsButton();
        Assert.assertEquals("Булки", mainPage.getTextCurrentSection());
    }

    @Test
    @DisplayName("Переход в раздел 'Соусы'")
    public void testTransitionSectionSauce() {
        mainPage.waitForLoadMain();
        mainPage.clickSauceButton();
        Assert.assertEquals("Соусы", mainPage.getTextCurrentSection());
    }

    @Test
    @DisplayName("Переход в раздел 'Начинки'")
    public void testTransitionSectionFillings() {
        mainPage.waitForLoadMain();
        mainPage.clickFillingButton();
        Assert.assertEquals("Начинки", mainPage.getTextCurrentSection());
    }
}