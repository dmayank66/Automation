Feature: Test login functionality

  Scenario: Check login function with valid data
    Given user is on login page
    When user enters username and password
    And click on login button
    Then user is navigated to the home page
