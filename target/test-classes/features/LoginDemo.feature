Feature: Test login function

  Scenario: check login feature with valid credential
    Given browser is open
    And user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is navigated to home page
    
    Examples:
    |username|password|
    |Raghav | 12345|
    |Ele | 1234|
    
