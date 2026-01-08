package SeleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void setUp(){
		//a & b . Open a browser and Navigate to ‘https://alchemy.hguy.co/lms’.
		driver.get("https://alchemy.hguy.co/lms/");
	}
	
	@Test
	public void SecondMostPopular() {
		//c. Get the title of the second most popular course.
		List<WebElement> headings = driver.findElements(By.xpath("//h3[@class='entry-title']"));
		WebElement secondHeadingString = headings.get(1); 
		System.out.println("Second most popular string: "+ secondHeadingString.getText());
		
		//d.
		Assert.assertEquals(secondHeadingString.getText(), "Email Marketing Strategies");

	}
	
	@AfterTest
	public void close() {
		//e. If it matches, close the browser.
		driver.quit();
	}

}
