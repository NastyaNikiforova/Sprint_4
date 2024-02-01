package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

 класс выпадающего списка "Вопросы о важном"
public class HomePageFAQ extends BasePage {
        //кнопки выпадающего списка "Вопросы о важном"
        private By accordionButton = By.className("accordion__button");

        public HomePageFAQ(WebDriver driver) {
                super(driver);
        }


        //метод, пролистывающий страницу до раздела "Вопросы о важном"
        public void scrollToFAQSection() {
                WebElement FAQSection = driver.findElement(nextButton);
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", FAQSection);
        }
        public void clickAccordionButton(){
            // for (int i = 0; i <=7; i++) как пройтись по всем кнопкам выпадающего списка?
            driver.findElement(accordionButton).click();
        }

}

//    @Parameterized.Parameters
//    public static Object[][] expectedAnswersParamList() {
//        return new Object[][]{
//                {"accordion__heading-0", "accordion__panel-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
//               ...
//        };
//
//        new MainList(driver);
//        String ActualAnswerText = driver.findElement(By.id(answer)).getText();
//        assertEquals("Ошибка! Текст в ответе не соответствует ожидаемому тексту.", text, ActualAnswerText);
//    }