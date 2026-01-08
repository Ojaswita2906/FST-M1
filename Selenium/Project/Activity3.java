package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void ReadFirstInfoBoxTitle() {
        // a & b. Open browser and navigate to the site
        driver.get("https://alchemy.hguy.co/lms");

        // c. Locate the first info box title
        WebElement firstInfoBoxTitle = driver.findElement(By.xpath("(//h3[@class='uagb-ifb-title'])"));
      
        // d. Get the text and verify it matches "Actionable Training"
        String actualTitle = firstInfoBoxTitle.getText();
        String expectedTitle = "Actionable Training";
        System.out.println("Title of the first info box: "+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Info box title does not match!");
    }
    
    
    @AfterTest
    public void closeBrowser() {
    	// e. Close the browser
        driver.quit();
    }


}
