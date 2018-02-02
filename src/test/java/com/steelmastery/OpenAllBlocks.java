package com.steelmastery;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class OpenAllBlocks {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
//        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
//        System.setProperty("webdriver.gecko.driver", "/home/youser/Opencart/Tests/geckodriver");
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://local.steel-mastery.com/account/account");
    }
    @Test
    public void onMainPage() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".text-hidden")).getAttribute("class").contains("open"));
    }
    @Test
    public void onProductPage() {
//        driver.findElement(By.cssSelector("strong")).click();
//        driver.findElement(By.linkText("Homemade soap")).click();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(By.xpath("//div[2]/a/div/div/div[2]")).click();
        driver.get("https://local.steel-mastery.com/homemade-natural-craft-scrub-soap-with-coffee-and-cocoa.html");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElement(By.cssSelector(".text-hidden")).getAttribute("class").contains("open"));
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
