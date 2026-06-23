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

public class EBankAppTest2 {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10L));
        this.driver.get("https://qaebank.ccbp.tech/ebank/login");
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void testLoginWithEmptyInputs(){
        WebElement userId = this.driver.findElement(By.id("userIdInput"));
        userId.sendKeys("");
        WebElement Pin = this.driver.findElement(By.id("pinInput"));
        Pin.sendKeys("");
        WebElement Loginbtn = this.driver.findElement(By.className("login-button"));
        Loginbtn.click();
        WebElement errorMsg = (WebElement)this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));
        String ExpectedText = "Invalid user ID";
        String actualText = errorMsg.getText();
        Assert.assertEquals(ExpectedText, actualText, "Error text with empty input fields");
    }
    @Test(priority = 2)
    public void testLoginWithEmptyUserId(){
        WebElement userId = this.driver.findElement(By.id("userIdInput"));
        userId.sendKeys("");
        WebElement Pin = this.driver.findElement(By.id("pinInput"));
        Pin.sendKeys("231225");
        WebElement Loginbtn = this.driver.findElement(By.className("login-button"));
        Loginbtn.click();
        WebElement errorMsg = (WebElement)this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));
        String ExpectedText = "Invalid user ID";
        String actualText = errorMsg.getText();
        Assert.assertEquals(ExpectedText, actualText, "Error text with empty User ID do not");
    }
    @Test(priority = 3)
    public void testLoginWithEmptyPin(){
        WebElement userId = this.driver.findElement(By.id("userIdInput"));
        userId.sendKeys("142420");
        WebElement Pin = this.driver.findElement(By.id("pinInput"));
        Pin.sendKeys("");
        WebElement Loginbtn = this.driver.findElement(By.className("login-button"));
        Loginbtn.click();
        WebElement errorMsg = (WebElement)this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));
        String ExpectedText = "Invalid PIN";
        String actualText = errorMsg.getText();
        Assert.assertEquals(ExpectedText, actualText, "Error text with empty PIN do not match");
    }
    @Test(priority = 4)
    public void testLoginWithInvalidCreds(){
        WebElement userId = this.driver.findElement(By.id("userIdInput"));
        userId.sendKeys("142420");
        WebElement Pin = this.driver.findElement(By.id("pinInput"));
        Pin.sendKeys("");
        WebElement Loginbtn = this.driver.findElement(By.className("login-button"));
        Loginbtn.click();
        WebElement errorMsg = (WebElement)this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-text")));
        String ExpectedText = "Invalid PIN";
        String actualText = errorMsg.getText();
        Assert.assertEquals(ExpectedText, actualText, "Error text with empty PIN do not match");
    }
    @Test(priority = 5)
    public void testLoginWithValidCreds(){
        WebElement userId = this.driver.findElement(By.id("userIdInput"));
        userId.sendKeys("142420");
        WebElement Pin = this.driver.findElement(By.id("pinInput"));
        Pin.sendKeys("231225");
        WebElement Loginbtn = this.driver.findElement(By.className("login-button"));
        Loginbtn.click();
        String ExpectedUrl = "https://qaebank.ccbp.tech/";
        this.wait.until(ExpectedConditions.urlToBe(ExpectedUrl));
        String actualUrl = this.driver.getCurrentUrl();
        Assert.assertEquals(ExpectedUrl, actualUrl, "URLs do not match");
    }
    @Test(priority = 6)
    public void testHomepageHeading(){
        WebElement userIdEl = driver.findElement(By.id("userIdInput"));
        userIdEl.sendKeys("142420");
        WebElement userPinEl = driver.findElement(By.id("pinInput"));
        userPinEl.sendKeys("231225");
        WebElement LoginBtnEl = driver.findElement(By.className("login-button"));
        LoginBtnEl.click();
        String expectedUrl = "https://qaebank.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        WebElement headingEl = driver.findElement(By.className("heading"));
        String actualHeading = headingEl.getText();
        String expectedHeading = "Your Flexibility, Our Excellence";
        Assert.assertEquals(actualHeading, expectedHeading, "Heading text does not match");
    }
    @Test(priority = 7)
    public void testLogoutFunctionality(){
        WebElement userIdEl = driver.findElement(By.id("userIdInput"));
        userIdEl.sendKeys("142420");
        WebElement userPinEl = driver.findElement(By.id("pinInput"));
        userPinEl.sendKeys("231225");
        WebElement LoginBtnEl = driver.findElement(By.className("login-button"));
        LoginBtnEl.click();
        String expectedUrl = "https://qaebank.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        WebElement logoutBtn = driver.findElement(By.className("logout-button"));
        logoutBtn.click();
        String expectedLoginUrl = "https://qaebank.ccbp.tech/ebank/login";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedLoginUrl, "Login URL do not match");
    }
}
