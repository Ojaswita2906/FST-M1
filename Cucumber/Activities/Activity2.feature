@activity2

Feature: Login Test
	Scenario: Testing Login
		Given the user is on the login page
		When the user enters the username and password
		And clicks on Submit button
		Then get the confirmation message and verify it
		