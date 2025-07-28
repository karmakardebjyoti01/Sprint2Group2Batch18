package stepDefinitions;

import org.openqa.selenium.*;
import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.FlightBookingPageFactory;
import setup.DriverSetUp;

public class FlightBookingStepDefinition {
    WebDriver driver = DriverSetUp.getDriver();
    FlightBookingPageFactory flightPage = new FlightBookingPageFactory(driver);

    @Given("User launches the flight booking application")
    public void user_launches_flight_booking_app() {
        driver.get("https://webapps.tekstac.com/FlightBooking/login.html");
    }

    @When("User enters {string} as the departure city")
    public void user_enters_departure_city(String fromCity) {
        flightPage.enterFromCity(fromCity);
    }

    @When("User enters {string} as the destination city")
    public void user_enters_destination_city(String toCity) {
        flightPage.enterToCity(toCity);
    }

    @When("User enters {string} as the departure date")
    public void user_enters_departure_date(String date) {
        flightPage.enterDepartureDate(date);
    }

    @When("User enters {string} as the return date")
    public void user_enters_return_date(String returnDate) {
        flightPage.enterReturnDate(returnDate);
    }

    @When("User selects {string} number of passengers")
    public void user_selects_number_of_passengers(String passengers) {
        flightPage.selectPassengers(passengers);
    }

    @When("User checks the one way checkbox")
    public void user_checks_one_way_checkbox() {
        flightPage.checkOneWay();
    }

    @When("User clicks the Search Flights button")
    public void user_clicks_search_button() {
        flightPage.clickSearchButton();
    }

    @Then("User should see the list of available flights")
    public void user_should_see_flight_list() {
        Assert.assertTrue("Flight list not displayed", flightPage.isFlightListDisplayed());
    }

    @Then("An error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedError) {
        String actualError = flightPage.getErrorMessage();
        Assert.assertEquals(expectedError, actualError);
    }

    @Then("The Return Date field should be disabled")
    public void return_date_field_should_be_disabled() {
        Assert.assertTrue("Return Date field is not disabled", flightPage.isReturnDateDisabled());
    }

    @When("User leaves the departure city blank")
    public void user_leaves_departure_city_blank() {
        flightPage.enterFromCity("");
    }

    @When("User leaves the destination city blank")
    public void user_leaves_destination_city_blank() {
        flightPage.enterToCity("");
    }

    @When("User leaves the departure date blank")
    public void user_leaves_departure_date_blank() {
        flightPage.enterDepartureDate("");
    }

    @When("User selects no. of passengers as default")
    public void user_selects_default_passengers() {
        flightPage.selectPassengers("Select"); // assuming "Select" is the default
    }
}