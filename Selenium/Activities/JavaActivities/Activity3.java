package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		
		System.out.println("Activity1 using xpath");
		
		driver.get("https://training-support.net");
		System.out.println("Page title is: " + driver.getTitle());

		driver.findElement(By.xpath("//a[text()='About Us']")).click();
		
        System.out.println("New page title is: " + driver.getTitle());
        
        driver.quit();
        
        System.out.println("Activity2 using xpath");

        driver.get("https://training-support.net/webelements/login-form");
		
		System.out.println("Title of page: "+ driver.getTitle());
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		driver.quit();

	}

}
