package SeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver = new FirefoxDriver();
	
	@BeforeTest
	public void setUp(){
		//a & b . Open a browser and Navigate to ‘https://alchemy.hguy.co/lms’.
		driver.get("https://alchemy.hguy.co/lms/");
	}
	
	@Test
	public void VerifyWebsiteTiltle() {
		//c. Get the title of the website.
		String title = driver.getTitle();
		System.out.println("Title of the page: "+title);

		//d. Make sure it matches “Alchemy LMS – An LMS Application '' exactly.
		Assert.assertEquals(title, "Alchemy LMS – An LMS Application" );
	}
	
	@AfterTest
	public void close() {
		
		//e. If it matches, close the browser.
		driver.quit();
	}
}
