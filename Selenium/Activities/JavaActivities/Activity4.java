package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity4 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
		
		System.out.println("Title of the page: "+ driver.getTitle());
		
		System.out.println("3rd header: "+driver.findElement(By.xpath("//h3[contains(text(),'#3')]")).getText());
		
		System.out.println("Color of 5th heading"+driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));

        System.out.println("Purple button classes: "+driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class"));
        
        System.out.println("Slate button text: "+driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText());
        
        driver.quit();
	}

}
