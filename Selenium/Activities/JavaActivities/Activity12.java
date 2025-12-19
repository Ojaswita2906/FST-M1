package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {
    public static void main(String[] args) {
        // Create FireFox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://www.training-support.net/webelements/dynamic-content");
        // Print title of the page
        System.out.println("Page title: " + driver.getTitle());

        // Find button and click it
        driver.findElement(By.id("genButton")).click();
        // Wait for word to appear
        if (wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("word"), "release"))) {
            System.out.println("Word found: " + driver.findElement(By.id("word")).getText());
        }
        // Close browser
        driver.quit();
    }
}