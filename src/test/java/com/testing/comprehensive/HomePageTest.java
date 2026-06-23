package com.testing.comprehensive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest {
    public WebDriver driver;
    public WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulnxttrendz.ccbp.tech/login");
        // usename element
        WebElement usernameEl = driver.findElement(By.id("username"));
        usernameEl.sendKeys("rahul");
        // password element
        WebElement passwordEl = driver.findElement(By.id("password"));
        passwordEl.sendKeys("rahul@2021");
        // button element
        WebElement buttonEl = driver.findElement(By.className("login-button"));
        buttonEl.click();
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void ClickShopNowButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shop-now-button")));
        WebElement shopnowbutton = driver.findElement(By.className("shop-now-button"));
        shopnowbutton.click();
        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/products";
        String currentUrl = driver.getCurrentUrl();
        if(expectedUrl.equals(currentUrl));
        Assert.assertEquals(expectedUrl,currentUrl,"URL'S do not match");

    }
    @Test
    public void CheckHeadingElement(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-heading")));
        WebElement HeadingEl = driver.findElement(By.className("home-heading"));
        Assert.assertTrue(HeadingEl.isDisplayed(),"Element is not displayed");
    }
}
