package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		
		System.out.println("Title of the page: "+driver.getTitle());
		
		WebElement checkElement  = driver.findElement(By.xpath("//input[@id='checkbox']"));
		
		System.out.println("Check if checkbox is visible or not: "+ checkElement.isDisplayed());
		
		System.out.println("Remove checkbox ");
		driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
		System.out.println("Check if checkbox is visible or not: "+ checkElement.isDisplayed());
		
		driver.quit();
		 

	}

}
