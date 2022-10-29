package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class OrderStatusPage {

    private WebDriver driver;
    // Таблица заказа - номер заказа, имя, фамилия, адрес, метро, телефон, дата. переод, цвет и коммент
    private final By statusOrderNumber = By.xpath(".//div[@class='Track_Content__St6Kn']//input");
    private final By statusUserName = By.xpath(".//div[@class='Track_OrderInfo__2fpDL']/div[1]/div[2]");
    private final By statusUserSurname = By.xpath(".//div[@class='Track_OrderInfo__2fpDL']/div[2]/div[2]");
    private final By statusUserAddress = By.xpath(".//div[@class='Track_OrderInfo__2fpDL']/div[3]/div[2]");
    private final By statusUserMetro = By.xpath(".//div[@class='Track_OrderInfo__2fpDL']/div[4]/div[2]");
    private final By statusUserPhone = By.xpath(".//div[@class='Track_OrderInfo__2fpDL']/div[5]/div[2]");
    private final By statusUserDate = By.xpath(".//div[@class='Track_OrderInfo__2fpDL']/div[7]/div[2]");
    private final By statusUserPeriod = By.xpath(".//div[@class='Track_OrderInfo__2fpDL']/div[8]/div[2]");
    private final By statusUserColor = By.xpath(".//div[@class='Track_OrderInfo__2fpDL']/div[10]/div[2]");
    private final By statusUserComment = By.xpath(".//div[@class='Track_OrderInfo__2fpDL']/div[11]/div[2]");

    public OrderStatusPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkStatusOrderNumber(String orderNumber) {
        assertEquals(orderNumber, driver.findElement(statusOrderNumber).getAttribute("value"));
    }

    public void checkStatusUserName(String userName) {
        assertEquals(userName, driver.findElement(statusUserName).getText());
    }

    public void checkStatusUserSurname(String userSurname) {
        assertEquals(userSurname, driver.findElement(statusUserSurname).getText());
    }

    public void checkStatusUserAddress(String userAddress) {
        assertEquals(userAddress, driver.findElement(statusUserAddress).getText());
    }

    public void checkStatusUserMetro(String userMetro) {
        assertEquals(userMetro, driver.findElement(statusUserMetro).getText());
    }

    public void checkStatusUserPhone(String userPhone) {
        assertEquals(userPhone, driver.findElement(statusUserPhone).getText());
    }

    public void checkStatusUserDate(String userDate) {
        assertEquals(userDate, driver.findElement(statusUserDate).getText());
    }

    public void checkStatusUserPeriod(String userPeriod) {
        assertEquals(userPeriod, driver.findElement(statusUserPeriod).getText());
    }

    public void checkStatusUserColor(String userColor) {
        assertEquals(userColor, driver.findElement(statusUserColor).getText());
    }

    public void checkStatusUserComment(String userComment) {
        assertEquals(userComment, driver.findElement(statusUserComment).getText());
    }

    public void checkStatusOrderAll(String orderNumber, String userName, String userSurname, String userAddress, String userMetro, String userPhone, String userDate, String userPeriod, String userColor, String userComment) {
        checkStatusOrderNumber(orderNumber);
        checkStatusUserName(userName);
        checkStatusUserSurname(userSurname);
        checkStatusUserAddress(userAddress);
//        checkStatusUserMetro(userMetro);
        checkStatusUserPhone(userPhone);
//        checkStatusUserDate(userDate);
        checkStatusUserPeriod(userPeriod);
        checkStatusUserColor(userColor);
        checkStatusUserComment(userComment);
    }

}
