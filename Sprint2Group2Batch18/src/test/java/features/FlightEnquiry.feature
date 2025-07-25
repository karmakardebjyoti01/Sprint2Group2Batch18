Feature: Flight Enquiry
Background:
Given User is on the Flight Enquiry form page with internet access
 When User navigates to Enquiry Link


  Scenario: To Verify successful form submission with valid input
    And User enters Name "Jhon Wick"
    And User enters Email "jhon123@gmail.com"
    And User enters Phone "9874561230"
    And User enters Subject "Flight Timing"
    And User enters Message "Please confirm the departure time for flight AI202"
    And User clicks send
    Then Form Submit successfully.

  Scenario: To Verify Blank Full Name
    And User leaves Full Name blank
    And User fills all other fields with valid data
    And User clicks Send
    Then Error message shown under Full Name field: "Name is required"
    And Form not submitted.

  Scenario: To Verify Invalid Email Format
   
    And User enters invalid Email "jhon123.gmail.com"
    And User fills all other fields correctly
    And User clicks Send
    Then Error message shown under Message: "Please enter a valid email address."
    And Form not submitted.

  Scenario: To Verify Blank Message Field
    
    And User fills all fields except Message
    And User clicks Send
    Then Error message shown under Message: "Message cannot be empty"
    And Form not submitted.

  Scenario: To Verify Phone Number with Alphabets
    
    And User enters Phone Number "98abc123xx"
    And User fills other fields properly
    And User clicks Send
    Then Error message near phone field: "Invalid phone number"
    And Form not submitted.

  Scenario: To Verify Send Button Functionality
    
    And User fills all fields with valid data
    And User finds the submit button
    And User clicks the button
    Then Success Message: "Thank you! We will get back to you as soon as possible."

  Scenario: To Verify Blank Subject Field
    And User leaves Subject field blank
    And User fills the other fields with valid data
    And User clicks the Send button
    Then Error message shown under Message: "Subject cannot be empty"
    And Form not submitted.