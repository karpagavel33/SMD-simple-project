package stepDefinitions;

import pages.RecipePage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class Recipe_Edit_Steps {
	RecipePage recipePage = new RecipePage(Hooks.driver);
	
	@When("User can edit a product name in recipe general")
	public void user_can_edit_a_product_name_in_recipe_general() {
	recipePage.navigateToRecipePage();
	}

	@When("User can edit a Description in recipe general")
	public void user_can_edit_a_description_in_recipe_general() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User can give remarks and Edit")
	public void user_can_give_remarks_and_edit() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
