package Appium_Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Activity3 {

    AndroidDriver driver;

    @BeforeClass
    public void initDriver() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setApp("path/to/calculator.apk")
                .noReset();

        URL appiumServer = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(appiumServer, options);
    }

    @Test
    public void testAddition() {
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("digit_9")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String calculationResult = driver.findElement(AppiumBy.id("result_final")).getText();
        Assert.assertEquals(calculationResult, "14");
    }

    @Test
    public void testSubtraction() {
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String calculationResult = driver.findElement(AppiumBy.id("result_final")).getText();
        Assert.assertEquals(calculationResult, "5");
    }

    @Test
    public void testMultiplication() {
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String calculationResult = driver.findElement(AppiumBy.id("result_final")).getText();
        Assert.assertEquals(calculationResult, "500");
    }

    @Test
    public void testDivision() {
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String calculationResult = driver.findElement(AppiumBy.id("result_final")).getText();
        Assert.assertEquals(calculationResult, "25");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
