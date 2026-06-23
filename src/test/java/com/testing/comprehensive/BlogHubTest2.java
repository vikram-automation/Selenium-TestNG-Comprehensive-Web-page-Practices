package com.testing.comprehensive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BlogHubTest2 {
    public WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikram\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://qabloghub.ccbp.tech/");
    }
    @Test(priority = 1)
    public void testBlogsCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.blogs-list li")));
        List<WebElement> blogitems = driver.findElements(By.cssSelector("ul.blogs-list li"));
        int count = 1;
        for(int i=1;i<blogitems.size();i++){
            count++;

        }
        if(count==10){
            System.out.println("10 blogs are displayed");
        }else{
            System.out.println("Few blogs missing...");
        }
    }
    @Test(priority = 2)
    public void testBlogTitles(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.blogs-list li"))).getText();
        List<WebElement> BlogHeading = driver.findElements(By.cssSelector("img[class$='image']+div h1"));
        String[] expectedorder =
                {"React v16.9.0 and the Roadmap Update",
                        "React v16.7: No, This Is Not the One With Hooks",
                        "Building Great User Experiences with Concurrent Mode and Suspense",
                        "Introducing The Problem Solver React v17.0",
                        "What about the React v16.13.0 That we Developed",
                        "React v16.4.2: Server-side vulnerability fix",
                        "Introducing Zero-Bundle-Size React Server Components",
                        "Introducing the New JSX Transform",
                        "Introducing the New React DevTools",
                        "Sneak Peek: Beyond React 16"

                };
        for(int i=0;i<BlogHeading.size();i++){
            WebElement order = BlogHeading.get(i);
            String Title = order.getText();
            Assert.assertEquals(Title,expectedorder[i],"Mismatch found in blog titles");

        }

    }
}
