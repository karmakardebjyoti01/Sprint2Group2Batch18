Feature: Flight Booking Functionality


	Background:
		Given User is on the Flight Booking page
 		When User navigates to Flight Booking Link
 		
 	Scenario Outline: Flight booking and Validation
		And User enters current city "<Travel_From>"
		And User enters destination city "<Travel_To>"
		And User enters Departure date "<departure_date>"
		And User select class "<class>"
		And User enters name "<name>"
		And User enters email "<email>"
		And User enters phone number "<Phone>"
		And User select number of passenger "<no_of_passenger>"
		And User clicks Book Now 
		Then System should display response "<ExpectedResult>"
		And Form submission response should be "<FormStatus>"
		
	Examples:
  | Travel_From| Travel_To           | departure_date| class          | name        |email              |Phone           |no_of_passenger    | ExpectedResult                                                        | FormStatus     |
  | New York   | London   			 | 2025-08-20    | Luxury Class   | John Doe    |xyz@gmail.com      |9874561230      |         1         |Your flight Reservation has been Confirmed !				             | Submitted      |
  | New York   | London   		     | 2024-08-20    | Luxury Class   | John Doe    |xyz@gmail.com      |9874561230      |         1         |Your flight Reservation has NOT been Confirmed ! 					     | Submitted      |
  | New York   | London   		     | 2025-08-20    | Luxury Class   | John Doe    |xyz3478.com        |9874561230      | 		   1	     |Please write a valid email.						                     | Submitted      |
  | New York   | London              | 2025-08-20    | Luxury Class   | John Doe    |xyz@gmail.com      |9874561av       |  	   1		 |Please write a valid Phone number.								     | Submitted      |
  | New York   | London   			 | 2025-08-20    | Luxury Class   | John Doe    |xyz@gmail.com      |9874561230      |         3         |Your flight Reservation has been Confirmed !				             | Submitted      |
  | New York   | London   			 | 2025-08-20    | Luxury Class   | John Doe    |xyz@gmail.com      |9874561230      |         0         |Number of Passengers can't be Zero				                     | Not Submitted  |
  | New York   | London   			 | 2025-08-20    | Luxury Class   | John Doe    |                   |9874561230      |         1         |Email can't be blank				                                     | Not Submitted  |
  | New York   | London   			 | 2025-08-20    | Luxury Class   | John Doe    |xyz@gmail.com      |                |         1         |Phone Number can't be blank				                             | Not Submitted  |
  | New York   | London   			 | 2025-08-20    | Luxury Class   |             |xyz@gmail.com      |9874561230      |         1         |Name can't be blank				                                     | Not Submitted  |
  | Asansol    | London   			 | 2025-08-20    | Luxury Class   | John Doe    |xyz@gmail.com      |9874561230      |         1         |Please write a valid city name with airport.				             | Submitted      |

  