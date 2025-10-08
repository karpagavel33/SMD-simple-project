Feature: Recipe Management_Edit
@TC_011
  Scenario: Verify User can able to edit a recipe general details
    Given User is on login page
    When User logs in with valid credentials
    And User can edit a product name in recipe general
    And User can edit a Description in recipe general
    Then User can give remarks and Edit 
    