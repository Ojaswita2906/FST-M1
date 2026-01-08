package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTestSteps extends BaseClass{
	
	@Given("the user is on the login page")
	public void userOnLoginPage() {
		driver.get("https://training-support.net/webelements/login-form");
	}
	
	@When("the user enters the username and password")
	public void userProvidesUserNameAndPassword() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
	}
	
	@When("the user enters {string} and {string}")
	public void userProvidesUserNameAndPasswordFromInputs(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	@And("clicks on Submit button")
	public void userClicksOnSubmitButton() {
		driver.findElement(By.xpath("//button[text()=\"Submit\"]")).click();
	}
	
	@Then("get the confirmation message and verify it")
	public void getConfMessageAndVerify() {
		wait.until(ExpectedConditions.titleIs("Selenium: Login Success!"));
		String text = driver.findElement(By.cssSelector("h1.text-emerald-500")).getText();
		assertEquals("Login Success!", text);
	}
	
	@Then("get the confirmation text and verify message as {string}")
	public void getConfMessageAndVerifyFromInput(String expectedMessage) {
//		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("h2.mt-5"), "Welcome"));
//		String text = driver.findElement(By.cssSelector("h2.mt-5")).getText();
		String message = "NOT FOUND";
		if (expectedMessage.contains("Invalid")) {
            message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2#subheading"))).getText();
        } else {
            message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.mt-5"))).getText();
        }
		assertEquals(expectedMessage, message);
	}
}
