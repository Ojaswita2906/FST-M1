package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the page
        driver.get("https://training-support.net/webelements/selects");
      
        System.out.println("Title of to page: " + driver.getTitle());
        
       //Find dropdwn and create select
        Select dropdown = new Select(driver.findElement(By.cssSelector("select.h-10")));

        // Select the 2nd option using visible text
        dropdown.selectByVisibleText("Two");
        // Print the selected option
        System.out.println("2nd option: " + dropdown.getFirstSelectedOption().getText());

        // Select the 3rd option using index
        dropdown.selectByIndex(3);
        // Print the selected option
        System.out.println("3rd option: " + dropdown.getFirstSelectedOption().getText());

        // Select the 4th option using value attribute
        dropdown.selectByValue("four");
        // Print the selected option
        System.out.println("4th option: " + dropdown.getFirstSelectedOption().getText());

        // Print all the options
        System.out.println("Options in the dropdown: ");
        for(WebElement option : dropdown.getOptions()) {
            System.out.println(option.getText());
        }

        // Close the browser
        driver.quit();
    }
}