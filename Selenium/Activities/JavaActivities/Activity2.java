package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/login-form");
		
		System.out.println("Title of page: "+ driver.getTitle());
		
		driver.findElement(By.cssSelector("#username")).sendKeys("admin");
		driver.findElement(By.cssSelector("#password")).sendKeys("password");
		driver.findElement(By.cssSelector("button.svelte-1pdjkmx")).click();
		
		driver.quit();
	}

}
