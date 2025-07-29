@FlightSearch
Feature: Flight Search Functionality

  Scenario: TC001 - Search by valid Flight Number
    Given User is on Flight Search page
    When User searches by flight number "AC789"
    Then Flight with number "AC789" should be displayed

  Scenario: TC002 - Search by Partial Flight Name
    Given User is on Flight Search page
    When User searches by flight name "Jet"
    Then Flight with name containing "Jet" should be displayed

  Scenario: TC004 - Search by valid Flight Type
    Given User is on Flight Search page
    When User searches by flight type "Direct Flight"
    Then Flights with type "Direct Flight" should be displayed

  Scenario: TC003 - Search by Invalid Flight Type
    Given User is on Flight Search page
    When User searches by flight type "Cargo Flight"
    Then No flight results should be displayed

  Scenario: TC005 - Search by Invalid Flight Name
    Given User is on Flight Search page
    When User searches by flight name "SkyKing"
    Then No flight results should be displayed

  Scenario: TC009 - Search by Invalid Flight Number
    Given User is on Flight Search page
    When User searches by flight number "ZZ999"
    Then No flight results should be displayed
    
  Scenario: TC010 - Search with Leading/Trailing Spaces
  	Given User is on Flight Search page
  	When User searches by flight number " AC789 " 
  	Then Flight with number "AC789" should be displayed

