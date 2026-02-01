package Appium_Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class ChromeWebTests {

    private AndroidDriver driver;

    @Test(priority = 1)
    public void todoListWebTest() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Android Emulator")
                .setBrowserName("Chrome");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );

        driver.get("https://training-support.net/webelements");

        driver.findElement(By.xpath("//h1[text()='To-Do List']")).click();

        By input = By.id("taskInput");

        driver.findElement(input).sendKeys("Add tasks to list\n");
        driver.findElement(input).sendKeys("Get number of tasks\n");
        driver.findElement(input).sendKeys("Clear the list\n");

        List tasks = driver.findElements(By.className("task"));
        for (Object task : tasks) {
            ((org.openqa.selenium.WebElement) task).click();
        }

        // 2 existing + 3 added = 5
        Assert.assertEquals(tasks.size(), 5);

        driver.quit();
    }

    @Test(priority = 2)
    public void loginFormCorrectCredentials() throws Exception {

        setupBrowser();
        driver.get("https://training-support.net/webelements");
        driver.findElement(By.xpath("//h1[text()='Login Form']")).click();

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String message = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(message, "Login success ! Welcome Back, Admin!");

        driver.quit();
    }

    @Test(priority = 3)
    public void loginFormIncorrectCredentials() throws Exception {

        setupBrowser();
        driver.get("https://training-support.net/webelements");
        driver.findElement(By.xpath("//h1[text()='Login Form']")).click();

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("wrongpassword");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        String message = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(message, "Invalid Credentials");

        driver.quit();
    }

    @Test(priority = 4)
    public void popupLoginTest() throws Exception {

        setupBrowser();
        driver.get("https://training-support.net/webelements");
        driver.findElement(By.xpath("//h1[text()='Popups']")).click();

        driver.findElement(By.id("popupBtn")).click();

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("submit")).click();

        String message = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(message, "Login success ! Welcome Back, Admin!");

        driver.quit();
    }

    private void setupBrowser() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Android Emulator")
                .setBrowserName("Chrome");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );
    }
}