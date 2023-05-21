

Feature: Borrowing Calculator
  As a user I want to calculate borrowing estimates
  So that I can make informed decisions
 
  Scenario: Calculate borrowing estimate
     Given User Launch browser
    And opens URL "https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/"
    When user enters required details
    And click on estimate button
    Then user should see the borrowing estimate
    When  click the start over button
    Then the form should be cleared








