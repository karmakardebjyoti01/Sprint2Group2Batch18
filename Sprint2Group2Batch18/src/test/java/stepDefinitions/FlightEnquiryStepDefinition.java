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
import pages.BaseClass;
import pages.FlightEnquiryPageFactory;
import setup.DriverSetUp;

public class FlightEnquiryStepDefinition {
	WebDriver driver = Hook.driver;
	FlightEnquiryPageFactory feqEnquiryPageFactory;
	
	@Given("User is on the Flight Enquiry form page with internet access")
	public void user_is_on_the_flight_enquiry_form_page_with_internet_access() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//		driver=DriverSetUp.getDriver();
		feqEnquiryPageFactory=new FlightEnquiryPageFactory(driver);
		Thread.sleep(2000);
			
		System.out.println("User is on the Flight Enquiry form page with internet access");
		
	    
	}
	@When("User navigates to Enquiry Link")
	public void user_navigates_to_enquiry_link() {
		feqEnquiryPageFactory.login();
	    // Write code here that turns the phrase above into concrete actions
		feqEnquiryPageFactory.navigateToEnquiryLink();   
	}

	@When("User enters Name {string}")
	public void user_enters_name(String string) {
	    // Write code here that turns the phrase above into concrete actions
		feqEnquiryPageFactory.setName(string);
	}

	@When("User enters Email {string}")
	public void user_enters_email(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    feqEnquiryPageFactory.setEmail(string);
	}

	@When("User enters Phone {string}")
	public void user_enters_phone(String string) {
	    // Write code here that turns the phrase above into concrete actions
	  feqEnquiryPageFactory.setPhone(string);
	}

	@When("User enters Subject {string}")
	public void user_enters_subject(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    feqEnquiryPageFactory.setSubject(string);
	}

	@When("User enters Message {string}")
	public void user_enters_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    feqEnquiryPageFactory.setMessage(string);
	}

	@When("User clicks Send")
	public void user_clicks_send() {
	    // Write code here that turns the phrase above into concrete actions
	    feqEnquiryPageFactory.sendButton();
	    
	}
	
	@Then("System should display {string}")
	public void system_should_display(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("entering in display Method");
	    List<String> messageList=feqEnquiryPageFactory.checkError();
	    String successString=feqEnquiryPageFactory.successMsg();
	    messageList.add(successString);
	    Set<String>set=new HashSet<String>(messageList);
	    for(String s:set) {
	    	System.out.println(s);
	    }
	    
	    Assert.assertTrue(set.contains(string));  
//	    Assert.assertTrue(false);
	}

	@Then("Form submission status should be {string}")
	public void form_submission_status_should_be(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.print("Success"+string);
	    
	}
}