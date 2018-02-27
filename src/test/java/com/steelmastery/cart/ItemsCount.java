package com.steelmastery.cart;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemsCount {
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
    public void t1_existance() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("span.right-menu__num")).click();
        driver.findElement(By.xpath("//div[@id='top-cart']/ul/form/li/div[2]/span/i")).click();
        driver.findElement(By.xpath("//div[@id='top-cart']/ul/form/li/div[2]/span[3]")).click();
        driver.findElement(By.name("quantity[92]")).click();
    }

    @Test
    public void t2_plus() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.findElement(By.name("quantity[92]")).getAttribute("value"));
     int currCount = Integer.parseInt(driver.findElement(By.name("quantity[92]")).getAttribute("value"));
        driver.findElement(By.xpath("//div[@id='top-cart']/ul/form/li/div[2]/span[3]")).click();
     int newCount = Integer.parseInt(driver.findElement(By.name("quantity[92]")).getAttribute("value"));
     Assert.assertTrue(newCount > currCount);
    }

    @Test
    public void t3_minus() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     int currCount = Integer.parseInt(driver.findElement(By.name("quantity[92]")).getAttribute("value"));
        driver.findElement(By.xpath("//div[@id='top-cart']/ul/form/li/div[2]/span/i")).click();
     int newCount = Integer.parseInt(driver.findElement(By.name("quantity[92]")).getAttribute("value"));
     Assert.assertTrue(newCount <= currCount);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
