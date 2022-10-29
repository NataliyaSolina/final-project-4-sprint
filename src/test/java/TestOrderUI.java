import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pom.HomePage;
import pom.OrderPage;

import java.time.Duration;

import pom.OrderStatusPage;
import pom.Service;

import static java.lang.Thread.sleep;

@RunWith(Parameterized.class)
public class TestOrderUI {
    private WebDriver driver;
    private final String button;
    private final String userName;
    private final String userSurname;
    private final String userAddress;
    private final String userMetro;
    private final String userPhone;
    private final String userDateIn;
    private final String userDateOut;
    private final String userPeriod;
    private final String userColor;
    private final String userComment;

    public TestOrderUI(String button, String userName, String userSurname, String userAddress, String userMetro, String userPhone, String userDateIn, String userDateOut, String userPeriod, String userColor, String userComment) {
        this.button = button;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
        this.userMetro = userMetro;
        this.userPhone = userPhone;
        this.userDateIn = userDateIn;
        this.userDateOut = userDateOut;
        this.userPeriod = userPeriod;
        this.userColor = userColor;
        this.userComment = userComment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Top", "Ян", "Со", "Мир 5", "Лихоборы", "+79063680000",
                        Service.getTomorrowFormatIn(), Service.getTomorrowFormatOut(), "сутки", "чёрный жемчуг", "Без комментариев"},
                {"Bottom", "Маргарита Луиза", "Константинопальская", "Москва, бульвар Рокоссовского, дом 5, квартира 24", "Бульвар Рокоссовского", "89063680000",
                        Service.getTodayFormatIn(), Service.getTodayFormatOut(), "семеро суток", "серая безысходность", "Еще телефон +79063680001"}
        };
    }

    @Before
    public void createDriverOpenUrl() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void orderByTest() {
        HomePage objHomePage = new HomePage(driver);
        OrderPage objOrderPage = new OrderPage(driver, userMetro, userDateIn, userPeriod, userColor);
        OrderStatusPage objStatusOrderPage = new OrderStatusPage(driver);

        objHomePage.checkHomePageMainTitle();
        objHomePage.clickButtonCookiesAccept();
        objHomePage.clickButtonOrderBy(button);

        objOrderPage.checkOrderPageForWho();
        objOrderPage.setFormOrderForWho(userName, userSurname, userAddress, userPhone);
        objOrderPage.clickButtonNext();

        objOrderPage.checkOrderPageAboutRent();
        objOrderPage.setFormOrderAboutRent(userComment);
        objOrderPage.clickButtonOrderBy();

        objOrderPage.checkOrderAcceptTitle();
        objOrderPage.clickOrderAcceptButton();

        objOrderPage.checkOrderPageInfoTitle();
        String orderNumber = objOrderPage.getOrderNumberVariable();
        objOrderPage.clickOrderInfoButton();

        objStatusOrderPage.checkStatusOrderAll(orderNumber, userName, userSurname, userAddress, userMetro, userPhone, userDateOut, userPeriod, userColor, userComment);
        try {
            sleep(50000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

