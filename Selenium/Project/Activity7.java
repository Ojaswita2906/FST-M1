package SeleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity7 {
	WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setUp(){
		//a & b . Open a browser and Navigate to ‘https://alchemy.hguy.co/lms’.
		driver.get("https://alchemy.hguy.co/lms/");
	}
	
	@Test
	public void CountNumberOfCources() {
		//c. & d. Find the navigation bar and Select the menu item that says “All Courses” and click it
		WebElement navElement = driver.findElement(By.xpath("//a[contains(text(),'All Courses')]"));
		navElement.click();
		
		List<WebElement> courses = driver.findElements(By.xpath("//h3[@class='entry-title']"));;
		System.out.println("Number of courses: "+ courses.size());		
		
	}
	
	@AfterTest
	public void close() {
		//e. If it matches, close the browser.
		driver.quit();
	}
}
