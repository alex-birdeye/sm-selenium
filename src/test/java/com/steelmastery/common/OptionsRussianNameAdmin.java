package com.steelmastery.common;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OptionsRussianNameAdmin {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
//        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "/home/youser/Opencart/Tests/geckodriver");
//          driver = new ChromeDriver();
        driver = new FirefoxDriver();
//        driver.manage().window().maximize();

        /* Start test in mobile device mode */
//        Map<String, String> mobileEmulation = new HashMap<String, String>();
//        mobileEmulation.put("deviceName", "Nexus 5");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
//        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://local.steel-mastery.com/admin/index.php?route=catalog/option");
    }
    @Test
    public void existance() {
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys("a20170023");
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("I6l6Q4l2");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//form[@id='form-option']/div/table/tbody/tr/td[4]/a")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.name("option_description[1][rus_name]")).click();
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
