package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class HomePage {
    private final WebDriver driver;
    // Заголовок главный
    private final By mainTitle = By.xpath(".//div[@class='Home_FirstPart__3g6vG']/div[@class='Home_Header__iJKdX']");
    // Кнопка заказать верх
    private final By buttonOrderByTop = By.xpath(".//div[@class='Header_Header__214zg']//button[@class='Button_Button__ra12g']");
    // Кнопка заказать низ
    private final By buttonOrderByBottom = By.xpath(".//div[@class='Home_ThirdPart__LSTEE']//button[contains(@class, 'Button_Button__ra12g')]");
    // панелька кук - кнопка
    private final By buttonCookiesAccept = By.className("App_CookieButton__3cvqF");
    // Вопросы о важном - заголовок и стрелочк вопрос-ответ (элементы в конструкторе)
    private final By questionsTitle = By.xpath(".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']");
    private By accordionItemsQuestion = null;
    private By accordionItemsAnswer = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage(WebDriver driver, String textQuestion) {
        this.driver = driver;
        this.accordionItemsQuestion = By.xpath(".//div[@class='Home_FourPart__1uthg']//div[@class='accordion']//div[text()='" + textQuestion + "']");
        this.accordionItemsAnswer = By.xpath(".//div[@class='Home_FourPart__1uthg']//div[@class='accordion']//div[text()='" + textQuestion + "']/..//parent :: div[@class=\"accordion__item\"]/div[2]/p");
    }

    public void checkHomePageMainTitle() {
        String title = "Самокат\n" +
                "на пару дней\n" +
                "Привезём его прямо к вашей двери,\n" +
                "а когда накатаетесь — заберём";
        assertEquals(title, driver.findElement(mainTitle).getText());
    }

    public void clickButtonCookiesAccept() {
        driver.findElement(buttonCookiesAccept).click();
    }

    public void clickButtonOrderBy(String button) {
        if (button.equals("Top")) {
            driver.findElement(buttonOrderByTop).click();
        } else if (button.equals("Bottom")) {
            driver.findElement(buttonOrderByBottom).click();
        }

    }

    public void checkOrderPageForWho() {
        String title = "Вопросы о важном";
        assertEquals(title, driver.findElement(questionsTitle).getText());
    }

    public void clickOnAccordionItems() {
        driver.findElement(accordionItemsQuestion).click();
    }

    public void waitForLoadAccordionItems() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(driver -> (driver.findElement(accordionItemsAnswer).getText() != null));
    }

    public void checkAccordionItems(String textAnswer) {
        assertEquals(textAnswer, driver.findElement(accordionItemsAnswer).getText());
    }
}