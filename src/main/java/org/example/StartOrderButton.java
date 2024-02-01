package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

// класс кнопок "Заказать"
public class StartOrderButton extends BasePage {

    //локатор кнопки "Заказать" в хэддере страницы
    private By headerOrderButton = By.xpath("//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");

    // локатор кнопки "Заказать" внизу страницы
    private By bottomOrderButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");

    public StartOrderButton(WebDriver driver) {
        super(driver);
    }

    // метод, нажимающий кнопку "Заказать" в хэддере
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
    // метод, нажимающий кнопку "Заказать" внизу страницы
    public void clickBottomOrderButton() {
        WebElement searchOrderButton = driver.findElement(bottomOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchOrderButton);
        driver.findElement(bottomOrderButton).click();
    }
}
