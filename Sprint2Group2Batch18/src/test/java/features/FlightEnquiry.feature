Feature: Flight Enquiry
Background:
Given User is on the Flight Enquiry form page with internet access
 When User navigates to Enquiry Link

Scenario Outline: Enquiry Form Submission and Validation
  And User enters Name "<Name>"
  And User enters Email "<Email>"
  And User enters Phone "<Phone>"
  And User enters Subject "<Subject>"
  And User enters Message "<Message>"
  And User clicks Send
  Then System should display "<ExpectedResult>"
  And Form submission status should be "<FormStatus>"

Examples:
  | Name       | Email               | Phone        | Subject        | Message                                                       | ExpectedResult                                                        | FormStatus     |
  | John Doe   | jhon123@gmail.com   | 9874561230   | Flight Timing  | Please confirm the departure time for flight AI202            |THANK YOU! WE WILL GET BACK TO YOU AS SOON AS POSSIBLE.| Submitted      |
  |            | jhon123@gmail.com   | 9874561230   | Flight Timing  | Please confirm the departure time for flight AI202            |Your name should be at least 3 characters long. | Not Submitted  |
  | John Doe   | jhon123.gmail.com   | 9874561230   | Flight Timing  | Please confirm the departure time for flight AI202            |Please enter a valid email address.| Not Submitted  |
  | John Doe   | jhon123@gmail.com   | 9874561230   | Flight Timing  |                                                               |Please write a longer message.| Not Submitted  |
  | John Doe   | jhon123@gmail.com   | 98abc123xx   | Flight Timing  | Please confirm the departure time for flight AI202            |Invalid phone number.| Not Submitted|
  | John Doe   | jhon123@gmail.com   | 9874561230   |                | Please confirm the departure time for flight AI202            |Subject cannot be empty.| Not Submitted  |
