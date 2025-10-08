Feature: Recipe Management
@TC_001
  Scenario: Create a new Recipe
    Given User is on login page
    When User logs in with valid credentials
    And User creates a new recipegeneral details
    And User wants to enter a weighing Details
    And User wants to enter a Mixing Details
    And User wants to enter a Miscellaneous Details
    Then Recipe should be created successfully
    @TC_002
     Scenario: Verify created Recipe is displayed in Recipe List after creation
    Given User is on login page
    When User logs in with valid credentials
    And User navigates to RecipePage 
    Then Created Recipe "Recipe Automation2" should be displayed in the recipe list
@TC_003
  Scenario: Verify Recipe Name is mandatory
    Given User is on login page
    When User logs in with valid credentials
    And User tries to create a recipe without entering recipe name
    Then User should see an error message "Please provide a valid Recipe Name without leading or trailing spaces"
  @TC_004  
     Scenario: Verify Product Name is mandatory
    Given User is on login page
    When User logs in with valid credentials
    And User tries to create a recipe without entering product name
    Then User should see an error message "Please provide a valid Product Name without leading or trailing spaces"
@TC_005
 Scenario: Verify duplicate Recipe Name is not allowed
  Given User is on login page
  When User logs in with valid credentials
  And User tries to create a recipe with existing recipe name "Recipe Automation2"
  Then User should see a transient error message "already added" for duplicate recipe
@TC_006
 Scenario: Verify all the mandatory fields in Weighing page  
  Given User is on login page
  When User logs in with valid credentials
  And User tries to add a material without selecting manadatory fields except material field
  Then User should get a proper warning message for every field
@TC_007
Scenario: Verify weighing validation for weight and charges only
  Given User is on login page
  When User logs in with valid credentials
  And User selects material and scale but leaves weight and charges empty
  Then User should see weight and charges validation messages
@TC_008
  Scenario: Verify user cannot submit recipe when one miscellaneous field is empty
   Given User is on login page
    When User logs in with valid credentials
    And User creates a new recipegeneral details again
    And User wants to enter a weighing Details
    And User wants to enter a Mixing Details
  And User leaves one miscellaneous field empty
  Then Submit button should be disabled
  @TC_009
Scenario: Verify Recipe Name allows special characters within 30 characters
  Given User is on login page
  When User logs in with valid credentials
  And User enters a recipe name 
  Then Recipe name field should accept the value

 @TC_010
Scenario: Verify User can able to enter negative value for setweight and tolerances
  Given User is on login page
    When User logs in with valid credentials
    And User creates a new recipegeneral details new
    And User wants to enter a weighing Details with negative setweight and tolerance value
    Then User should see a proper error message 

  
