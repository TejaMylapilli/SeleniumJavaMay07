Feature: Appplication Login

Scenario: Login with valid credentials

Given open chrome browser 
And Navigate to login page
When User enters email as "Automation535541@gmail.com" and password as "Teja@444"
And User clicks on login button
Then Verify user able to login successfully
