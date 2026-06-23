package com.testing.comprehensive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import org.testng.Assert;
public class LogInPageTest {
    public WebDriver driver;

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
                { "praneetha", "praneetha@2021" },
                { "rahul", "rahul@2021" }

        };
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulnxttrendz.ccbp.tech/login");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1, dataProvider = "loginData")
    public void loginWithValidCredentials(String username, String password) {

        WebElement usernameEl = driver.findElement(By.id("username"));
        usernameEl.sendKeys(username);

        WebElement passwordEl = driver.findElement(By.id("password"));
        passwordEl.sendKeys(password);

        WebElement loginButtonEl = driver.findElement(By.className("login-button"));
        loginButtonEl.submit();

        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs do not match");
    }

    @Test(priority = 2)
    public void loginWithInvalidCredentials() {

        WebElement usernameEl = driver.findElement(By.id("username"));
        usernameEl.sendKeys("rahul");

        WebElement passwordEl = driver.findElement(By.id("password"));
        passwordEl.sendKeys("rahul@2022");

        WebElement loginButtonEl = driver.findElement(By.className("login-button"));
        loginButtonEl.submit();

        // Wait for the Error message to be loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Wait until elements are displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));

        WebElement errorMessageEl = driver.findElement(By.className("error-message"));

        String errorMessage = errorMessageEl.getText();

        Assert.assertEquals(errorMessage, "*username and password didn't match");


    }

}
