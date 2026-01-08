@activity3

Feature: "Testing with Tags"
	
	@SimpleAlert @SmokeTest
	Scenario: "Testing with Simple Alert"
		Given the user is on the page
		When user clicks on the Simple Alert button
		Then alert opens
		And read the text from it and print it
		And close the alert
		And read the result text
		
	@ConfirmAlert
	Scenario: "Testing with Confirm Alert"
		Given the user is on the page
		When user clicks on the Confirm Alert button
		Then alert opens
		And read the text from it and print it
		And close the alert with Cancel
		And read the result text
		
	@PromptAlert
	Scenario: "Testing with Prompt Alert"
		Given the user is on the page
		When user clicks on the Prompt Alert button
		Then alert opens
		And read the text from it and print it
		And write a custom message in it 
		And close the alert
		And read the result text
	
	Scenario Outline: 
		Given the user is on the page
		When user clicks on the <type> Alert button
		Then alert opens
		And read the text from it and print it
		And close the alert
		And read the result text
	Examples:
		|type|
		|Simple|