package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.RecipePage;

public class RecipeSteps {

    RecipePage recipePage = new RecipePage(Hooks.driver);

 
    @When("User creates a new recipegeneral details")
    public void user_creates_a_new_recipe() throws InterruptedException {
        recipePage.navigateToRecipePage();
        recipePage.addNewRecipeGeneral("Recipe Automation2", "Recipe Automation2", "Recipe Automation2");
    }

    @When("User wants to enter a weighing Details")
    public void user_wants_to_enter_a_weighing_details() {
        recipePage.enterWeighingDetails("10");
    }

    @When("User wants to enter a Mixing Details")
    public void user_wants_to_enter_a_mixing_details() {
        recipePage.enterMixingDetails();
    }

    @When("User wants to enter a Miscellaneous Details")
    public void user_wants_to_enter_a_miscellaneous_details() {
        recipePage.enterMiscellaneousDetails();
    }

    @Then("Recipe should be created successfully")
    public void recipe_should_be_created_successfully() {
        System.out.println("Recipe created successfully!");
    }

    // Validation Scenarios
 

    @When("User tries to create a recipe without entering recipe name")
    public void user_tries_to_create_a_recipe_without_entering_recipe_name() {
        recipePage.navigateToRecipePage();
        recipePage.addNewRecipeGeneral("", "Product Automation", "Testing without name");
    }

    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String expectedError) {
        String actualError = recipePage.getErrorMessage();
        Assert.assertEquals(actualError, expectedError, "Error message mismatch!");
    }

@When("User tries to create a recipe without entering product name")
public void user_tries_to_create_a_recipe_without_entering_product_name() {
	 recipePage.navigateToRecipePage();
     recipePage.addNewRecipeGeneral("Recipe Automation 2", "", "Testing without name");
   
}

    @When("User tries to create a recipe with existing recipe name {string}")
    public void user_tries_to_create_a_recipe_with_existing_recipe_name(String recipeName) {
        recipePage.navigateToRecipePage();
        recipePage.addNewRecipeGeneral(recipeName, "Duplicate Product", "Duplicate Desc");
        try { Thread.sleep(500); } catch (InterruptedException ignored) {} // allow toast to render
    }

    
    @Then("User should see a transient error message {string} for duplicate recipe")
    public void user_should_see_transient_error_message_for_duplicate_recipe(String expectedPartialText) {
        String actualError = recipePage.getDuplicateRecipeErrorMessage(5); // wait up to 5 sec
        Assert.assertTrue(actualError.contains(expectedPartialText),
            "Transient error message mismatch! Expected to contain: " + expectedPartialText + " but found: " + actualError);
    }


    @When("User navigates to RecipePage")
    public void user_navigates_to_recipe_page() {
      recipePage.navigateToRecipePage();
    }
 
    @Then("Created Recipe {string} should be displayed in the recipe list")
    public void created_recipe_should_be_displayed_in_the_recipe_list(String recipeName) {
        boolean isPresent = recipePage.isRecipePresent(recipeName);
        Assert.assertTrue(isPresent, " Recipe " + recipeName + " is not present in the list!");
    }
    @When("User tries to add a material without selecting manadatory fields except material field")
    public void user_tries_to_add_a_material_without_selecting_manadatory_fields_except_material_field() {
        recipePage.navigateToRecipePage();
        recipePage.addNewRecipeGeneral("Weighing Validation", "Weighing Validation", "Testing weighing validations");
        recipePage.selectMaterialWeighingAndClickNext();
    }

    @Then("User should get a proper warning message for every field")
    public void user_should_get_a_proper_warning_message_for_every_field() {
        Assert.assertEquals(recipePage.getScaleValidationMsg(), "Please select a Scale");
        Assert.assertEquals(recipePage.getWeightValidationMsg(), "Please add set Weight");
        Assert.assertEquals(recipePage.getToleranceValidationMsg(), "Please select Tolerance type");
        Assert.assertEquals(recipePage.getLowToleranceValidationMsg(), "Please enter valid Low Tolerance");
        Assert.assertEquals(recipePage.getHighToleranceValidationMsg(), "Please enter a valid High Tolerance");
        Assert.assertEquals(recipePage.getChargesValidationMsg(), "Please add atleast one charge data");
    }
    @When("User selects material and scale but leaves weight and charges empty")
    public void user_selects_material_and_scale_but_leaves_weight_and_charges_empty() {
    	 recipePage.navigateToRecipePage();
         recipePage.addNewRecipeGeneral("Weighing Validation1", "Weighing Validation1", "Testing weighing validations1");
        recipePage.selectMaterialAndScaleAndClickNext();
    }

    @Then("User should see weight and charges validation messages")
    public void user_should_see_weight_and_charges_validation_messages() {
        Assert.assertEquals(recipePage.getWeightValidationMsg(), "Please add set Weight");
        Assert.assertEquals(recipePage.getChargesValidationMsg(), "Please add atleast one charge data");
    }
    @When("User creates a new recipegeneral details again")
    public void user_creates_a_new_recipe_again() throws InterruptedException {
        recipePage.navigateToRecipePage();
        recipePage.addNewRecipeGeneral("Recipe Automation3", "Recipe Automation3", "Recipe Automation3");
    }
    
    @When("User leaves one miscellaneous field empty")
    public void user_leaves_one_miscellaneous_field_empty() {
        recipePage.clearMis();
    }

    @Then("Submit button should be disabled")
    public void submit_button_should_be_disabled() {
        Assert.assertFalse(recipePage.isSubmitEnabled(), "Submit button is still enabled");
    }
    

    @When("User enters a recipe name")
    public void user_enters_a_recipe_name() {
        recipePage.navigateToRecipePage();
        recipePage.enterRecipeName("Special_Recipe@2025!bfbebvjehgjhhjhkjhgvhhhhhjh");
    }

    @Then("Recipe name field should accept the value")
    public void recipe_name_field_should_accept_the_value() {
        String actualValue = recipePage.getRecipeNameValue();

        Assert.assertFalse(actualValue.isEmpty(), 
            "Recipe name field is empty, value was not accepted!");
        Assert.assertTrue(actualValue.length() <= 30,  
            "Recipe name exceeded max length of 30!");
    }
    

@When("User creates a new recipegeneral details new")
public void user_creates_a_new_recipegeneral_details_new() {
	 recipePage.navigateToRecipePage();
     recipePage.addNewRecipeGeneral("Recipe Automation5", "Recipe Automation5", "Recipe Automation5");
}
    @When("User wants to enter a weighing Details with negative setweight and tolerance value")
    public void user_wants_to_enter_a_weighing_details_with_negative_setweight_and_tolerance_value() {
        recipePage.enterNegativeWeighingDetails("-10", "-0.08", "-0.08");
    }

    @Then("User should see a proper error message")
    public void user_should_see_a_proper_error_message() {
        Assert.assertEquals(recipePage.getWeightValidationMsg(), "Please add set Weight");
        Assert.assertEquals(recipePage.getLowToleranceValidationMsg(), "Please enter valid Low Tolerance");
        Assert.assertEquals(recipePage.getHighToleranceValidationMsg(), "Please enter a valid High Tolerance");
    }



}
