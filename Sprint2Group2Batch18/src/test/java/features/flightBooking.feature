Feature: Flight Booking Functionality

  Scenario: Verify that user can search for a flight with valid inputs
    Given User launches the flight booking application
    When User enters "New York" as the departure city
    And User enters "London" as the destination city
    And User selects departure date as "2025-08-20"
    And User selects return date as "2025-08-25"
    And User clicks on the search button
    Then Flights between "New York" and "London" should be displayed

  Scenario: Verify that user cannot search without entering departure and destination cities
    Given User launches the flight booking application
    When User leaves departure and destination cities blank
    And User clicks on the search button
    Then An error message should be displayed

  Scenario: Verify date validation when return date is before departure date
    Given User launches the flight booking application
    When User enters "Delhi" as the departure city
    And User enters "Paris" as the destination city
    And User selects departure date as "2025-09-10"
    And User selects return date as "2025-09-05"
    And User clicks on the search button
    Then A date validation error should be shown

  Scenario: Verify that user can select number of passengers and search
    Given User launches the flight booking application
    When User enters "Mumbai" as the departure city
    And User enters "Singapore" as the destination city
    And User selects departure date as "2025-08-28"
    And User selects return date as "2025-09-05"
    And User selects "2" adults and "1" child
    And User clicks on the search button
    Then Flight results should reflect passenger selection

  Scenario: Verify user can filter flight results by airline
    Given Flight results are displayed for route "Chennai" to "Dubai"
    When User applies filter for "Emirates"
    Then Only flights from "Emirates" should be displayed

  Scenario: Verify user can sort flight results by price (low to high)
    Given Flight results are displayed for route "Bangalore" to "Tokyo"
    When User sorts the flights by price from low to high
    Then Flights should be sorted in ascending order of price

  Scenario: Verify user can view flight details by clicking on 'View Details'
    Given Flight results are displayed for any search
    When User clicks on the 'View Details' button of a flight
    Then Detailed information about the flight should be displayed

  Scenario: Verify user can book a flight from the list
    Given Flight results are displayed for route "Kolkata" to "Bangkok"
    When User clicks on the 'Book Now' button for a flight
    Then Booking form should be displayed

  Scenario: Verify user cannot proceed to book without filling passenger details
    Given Booking form is displayed
    When User leaves passenger details empty
    And User clicks on the 'Continue' button
    Then An error message asking to fill required details should appear

  Scenario: Verify successful booking confirmation with valid data
    Given Booking form is displayed
    When User fills all required passenger and payment details correctly
    And User clicks on the 'Confirm Booking' button
    Then Booking confirmation should be displayed with a booking reference


 