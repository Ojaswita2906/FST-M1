package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {

WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void setUp(){
		//a & b . Open a browser and Navigate to ‘https://alchemy.hguy.co/lms’.
		driver.get("https://alchemy.hguy.co/lms/");
	}
	
	@Test
	public void ReadTheHeading() {
		//c. Get the heading of the webpage.
	    WebElement heading = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']"));
	    String headingString = heading.getText();
	    System.out.println("Heading of the website: " + headingString);
	    
	    //d. Make sure it matches “Learn from Industry Experts” exactly.
	    Assert.assertEquals(headingString, "Learn from Industry Experts");
	}
	
	@AfterTest
	public void close() {
		//e. If it matches, close the browser.
		driver.quit();
	}
}
