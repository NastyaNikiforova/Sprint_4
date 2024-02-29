package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;

// класс страницы данных об аренде
public class OrderData extends BasePage {

    //локатор поля ввода "Когда привезти самокат"
    private By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //локатор выпадающего списка "Срок аренды"
    private By rentalPeriodField = By.className("Dropdown-control");

    //локатор чекбокса "Цвет самоката"
    private By colorField = By.xpath("//input[@id='black']");

    //локатор поля ввода "Комментарий для курьера"
    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");

    //локатор кнопки "Заказать"
    private By finishOrderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //локатор кнопки "Да", подтверждающей заказ
    private By confirmationButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public OrderData(WebDriver driver) {
        super(driver);
    }

    //метод, заполняющий поле "Когда привезти самокат"
    private void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
        driver.findElement(dateField).sendKeys(Keys.ENTER);
    }

    //метод, заполняющий поле "Срок аренды"
    private void setRentalPeriod(int rentalPeriod) {
        driver.findElement(rentalPeriodField).click();
        final String rentalPeriodOption = String.format("//div[@class='Dropdown-menu']/div[@class='Dropdown-option'][%d]", rentalPeriod);
        driver.findElement(By.xpath(rentalPeriodOption)).click();
    }
    //метод, выбирающий цвет самоката
    private void setColor(String color) {
        final String selectColor = String.format(".//*[@id='%s']", color);
        driver.findElement(By.xpath(selectColor)).click();
    }
    //метод, заполняющий поле "Комментарий"
    private void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    //метод, нажимающий на кнопку "Заказать"
    private void clickFinishOrderButton() {
        driver.findElement(finishOrderButton).click();
    }
    //метод, заполняющий поля и нажимающий кнопку "Заказать"
    public void setData(String date, int rentalPeriod, String color, String comment) {
        setDate(date);
        setRentalPeriod(rentalPeriod);
        setColor(color);
        setComment(comment);
        clickFinishOrderButton();
    }
    //метод, подтверждающий оформление заказа
    public void clickConfirmationButton() {
        driver.findElement(confirmationButton).click();
    }
    //метод, ожидающий появления текста "Заказ оформлен" в модальном окне
    public void waitCreatedOrderWindow() {
        By element = By.className("Order_ModalHeader__3FDaJ");
        String expectedText = "Заказ оформлен";
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(element, expectedText));
    }
}
