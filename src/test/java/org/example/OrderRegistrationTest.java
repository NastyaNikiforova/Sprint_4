package org.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderRegistrationTest extends BaseTest {

    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final String date;
    private final int rentalPeriod;
    private final String color;
    private final String comment;

    public OrderRegistrationTest(String name, String surname, String address, String metroStation, String phoneNumber,
                                 String date, int rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderDetails() {
        return new Object[][] {
                {"Андрей", "Белый", "Москва, ул Андрея Белого", "Тургеневская", "+79059059050", "1 февраля 2024", 7, "grey", "домофон не работает"},
                {"Александр", "Превосходный", "Москва, Козицкий переулок", "Лубянка", "56565656565", "1 февраля 2024", 3, "black", "domofon po nomeru kvartiry"},
                {"Ирина", "Иванова", "Балашиха, улица Советская", "Новокосино", "89995556644", "15 марта 2024", 5, "grey", "позвоните за час"},
                {"Ivan", "Kazakov", "Korolyov, Zvezdny prospect", "Комсомольсская", "+79059059", "4 февраля 2024", 1, "grey", "-"},
        };
    }

    @Test // заказ через кнопку "Заказать" в хэддере
    public void orderRegistration() {
        StartOrderButton objStartOrder = new StartOrderButton(driver);
        objStartOrder.clickHeaderOrderButton(); // клик на кнопку "Заказать" в хэддере
        OrderClientData objClientData = new OrderClientData(driver);
        objClientData.setClientData (name, surname, address, metroStation, phoneNumber);
        OrderData objOrderData = new OrderData(driver);
        objOrderData.setData(date, rentalPeriod, color, comment);
        objOrderData.clickConfirmationButton();
        objOrderData.waitCreatedOrderWindow();
    }
}