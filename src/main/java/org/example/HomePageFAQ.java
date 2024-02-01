package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// класс выпадающего списка "Вопросы о важном"
public class HomePageFAQ extends BasePage {
        //локаторы кнопок выпадающего списка "Вопросы о важном"
        private final By questionsButton = By.className("accordion__item");
        //локаторы текста с кнопок
        private final By questionsText = By.className("accordion__button");
        //локаторы текста ответов
        private final By answersText = By.className("accordion__panel");
        public HomePageFAQ(WebDriver driver) {
                super(driver);
        }


        //метод, пролистывающий страницу до раздела "Вопросы о важном"
        public void scrollToFAQSection() {
                WebElement FAQSection = driver.findElement(By.className("Home_FAQ__3uVm4"));
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", FAQSection);
        }
        //метод, кликающий по кнопке с вопросом
        public void clickButtonWithQuestion(int index){
            driver.findElements(questionsButton).get(index).click();
        }
        //метод, получающий текст вопроса
        public String getQuestionText(int index) {
            return driver.findElements(questionsText).get(index).getText();
        }
        //метод, получающий текст ответа
        public String getAnswerText(int index) {
                return driver.findElements(answersText).get(index).getText();
        }

}
