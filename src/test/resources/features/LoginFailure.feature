#Author: demo framework
Feature: Login function

  @loginFailure @parallel1
  
  Scenario: Login failure
  
    When I enter an invalid username
    And I enter an invalid password
    And I submit the invalid credentials
    Then I verify that the error message is displayed
  
