Feature: broadcast message to board 

	
Scenario: send message
	Given you are in the homepage
	When user click in the messages button 
	And clicks in a new message
	And User enters message subject and description 
	And click on the post button 
	Then User is navigated to the board of messages page
	
	