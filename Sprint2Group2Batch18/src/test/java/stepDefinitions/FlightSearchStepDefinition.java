package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import hooks.Hook;
import io.cucumber.java.en.*;
import pages.FlightSearchPageFactory;

public class FlightSearchStepDefinition {

    WebDriver driver = Hook.driver;
    FlightSearchPageFactory flightSearchPage;

    @Given("User is on Flight Search page")
    public void user_is_on_flight_search_page() throws InterruptedException {
        // Launch login + navigate to search
        flightSearchPage = new FlightSearchPageFactory(driver);
        flightSearchPage.login();
        flightSearchPage.navigateToFlightSearch();
    }

    @When("User searches by flight number {string}")
    public void user_searches_by_flight_number(String flightNumber) {
        flightSearchPage.searchByFlightNumber(flightNumber);
    }

    @Then("Flight with number {string} should be displayed")
    public void flight_with_number_should_be_displayed(String flightNumber) {
        Assert.assertTrue("Flight number not found: " + flightNumber,
                flightSearchPage.isFlightNumberPresent(flightNumber));
    }

    @When("User searches by flight name {string}")
    public void user_searches_by_flight_name(String flightName) {
        flightSearchPage.searchByFlightName(flightName);
    }

    @Then("Flight with name containing {string} should be displayed")
    public void flight_with_name_should_be_displayed(String flightName) {
        Assert.assertTrue("Flight name not found: " + flightName,
                flightSearchPage.isFlightNamePresent(flightName));
    }

    @When("User searches by flight type {string}")
    public void user_searches_by_flight_type(String flightType) {
        flightSearchPage.searchByFlightType(flightType);
    }

    @Then("Flights with type {string} should be displayed")
    public void flights_with_type_should_be_displayed(String flightType) {
        Assert.assertTrue("Flight type not found: " + flightType,
                flightSearchPage.isFlightTypePresent(flightType));
    }

//    @Then("No flight results should be displayed")
//    public void no_flight_results_should_be_displayed() {
//        Assert.assertTrue("Unexpected flights displayed for invalid input",
//                flightSearchPage.areNoResultsDisplayed());
//    }
    
    @Then("No flight results should be displayed")
    public void no_flight_results_should_be_displayed() {
        boolean tableEmpty = flightSearchPage.areNoResultsDisplayed();
        boolean messageShown = flightSearchPage.isNoResultsMessageDisplayed();

        Assert.assertTrue("Expected: No results shown and message displayed. " +
                "Actual: Table has rows or no error message visible.",
                tableEmpty && messageShown);
    }

}
