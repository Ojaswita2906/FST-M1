package Appium_Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity5 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void initializeDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.google.android.apps.messaging")
                .setAppActivity(".ui.ConversationListActivity")
                .noReset();

        URL appiumServer = new URL("http://localhost:4723/");
        driver = new AndroidDriver(appiumServer, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void sendSmsTest() {
        driver.findElement(AppiumBy.accessibilityId("Start new conversation")).click();

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("recipient_text_view")));
        driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("18282832912");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("compose_message_text")));
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();

        String sentMessage = driver.findElement(AppiumBy.id("message_text")).getText();
        Assert.assertEquals(sentMessage, "Hello from Appium");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}

