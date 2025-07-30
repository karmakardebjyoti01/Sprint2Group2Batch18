Feature: Login
Background:
Given I open the browser and  I navigate to the login page

  Scenario Outline: Login flow variations  
    
    When I enter username "<user>" and password "<pass>"
    And I enter captcha "<captcha>"
    And I click the "Validate" button on login page
    Then I should see a message "<validationMsg>"
    When I click the Login button on login page
    Then I should see a Login message "<resultMsg>"

    Examples:
     
      | user        | pass        | captcha | validationMsg | resultMsg            |
      | flightadmin | flightadmin | valid   | Valid input   | Login Successful     |
      | flight      | flightadmin | valid   | Valid input   | Username is wrong    |
      | flightadmin | wrongpass   | valid   | Valid input   | Password is wrong    |
      | flightadmin | flightadmin | invalid | invalid input |                    |
      | admin       | admin       | valid   | Valid input   | login requested rejected|

	
	
	Scenario Outline: Navigation & Remember-Me
    When I perform action "<action>"
    Then I should see result "<result>"

    Examples:
      | action                          | result                           |
      | click "Forgot Password" link    | redirected to password-reset page|
      | enable "Remember me", re-login  | logged in automatically          |
	
	
	
	
	
	
	
	
	
	
	
	
	