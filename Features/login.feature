Feature: Login 

Scenario: Check Login is successfully 
	Given Browser is Open 
	And User is on a login page 
	When User enters the username , and the password 
	And click on the login button 
	Then User is navigated to the home page 
	
	