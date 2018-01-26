package com.steelmastery.account;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

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
    }
    @Test
    public void ordersHistory() {
        driver.findElement(By.cssSelector("span.right-menu__icon.icon-top_helmet")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("kingelessar@ukr.net");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("1111");
        driver.findElement(By.cssSelector("button.size-card__submit.basic-input")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("span.right-menu__icon.icon-top_helmet")).click();
        driver.findElement(By.linkText("My account")).click();

        driver.findElement(By.cssSelector("section .owl-stage .products-item > div.order-status"));
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
