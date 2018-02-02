package com.steelmastery.account;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.JVM)
public class OrdersHistory {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
//        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
//        System.setProperty("webdriver.gecko.driver", "/home/youser/Opencart/Tests/geckodriver");
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://local.steel-mastery.com/account/account");

        driver.findElement(By.cssSelector("span.right-menu__icon.icon-top_helmet")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("kingelessar@ukr.net");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("button.size-card__submit.basic-input")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.findElement(By.cssSelector("span.right-menu__icon.icon-top_helmet")).click();
//        driver.findElement(By.linkText("My account")).click();
    }
    @Test
    public void ordersHistory() {
        driver.get("https://local.steel-mastery.com/account/account");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        driver.findElement(By.xpath("//div/div/a/div"));
        driver.findElement(By.cssSelector("a > div.order-status"));
    }
    @Test
    public void orderDetails() {
        try {
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("div.order-status")).click();
            Thread.sleep(1000);
            Assert.assertEquals("Order Information", driver.findElement(By.cssSelector("h1")).getText());
            Assert.assertEquals("Order History", driver.findElement(By.cssSelector("h3")).getText());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
