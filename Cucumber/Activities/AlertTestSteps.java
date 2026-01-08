package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Alert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertTestSteps extends BaseClass{
	Alert alert;
	
	@Given("the user is on the page")
	public void userisOnThePage() {
		driver.get("https://training-support.net/webelements/alerts");
		assertEquals("Selenium: Alerts", driver.getTitle());
	}
	
	@When("user clicks on the Simple Alert button")
	public void userClicksOnSimpleAlert() {
		driver.findElement(By.xpath("//button[@id=\"simple\"]")).click();
	}
	
	@When("user clicks on the Confirm Alert button")
	public void userClicksOnConfirmAlert() {
		driver.findElement(By.xpath("//button[@id=\"confirmation\"]")).click();
	}
	
	@When("user clicks on the Prompt Alert button")
	public void userClicksOnPromptAlert() {
		driver.findElement(By.xpath("//button[@id=\"prompt\"]")).click();
	}
	
	@Then("alert opens")
	public void alertOpens() {
		alert = driver.switchTo().alert();
	}
	
	@And("read the text from it and print it")
	public void readTextAndPrint() {
		System.out.println(alert.getText());
	}
	
	@And("write a custom message in it")
	public void writeCustomMessage() {
		alert.sendKeys("This is custom Message");
	}
	
	@And("close the alert")
	public void closeAlert() {
		alert.accept();
	}
	
	@And("close the alert with Cancel")
	public void closeAlertWithCancel() {
		alert.dismiss();
	}
	
	@And("read the result text")
	public void readTheResultText() {
		String message = driver.findElement(By.id("result")).getText();
		System.out.println(message);
	}
}
