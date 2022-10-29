package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class OrderPage {
    private WebDriver driver;
    // заголовок форма заказа (для кого)
    private final By orderTitleForWho = By.className("Order_Header__BZXOb");
    // Имя
    private final By orderName = By.xpath(".//div[@class='Order_Form__17u6u']/div[1]/input");
    // Фамилия
    private final By orderSurname = By.xpath(".//div[@class='Order_Form__17u6u']/div[2]/input");
    // Адрес
    private final By orderAddress = By.xpath(".//div[@class='Order_Form__17u6u']/div[3]/input");
    // Метро инпут + пункты выбора (в конструкторе)
    private final By orderMetro = By.xpath(".//input[@class='select-search__input']");
    private final By orderMetroSelect;
    // Телефон
    private final By orderPhone = By.xpath(".//div[@class='Order_Form__17u6u']/div[5]/input");
    // Кнопка Далее
    private final By buttonNext = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");
    // заголовок форма заказа (Про аренду)
    private final By orderTitleAboutRent = By.className("Order_Header__BZXOb");
    // дата поставки + пункты выбора (в конструкторе)
    private final By orderDate = By.xpath(".//div[@class='Order_Form__17u6u']/div[1]//input");
    private final By orderDateSelect;
    // Срок  + пункты выбора (в конструкторе)
    private final By orderPeriod = By.xpath(".//div[@class='Order_Form__17u6u']/div[2]/div/div[1]");
    private final By orderPeriodSelect;
    // Цвет пункты выбора (в конструкторе)
    private final By orderColor;
    // Коммент
    private final By orderComment = By.xpath(".//div[@class='Order_Form__17u6u']/div[4]/input");
    // Кнопка Заказать
    private final By buttonOrderBy = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");
    // Модальное окно подтверждения - заголовок + кнопка да
    private final By orderAcceptTitle = By.className("Order_ModalHeader__3FDaJ");
    private final By orderAcceptButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Да']");
    // Модальное окно инфо - заголовок, текст + кнопка Посмотреть статус
    private final By orderInfoTitle = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_ModalHeader__3FDaJ']");
    private final By orderInfoInfo = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_ModalHeader__3FDaJ']/div");
    private final By orderInfoButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']//button[text()='Посмотреть статус']");


    public OrderPage(WebDriver driver, String userMetro, String userDate, String userPeriod, String userColor) {
        this.driver = driver;
        this.orderMetroSelect = By.xpath(".//div[@class='select-search__select']//div[text()='" + userMetro + "']/parent :: button");
        this.orderDateSelect = By.xpath(".//div[contains(@aria-label, '" + userDate + "')]");
        this.orderPeriodSelect = By.xpath(".//div[@class='Dropdown-option'  and text()='" + userPeriod + "']");
        this.orderColor = By.xpath(".//label[@class='Checkbox_Label__3wxSf' and text()='" + userColor + "']");
    }

    public void checkOrderPageForWho() {
        String title = "Для кого самокат";
        assertEquals(title, driver.findElement(orderTitleForWho).getText());
    }

    public void checkOrderPageAboutRent() {
        String title = "Про аренду";
        assertEquals(title, driver.findElement(orderTitleAboutRent).getText());
    }

    public void setOrderName(String userName) {
        driver.findElement(orderName).sendKeys(userName);
    }

    public void setOrderSurname(String userSurname) {
        driver.findElement(orderSurname).sendKeys(userSurname);
    }

    public void setOrderAddress(String userAddress) {
        driver.findElement(orderAddress).sendKeys(userAddress);
    }

    public void setOrderMetro() {
        driver.findElement(orderMetro).click();
        driver.findElement(orderMetroSelect).click();
    }

    public void setOrderPhone(String userPhone) {
        driver.findElement(orderPhone).sendKeys(userPhone);
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void setOrderDate() {
        driver.findElement(orderDate).click();
        driver.findElement(orderDateSelect).click();
    }

    public void setOrderPeriod() {
        driver.findElement(orderPeriod).click();
        driver.findElement(orderPeriodSelect).click();
    }

    public void setOrderColor() {
        driver.findElement(orderColor).click();
    }

    public void setOrderComment(String userComment) {
        driver.findElement(orderComment).sendKeys(userComment);
    }

    public void clickButtonOrderBy() {
        driver.findElement(buttonOrderBy).click();
    }

    public void checkOrderAcceptTitle() {
        String title = "Хотите оформить заказ?\n" +
                " ";
        assertEquals(title, driver.findElement(orderAcceptTitle).getText());
    }

    public void clickOrderAcceptButton() {
        driver.findElement(orderAcceptButton).click();
    }

    public void checkOrderPageInfoTitle() {
        String title = "Заказ оформлен";
        assertThat(driver.findElement(orderInfoTitle).getText(), startsWith(title));
    }

    public String getOrderNumberVariable() {
        String str = driver.findElement(orderInfoInfo).getText();
        String[] arrStr = str.split("\\.");
        return arrStr[0].substring(14);
    }

    public void clickOrderInfoButton() {
        driver.findElement(orderInfoButton).click();
    }

    public void setFormOrderForWho(String userName, String userSurname, String userAddress, String userPhone) {
        setOrderName(userName);
        setOrderSurname(userSurname);
        setOrderAddress(userAddress);
        setOrderMetro();
        setOrderPhone(userPhone);
    }

    public void setFormOrderAboutRent(String userComment) {
        setOrderDate();
        setOrderPeriod();
        setOrderColor();
        setOrderComment(userComment);
    }
}
