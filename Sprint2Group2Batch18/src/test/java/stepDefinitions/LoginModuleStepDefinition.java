
package stepDefinitions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import hooks.Hook;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginModulePageFactory;

public class LoginModuleStepDefinition{
	
	WebDriver driver=Hook.driver;
	
	LoginModulePageFactory login;
	String validateString,loginValidateString;
	
	
	@Given("I open the browser and  I navigate to the login page")
	public void i_open_the_browser_and_i_navigate_to_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		login=new LoginModulePageFactory(driver);
		
	    
	}

	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		
	    login.setUsername(username);
	    login.setPassword(password);
	}

	@When("I enter captcha {string}")
	public void i_enter_captcha(String capche) {
	    // Write code here that turns the phrase above into concrete actions
	   login.setCaptcha(capche);
	}

	@When("I click the {string} button on login page")
	public void i_click_the_button_on_login_page(String string) {
	    // Write code here that turns the phrase above into concrete actions
	  
	    	validateString=login.clickValidate();
	   
	}
	@When("I click the Login button on login page")
	public void i_click_the_button_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    
	    loginValidateString= login.clickLogin();
	    
	}

	@Then("I should see a message {string}")
	public void i_should_see_a_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    
	    	Assert.assertEquals("Valid input", validateString);
	  
	}
	@Then("I should see a Login message {string}")
	public void i_should_see_a_Login_message(String string) {
	   
//	   
	    Assert.assertEquals(string, loginValidateString);
	    
	}

	@When("I perform action \"click \"Forgot Password\" link\"")
	public void i_perform_action_click_forgot_password_link() {
	    // Write code here that turns the phrase above into concrete actions
	    String messageString=  	login.clickForgetPassword();
	    if(messageString.contains("404")) {
	    	Assert.assertTrue(false);
	    }else {
	    	Assert.assertTrue(true);
	    }
	}

	@Then("I should see result {string}")
	public void i_should_see_result(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("I perform action \"enable \"Remember me\", re-login\"")
	public void i_perform_action_enable_remember_me_re_login() {
	    // Write code here that turns the phrase above into concrete actions
	   String messageString=login.rememeberMeClick();
	   Assert.assertEquals("Username and Password Saved Successfully!", messageString);
	}
}