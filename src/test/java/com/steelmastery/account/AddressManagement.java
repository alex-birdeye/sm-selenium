package com.steelmastery.account;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.JVM)
public class AddressManagement {

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
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("span.right-menu__icon.icon-top_helmet")).click();
        driver.findElement(By.linkText("My account")).click();
    }
    @Test
    public void existance() {
        driver.findElement(By.cssSelector(".add-ress"));
    }
    @Test
    public void addAddress (){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int addrCountBefore = driver.findElements(By.cssSelector(".address")).size();
        System.out.println(addrCountBefore + " addresses found.");

        driver.findElement(By.cssSelector("div.add-ress-wrap > img")).click();
        driver.findElement(By.id("input-shipping-country")).click();
        driver.findElement(By.id("input-shipping-country")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.RETURN);
        driver.findElement(By.cssSelector("div.content-cols__right")).click();
        driver.findElement(By.id("input-shipping-city")).click();
        driver.findElement(By.id("input-shipping-city")).clear();
        driver.findElement(By.id("input-shipping-city")).sendKeys("NewCity");
//        new Select(driver.findElement(By.id("input-shipping-zone"))).selectByVisibleText("Badakhshan");
        driver.findElement(By.id("input-shipping-zone")).click();
        driver.findElement(By.id("input-shipping-zone")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.RETURN);
        driver.findElement(By.id("input-shipping-postcode")).click();
        driver.findElement(By.id("input-shipping-postcode")).clear();
        driver.findElement(By.id("input-shipping-postcode")).sendKeys(Long.toString(System.currentTimeMillis()));
        driver.findElement(By.id("input-shipping-address-1")).click();
        driver.findElement(By.id("input-shipping-address-1")).clear();
        driver.findElement(By.id("input-shipping-address-1")).sendKeys(Long.toString(System.currentTimeMillis()));
        driver.findElement(By.id("next")).click();
//
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int addrCountAfter = driver.findElements(By.cssSelector(".address")).size();
        Assert.assertTrue(addrCountAfter > addrCountBefore);
    }
    @Test
    public void deleteAddress () {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int addrCount = driver.findElements(By.cssSelector(".address")).size();
            driver.findElement(By.cssSelector("div.add-ress-wrap")).click();
            driver.findElement(By.id("delete-address")).click();
        if (addrCount > 1){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int addrCountAfter = driver.findElements(By.cssSelector(".address")).size();
            Assert.assertTrue(addrCountAfter < addrCount);
        } else {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Assert.assertEquals("Warning: You must have at least one address!", driver.findElement(By.cssSelector(".alert")).getText());
        }
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
