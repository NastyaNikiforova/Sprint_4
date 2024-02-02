package org.example;

import org.junit.Test;

public class OrderBottomButtonTest extends BaseTest {

    @Test // заказ через кнопку "Заказать" внизу главной страницы (клик и ожидание загрузки формы заказа)
    public void orderRegistrationBottomButton() {
        StartOrderButton objStartOrder = new StartOrderButton(driver);
        objStartOrder.clickBottomOrderButton(); // клик на кнопку "Заказать" внизу главной страницы
        objStartOrder.waitOrderForm();
    }
}
