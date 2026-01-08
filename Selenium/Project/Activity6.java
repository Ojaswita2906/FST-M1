package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void setUp(){
		//a & b . Open a browser and Navigate to ‘https://alchemy.hguy.co/lms’.
		driver.get("https://alchemy.hguy.co/lms/");
	}
	
	@Test
	public void LoggingIntoTheSite() {
		//c. & d. Find the navigation bar and Select the menu item that says “My Account” and click it
		WebElement navElement = driver.findElement(By.xpath("//a[contains(text(),'My Account')]"));
		navElement.click();
		
		//e. Read the page title and verify that you are on the correct page.
		String titleString= driver.getTitle();
		System.out.println("Title of page: "+ titleString);
		Assert.assertEquals(titleString, "My Account – Alchemy LMS");
		
		//f. Find the “Login” button on the page and click it.
		WebElement loginElement = driver.findElement(By.xpath("//a[contains(text(),\"Login\")]"));
		loginElement.click();
		
		//g. & h. Enter username and password
		WebElement userNamElement = driver.findElement(By.xpath("//input[@id='user_login']"));
		WebElement passwordElement = driver.findElement(By.xpath("//input[@id='user_pass']"));
		userNamElement.sendKeys("root");
		passwordElement.sendKeys("pa$$w0rd");
		//i. click login button
		driver.findElement(By.id("wp-submit")).click();
		
		//j. verify
		String editProfile = driver.findElement(By.xpath("//a[@class='ld-profile-edit-link']")).getText();
		Assert.assertEquals(editProfile, "Edit profile");
		
		
	}
	
	@AfterTest
	public void close() {
		//e. If it matches, close the browser.
		driver.quit();
	}

}
