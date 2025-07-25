package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightEnquiryStepDefinition {
	WebDriver driver;
	
	@Given("User is on the Flight Enquiry form page with internet access")
	public void user_is_on_the_flight_enquiry_form_page_with_internet_access() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User is on the Flight Enquiry form page with internet access");
	    
	}

	@When("User navigates to Enquiry Link")
	public void user_navigates_to_enquiry_link() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User navigates to Enquiry Link");
	}

	@When("User enters Name {string}")
	public void user_enters_name(String name) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User enters Name {string}"+name);

	}

	@When("User enters Email {string}")
	public void user_enters_email(String email) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User enters email {string}"+email);
	}

	@When("User enters Phone {string}")
	public void user_enters_phone(String phone) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User enters phone {string}"+phone);
	}

	@When("User enters Subject {string}")
	public void user_enters_subject(String sub) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User enters subject {string}"+sub);
	}

	@When("User enters Message {string}")
	public void user_enters_message(String message) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User enters message {string}"+message);
	}

	@When("User clicks send")
	public void user_clicks_send1() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User enters click");
	}

	@Then("Form Submit successfully.")
	public void form_submit_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Form submit  successfully");
	}

	@When("User leaves Full Name blank")
	public void user_leaves_full_name_blank() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User enters Name ");
	}

	@When("User fills all other fields with valid data")
	public void user_fills_all_other_fields_with_valid_data() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("ALL fields");
	}

	@When("User clicks Send")
	public void user_clicks_send2() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click Send");
	}

	@Then("Error message shown under Full Name field: {string}")
	public void error_message_shown_under_full_name_field(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Error Message");
	}

	@Then("Form not submitted.")
	public void form_not_submitted() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("User enters invalid Email {string}")
	public void user_enters_invalid_email(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("User fills all other fields correctly")
	public void user_fills_all_other_fields_correctly() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("Error message shown under Message: {string}")
	public void error_message_shown_under_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("User fills all fields except Message")
	public void user_fills_all_fields_except_message() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("User enters Phone Number {string}")
	public void user_enters_phone_number(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("User fills other fields properly")
	public void user_fills_other_fields_properly() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("Error message near phone field: {string}")
	public void error_message_near_phone_field(String string) {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("User fills all fields with valid data")
	public void user_fills_all_fields_with_valid_data() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("User finds the submit button")
	public void user_finds_the_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("User clicks the button")
	public void user_clicks_the_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Click Button");
	}

	@Then("Success Message: {string}")
	public void success_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User enters Message {string}"+string);
	}

	@When("User leaves Subject field blank")
	public void user_leaves_subject_field_blank() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User enters blank {string}");
	}

	@When("User fills the other fields with valid data")
	public void user_fills_the_other_fields_with_valid_data() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User all fields");
	}

	@When("User clicks the Send button")
	public void user_clicks_the_send_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User enter Button");
	}

}