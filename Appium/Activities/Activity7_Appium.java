package Appium_Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
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
import java.util.List;

public class Activity7 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void initializeDriver() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.android.chrome")
                .setAppActivity("com.google.android.apps.chrome.Main")
                .noReset();

        URL appiumServer = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(appiumServer, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/webelements/lazy-loading");
    }

    @Test
    public void testLazyLoadingImages() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));

        String uiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        List<WebElement> images = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Before scroll: " + images.size());

        String foundImage = driver.findElement(AppiumBy
                .androidUIAutomator(uiScrollable + ".scrollForward(25).getChildByText(className(\"android.widget.Image\"), \"Helen\")"))
                .getText();
        System.out.println("Found " + foundImage + "!");

        images = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("After scroll: " + images.size());

        Assert.assertEquals(images.size(), 3);
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}

