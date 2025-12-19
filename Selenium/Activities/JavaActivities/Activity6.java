package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {

	public static void main(String[] args) {
		WebDriver driver = new  FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("Title of the page: "+ driver.getTitle());
		
		WebElement checkElement = driver.findElement(By.xpath("//input[@id='checkbox']"));
		checkElement.click();
        System.out.println("Checkbox is selected: " + checkElement.isSelected());
        checkElement.click();
        System.out.println("Checkbox is selected: " + checkElement.isSelected());
        driver.quit();
		
	}

}
