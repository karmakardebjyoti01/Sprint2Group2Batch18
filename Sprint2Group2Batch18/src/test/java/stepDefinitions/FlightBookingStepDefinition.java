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
    FlightBookingPageFactory flightPage;

    @Given("User is on the Flight Booking page")
	public void user_is_on_the_flight_booking_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
//		driver=DriverSetUp.getDriver();
    	flightPage =new FlightBookingPageFactory(driver);
		Thread.sleep(2000);
			
		System.out.println("User is on the Flight Enquiry form page with internet access");
		
	    
	}

    @When("User enters Travel From as {string}")
    public void user_enters_travel_from_as(String from) {
        flightPage.enterFromCity(from);
    }

    @And("User enters Travel To as {string}")
    public void user_enters_travel_to_as(String to) {
        flightPage.enterToCity(to);
    }

    @And("User enters Departure Date as {string}")
    public void user_enters_departure_date_as(String date) {
        flightPage.enterDepartureDate(date);
    }

    @And("User selects Class as {string}")
    public void user_selects_class_as(String flightClass) {
        flightPage.selectTravelClass(flightClass);
    }

    @And("User enters Name as {string}")
    public void user_enters_name_as(String name) {
        flightPage.enterName(name);
    }

    @And("User enters Email as {string}")
    public void user_enters_email_as(String email) {
        flightPage.enterEmail(email);
    }

    @And("User enters Phone as {string}")
    public void user_enters_phone_as(String phone) {
        flightPage.enterPhone(phone);
    }

    @And("User enters No Of Passenger as {string}")
    public void user_enters_no_of_passenger_as(String passengers) {
        flightPage.selectPassengerCount(passengers);
    }

    @And("User clicks on Book Now button")
    public void user_clicks_on_book_now_button() {
        flightPage.clickSearchButton();
    }

    @Then("User should see the confirmation message {string}")
    public void user_should_see_the_confirmation_message(String expectedMessage) {
        String actualMessage = flightPage.getBookingConfirmationMessage();
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Then("User should see an error message for name as {string}")
    public void user_should_see_an_error_message_for_name_as(String expectedError) {
        String actualError = flightPage.getNameErrorMessage();
        Assert.assertEquals(actualError, expectedError);
    }
}