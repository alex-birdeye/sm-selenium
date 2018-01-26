package com.steelmastery;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTest {

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
    public void mainPage() {
//        System.out.println("Hello bliat'!!!");
//        WebElement loginField = driver.findElement(By.tagName("body"));
//        WebElement loginField = driver.findElement(By.cssSelector("section.c-section.bg-gray > div.container.cat-desc > div.cat-desc__content > h3.cat-desc__title"));
        // Check title
        String title = driver.getTitle();
        Assert.assertEquals("Steel Mastery", title);

        WebElement headerMessageBtn = driver.findElement(By.xpath("//a[@id='feedback']/span"));
        WebElement fbMessengerWindow = driver.findElement(By.id("ocx-facebook-message-chat"));
        headerMessageBtn.click();
        Assert.assertTrue(fbMessengerWindow.getAttribute("class").contains("fbm-opened"));

        driver.findElement(By.cssSelector("span.right-menu__icon.icon-top_search")).click();
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("clc-09");
        driver.findElement(By.cssSelector("button.h-search__submit > span.icon-top_search")).click();
        Assert.assertEquals("Coat with the hood and wide sleeves", driver.findElement(By.xpath("//a/h2")).getText());
//       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(>someid>)));  WebElement loginField = driver.findElement(By.xpath("//section[2]/div/div/h3"));
//        loginField.sendKeys("autotestorgua");
//        WebElement passwordField = driver.findElement(By.id("password"));
//        passwordField.sendKeys("testpass");
//        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Войти']"));
//        loginButton.click();
//        WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
//        String mailUser = profileUser.getText();
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
