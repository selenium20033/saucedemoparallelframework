#Author: demo framework
Feature: Shopping

Background:
 
    When I enter the valid username
    And I enter the valid password
    And I click on submit button

  @removingItemFromChart @parallel3
  
  Scenario: Removing an item from the chart
  
    When I add an item to the chart
    And I click on chart icon
    And I click on remove button
    And I click on continue shopping button
    And I verify that home page is displayed
  
