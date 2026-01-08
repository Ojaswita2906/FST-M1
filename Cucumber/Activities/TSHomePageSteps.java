package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TSHomePageSteps extends BaseClass{
	
	@Given("user is on the TS homepage")
	public void openTSHomePage() {
		driver.get("https://training-support.net/");
		assertEquals(driver.getTitle(), "Training Support");
	}
	
	@When("the user clicks on the About Us link")
	public void clickAboutUsLink() {
		driver.findElement(By.linkText("About Us")).click();
	}
	
	@Then("they are redirected to another page")
	public void aboutUsPage() {
		wait.until(ExpectedConditions.titleIs("About Training Support"));
		String newTitle = driver.getTitle();
		assertEquals("About Training Support", newTitle);
	}
	
}
