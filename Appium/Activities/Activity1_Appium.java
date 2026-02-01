package Appium_Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Activity1 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setApp("path/to/calculator.apk")
                .noReset();

        URL appiumServer = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(appiumServer, options);
    }

    @Test
    public void testMultiplication() {
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_8")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String calculationResult = driver.findElement(AppiumBy.id("result_final")).getText();
        Assert.assertEquals(calculationResult, "40");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
