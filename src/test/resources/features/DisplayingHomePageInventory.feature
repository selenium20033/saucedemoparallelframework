#Author: demo framework
Feature: Inventory

Background:
 
    When I enter the valid username
    And I enter the valid password
    And I click on submit button

  @displayingHomePageInventory @parallel1
  
  Scenario: Displaying home page inventory
  
    Then I validate that home page inventory is displayed
  
