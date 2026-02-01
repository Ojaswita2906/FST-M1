package Appium_Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class Activity4 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void initializeDriver() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.google.android.contacts")
                .setAppActivity("com.android.contacts.activities.PeopleActivity")
                .noReset();

        URL appiumServer = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(appiumServer, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addContactTest() {
        driver.findElement(AppiumBy.accessibilityId("Create new contact")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.EditText[@text='First name']")
        ));

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Ojaswita");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Paul");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148789");

        driver.findElement(AppiumBy.id("editor_menu_save_button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("large_title")));

        String savedContact = driver.findElement(AppiumBy.id("large_title")).getText();
        Assert.assertEquals(savedContact, "Aaditya Varma");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
