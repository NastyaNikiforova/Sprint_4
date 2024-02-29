package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


//класс страницы с контактными данными пользователя
class OrderClientData extends BasePage {
    // локатор поля ввода "Имя"
    private By nameField = By.xpath("//input[@placeholder='* Имя']");

    // локатор поля ввода "Фамилия"
    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']");

    // локатор поля ввода "Адрес"
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // локатор выпадающего списка "Станции метро"
    private By metroField = By.xpath("//input[@placeholder='* Станция метро']");

    // локатор поля ввода "Телефон"
    private By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // локатор кнопки "Далее"
    private By nextButton = By.xpath("//button[text()='Далее']");

    public OrderClientData(WebDriver driver) {
        super(driver);
    }

    // метод, заполняющий поле Имя
    private void setName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // метод, заполняющий поле Фамилия
    private void setSurname(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    // метод, заполняющий поле Адрес
    private void setAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    // метод, заполняющий поле Станция метро
    private void setMetroStation(String metroStation) {
        driver.findElement(metroField).click();
        final String metroTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        String selectMetroStation = String.format(metroTemplate, metroStation);
        WebElement searchMetroStation = driver.findElement(By.xpath(selectMetroStation));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchMetroStation);
        driver.findElement(By.xpath(selectMetroStation)).click();
    }

    // метод, заполняющий поле Телефон
    private void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    // метод, нажимающий кнопку "Далее"
    private void clickNextButton() {
        WebElement button = driver.findElement(nextButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
        driver.findElement(nextButton).click();
    }

    // метод, заполняющий поля и нажимающий кнопку "Далее"
    public void setClientData(String name, String surname, String address, String metroStation, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
        clickNextButton();
    }
}





