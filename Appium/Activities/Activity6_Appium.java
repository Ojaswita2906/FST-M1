package Appium_Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import static org.testng.Assert.assertTrue;

public class Activity6 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void initializeDriver() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.android.chrome")
                .setAppActivity("com.google.android.apps.chrome.Main")
                .noReset();

        URL appiumServer = new URI("http://localhost:4723").toURL();
        driver = new AndroidDriver(appiumServer, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://training-support.net/webelements/sliders");
    }

    @Test
    public void testVolume75() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));

        Dimension screenSize = driver.manage().window().getSize();
        Point startPoint = new Point((int) (screenSize.getWidth() * 0.50), (int) (screenSize.getHeight() * 0.77));
        Point endPoint = new Point((int) (screenSize.getWidth() * 0.67), (int) (screenSize.getHeight() * 0.77));

        swipeElement(driver, startPoint, endPoint, 2000);

        String volumeText = driver
                .findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
                .getText();

        assertTrue(volumeText.contains("75%"));
    }

    @Test
    public void testVolume25() {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));

        Dimension screenSize = driver.manage().window().getSize();
        Point startPoint = new Point((int) (screenSize.getWidth() * 0.50), (int) (screenSize.getHeight() * 0.77));
        Point endPoint = new Point((int) (screenSize.getWidth() * 0.33), (int) (screenSize.getHeight() * 0.77));

        swipeElement(driver, startPoint, endPoint, 2000);

        String volumeText = driver
                .findElement(AppiumBy.xpath("//android.view.View/android.widget.TextView[contains(@text, '%')]"))
                .getText();

        assertTrue(volumeText.contains("25%"));
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

    private void swipeElement(AndroidDriver driver, Point start, Point end, int duration) {
        driver.performTouchAction(
                new io.appium.java_client.TouchAction(driver)
                        .press(start)
                        .waitAction(java.time.Duration.ofMillis(duration))
                        .moveTo(end)
                        .release()
        );
    }
}
