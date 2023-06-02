#Author: demo framework
Feature: Shopping

Background:
 
    When I enter the valid username
    And I enter the valid password
    And I click on submit button

  @makingAPurchase @parallel2
  
  Scenario: Making a purchase
  
    When I add an item to the chart
    And I click on chart icon
    And I click on checkout button
    And I enter the info
    And I click on continue button
    And I click on finish button
    Then I verify that success message is displayed
  
