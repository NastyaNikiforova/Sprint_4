package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        String browser = System.getenv("BROWSER");
        driver = getDriver(browser == null ? "chrome" : browser);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        setCookie(new Cookie("Cartoshka", "true"));
        setCookie(new Cookie("Cartoshka-legacy", "true"));
    }

    private void setCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
    }
    @After
    public void teardown() {
        driver.quit();
    }

    private WebDriver getDriver(String browser) {

       switch (browser.toLowerCase()) {
           case "chrome":
               // WebDriverManager.chromedriver().setup();
               return new ChromeDriver();
           case "yandex":
               System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
               return new ChromeDriver();
           case "firefox":
               System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
               return new FirefoxDriver();
           default:
               throw new IllegalArgumentException("Unsupported browser");
       }
    }
}