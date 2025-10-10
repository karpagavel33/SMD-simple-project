package pages;

import base.BasePage;

import java.time.Duration;
import java.util.List;
import java.util.function.BiConsumer;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecipePage extends BasePage {

    // Existing locators
    private By recipeManagementMenu = By.xpath("//span[contains(text(),'Recipe Management')]");
    private By recipesMenu = By.xpath("//li[@class='nav-item']//span[contains(text(),'Recipes')]");
    private By addNewButton = By.xpath("//span[contains(text(),'Add New')]");
    private By lineDropdown = By.xpath("//select[@name='lineId']");
    private By recipeName = By.xpath("//input[@name='recipeName']");
    private By productName = By.xpath("//input[@name='productName']");
    private By description = By.xpath("//textarea[@name='recipeDescription']");
    private By nextButton1 = By.xpath("(//span[contains(text(),'Next')])[1]");
    private By selMatDD = By.xpath("//div[@class='Select is-clearable is-searchable Select--single']");
    private By matSelection = By.xpath("(//table//tr[2]/td[1])");
    private By submitMatsel = By.xpath("//button[@class='btn btn-primary']//span[contains(text(),'Submit')]");
    private By selectScale = By.xpath("//select[@name='scaleId']");
    private By setWeight = By.xpath("//input[@name='setWeight']");
    private By charges = By.xpath("//select[@name='chargesNo']");
    private By addButtonWeighing = By.xpath("//button[@class='mt-3 btn btn-outline-success btn-block']//span[contains(text(),'Add')]");
    private By nextButtonWeighing = By.xpath("(//span[contains(text(),'Next')])[2]");
    private By mixingAction = By.xpath("//select[@name='mixingAction']");
    private By mixingMode = By.xpath("//select[@name='mixingMode']");
    private By mixingAdd = By.xpath("(//button[.//span[text()='Add']])[last()]");
    private By nextToMisc = By.xpath("(//span[contains(text(),'Next')])[3]");
    private By miscSubmitFinal = By.xpath("//span[contains(text(),'Submit')]");

    private By errorMessage = By.xpath("//div[contains(@class,'invalid-feedback') or contains(@class,'alert-danger')]");
    private By recipeTableRows = By.xpath("(//div[@role='row'])[2]/div[@role='gridcell'][2]"); 
    private By duplicateRecipeToast = By.xpath("//div[@style[contains(.,'position: fixed')]]//div");
    
    private By scaleError = By.xpath("//*[contains(text(),'Please select a Scale')]");
    private By weightError = By.xpath("//*[contains(text(),'Please add set Weight')]");
    private By toleranceError = By.xpath("//*[contains(text(),'Please select Tolerance type')]");
    private By lowTolError = By.xpath("//*[contains(text(),'Please enter valid Low Tolerance')]");
    private By highTolError = By.xpath("//*[contains(text(),'Please enter a valid High Tolerance')]");
    private By chargesError = By.xpath("//*[contains(text(),'Please add atleast one charge data')]");
    private By lowTolInput = By.xpath("//input[@name='lowTolerance']");
    private By highTolInput = By.xpath("//input[@name='highTolerance']");
    
  
    
    // All Miscellaneous input fields
    private By miscFields = By.xpath("//label[contains(normalize-space(.), 'Mixer Override Time')]/following::input[1]");

    // Submit button
    private By submitButton = By.xpath("//span[contains(text(),'Submit')]");
    
    private By recipeNameError = By.xpath("//div[contains(@class,'invalid-feedback') or contains(text(),'Recipe Name')]");

    //Recipe Edit Locaators
    private By EditIcon = By.xpath("(//i[@class='icon-pencil icons font-1xl px-2 cp'])[1]");
    private By prodNameEdit = By.xpath("//input[@name='productName']");
    private By descEdit = By.xpath("//textarea[@name='recipeDescription']");
    private By remarksEdit = By.xpath("(//textarea[@name='recipeRemarks'])[1]");
    private By buttonEdit = By.xpath("//button[@id='UncontrolledTooltipRecipeEditGen']");
    
    
    
    public RecipePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToRecipePage() {
        click(recipeManagementMenu);
        click(recipesMenu);
    }

    public void addNewRecipeGeneral(String recipe, String product, String desc) {
        click(addNewButton);

        Select select = new Select(waitForElement(lineDropdown));
        select.selectByVisibleText("YOHTMix4");

        WebElement recipeNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(recipeName));
        recipeNameField.clear();
        recipeNameField.sendKeys(recipe);

        WebElement productNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        productNameField.clear();
        productNameField.sendKeys(product);

        WebElement descField = wait.until(ExpectedConditions.visibilityOfElementLocated(description));
        descField.clear();
        descField.sendKeys(desc);

        click(nextButton1);
    }

    public void enterWeighingDetails(String sw) {
        WebElement selMat = wait.until(ExpectedConditions.elementToBeClickable(selMatDD));
        selMat.click();

        WebElement matSel = wait.until(ExpectedConditions.elementToBeClickable(matSelection));
        matSel.click();

        WebElement submitSel = wait.until(ExpectedConditions.elementToBeClickable(submitMatsel));
        submitSel.click();

        WebElement scaleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(selectScale));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scaleDropdown);

        wait.until(driver -> {
            Select select = new Select(scaleDropdown);
            return select.getOptions()
                         .stream()
                         .anyMatch(opt -> opt.getText().trim().equals("OILS1"));
        });

        Select selectScaleO = new Select(scaleDropdown);
        selectScaleO.selectByVisibleText("OILS1");

        WebElement setWeightValue = wait.until(ExpectedConditions.visibilityOfElementLocated(setWeight));
        setWeightValue.clear();
        setWeightValue.sendKeys(sw);

        WebElement chargeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(charges));
        Select selectChargeO = new Select(chargeDropdown);
        selectChargeO.selectByIndex(1);

        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addButtonWeighing));
        addBtn.click();

        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(nextButtonWeighing));
        nextBtn.click();
    }

    public void enterMixingDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        BiConsumer<String, Integer> selectAndAdd = (action, modeIndex) -> {
            WebElement actionDropdown = wait.until(ExpectedConditions.elementToBeClickable(mixingAction));
            Select actionSelect = new Select(actionDropdown);

            if (action.matches("\\d+")) {
                actionSelect.selectByIndex(Integer.parseInt(action));
            } else {
                actionSelect.selectByVisibleText(action);
            }

            WebElement modeDropdown = wait.until(ExpectedConditions.elementToBeClickable(mixingMode));
            Select modeSelect = new Select(modeDropdown);
            modeSelect.selectByIndex(modeIndex);

            WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(mixingAdd));
            addBtn.click();

            wait.until(ExpectedConditions.stalenessOf(modeDropdown));
        };

        selectAndAdd.accept("1", 1);
        selectAndAdd.accept("Feed Oil1 With Ram Down", 1);
        selectAndAdd.accept("Batch Discharge With Ram Float", 1);

        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(nextToMisc));
        nextBtn.click();
    }

    public void enterMiscellaneousDetails() {
        WebElement miscSubmit = wait.until(ExpectedConditions.elementToBeClickable(miscSubmitFinal));
        miscSubmit.click();
    }

   

    public String getErrorMessage() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return error.getText().trim();
    }

    public boolean isRecipePresent(String recipeName) {
        List<WebElement> rows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(recipeTableRows));
        return rows.stream().anyMatch(row -> row.getText().trim().equalsIgnoreCase(recipeName));
    }

    public String getDuplicateRecipeErrorMessage(int timeoutSeconds) {
        for (int i = 0; i < timeoutSeconds * 2; i++) { 
            try {
                WebElement error = driver.findElement(duplicateRecipeToast);
                if (error.isDisplayed() && !error.getText().trim().isEmpty()) {
                    return error.getText().trim();
                }
            } catch (NoSuchElementException | StaleElementReferenceException e) {
              
            }
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }
        return "";
    }
////////////////Recipe-weighing methods///////////////////

    public void selectMaterialWeighingAndClickNext() {
        WebElement selMat = wait.until(ExpectedConditions.elementToBeClickable(selMatDD));
        selMat.click();

        WebElement matSel = wait.until(ExpectedConditions.elementToBeClickable(matSelection));
        matSel.click();

        WebElement submitSel = wait.until(ExpectedConditions.elementToBeClickable(submitMatsel));
        submitSel.click();

//        // Click Next button in weighing step without entering details
//        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(nextButtonWeighing));
//        nextBtn.click();
    }

    // Validation message getters
    public String getScaleValidationMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(scaleError)).getText().trim();
    }

    public String getWeightValidationMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(weightError)).getText().trim();
    }

    public String getToleranceValidationMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(toleranceError)).getText().trim();
    }

    public String getLowToleranceValidationMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lowTolError)).getText().trim();
    }

    public String getHighToleranceValidationMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(highTolError)).getText().trim();
    }

    public String getChargesValidationMsg() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(chargesError)).getText().trim();
    }
    /**
     * Selects material and scale, skips weight and charges, clicks Next
     * → used for validation scenarios.
     */
    public void selectMaterialAndScaleAndClickNext() {
        // Select material
        WebElement selMat = wait.until(ExpectedConditions.elementToBeClickable(selMatDD));
        selMat.click();

        WebElement matSel = wait.until(ExpectedConditions.elementToBeClickable(matSelection));
        matSel.click();

        WebElement submitSel = wait.until(ExpectedConditions.elementToBeClickable(submitMatsel));
        submitSel.click();

        // Select scale
        WebElement scaleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(selectScale));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scaleDropdown);

        // Wait until OILS1 (or any required scale) is present
        wait.until(driver -> {
            Select select = new Select(scaleDropdown);
            return select.getOptions()
                         .stream()
                         .anyMatch(opt -> opt.getText().trim().equals("OILS1"));
        });

        // Select OILS1
        Select selectScaleO = new Select(scaleDropdown);
        selectScaleO.selectByVisibleText("OILS1");

    }
  
    public void clearMis() {
        WebElement miscFieldclr = wait.until(ExpectedConditions.elementToBeClickable(miscFields));
        miscFieldclr.clear();
    }

    // Method to check if submit is enabled
 // Method to check if submit is enabled
    public boolean isSubmitEnabled() {
        WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));

        // Ensure it is scrolled into view (forces refresh/repaint)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

        // Now wait until its enabled/disabled state stabilizes
        wait.until(d -> {
            boolean state = button.isEnabled();
            return state == button.isEnabled();
        });

        return button.isEnabled();
    }

    public void enterRecipeName(String recipe) {
    	 click(addNewButton);
    	 
    	         Select select = new Select(waitForElement(lineDropdown));
    	         select.selectByVisibleText("YOHTMix4");
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(recipeName));
        field.clear();
        field.sendKeys(recipe);
    }
    
    public String getRecipeNameValue() {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(recipeName));
        return field.getAttribute("value");
    }
    // Get recipe name length
    public int getRecipeNameLength() {
    	
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(recipeName));
        return field.getAttribute("value").length();
    }

    // Get validation error message for Recipe Name
    public String getRecipeNameError() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(recipeNameError));
        return error.getText().trim();
    }
   
    public void enterNegativeWeighingDetails(String weight, String lowTol, String highTol) {
        // Select material
        WebElement selMat = wait.until(ExpectedConditions.elementToBeClickable(selMatDD));
        selMat.click();

        WebElement matSel = wait.until(ExpectedConditions.elementToBeClickable(matSelection));
        matSel.click();

        WebElement submitSel = wait.until(ExpectedConditions.elementToBeClickable(submitMatsel));
        submitSel.click();

        // Wait for scale dropdown and ensure "OILS1" is present
        WebElement scaleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(selectScale));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scaleDropdown);

        wait.until(driver -> {
            Select select = new Select(scaleDropdown);
            return select.getOptions().stream()
                .anyMatch(option -> option.getText().equalsIgnoreCase("OILS1"));
        });


        Select selectScaleO = new Select(scaleDropdown);
        selectScaleO.selectByVisibleText("OILS1");

        
        WebElement setWeightValue = wait.until(ExpectedConditions.visibilityOfElementLocated(setWeight));
        setWeightValue.clear();
        setWeightValue.sendKeys(weight);

        // Enter negative Low Tolerance
        WebElement lowTolField = wait.until(ExpectedConditions.visibilityOfElementLocated(lowTolInput));
        lowTolField.clear();
        lowTolField.sendKeys(lowTol);

        // Enter negative High Tolerance
        WebElement highTolField = wait.until(ExpectedConditions.visibilityOfElementLocated(highTolInput));
        highTolField.clear();
        highTolField.sendKeys(highTol);

//        // Try clicking Add to trigger validation
//        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addButtonWeighing));
//        addBtn.click();
    }

          public void editIcon() {
        	  click(EditIcon);
			
		}
          public void productName(String prodNamevalue) {
        	  WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(prodNameEdit));
        	  product.clear();
        	  product.sendKeys(prodNamevalue);
			
		}

       public void descriptionEdit(String descriptionValue) {
    	   WebElement desc = driver.findElement(descEdit);
    	   desc.clear();
    	   desc.sendKeys(descriptionValue);
		
	}
       public void remarksEdit(String remarksValue) {
    	   WebElement remarks = driver.findElement(remarksEdit);
    	   remarks.clear();
    	   remarks.sendKeys(remarksValue);
		
	}
       
       public void buttonEdit1() {
    	  
    	  click(buttonEdit);
		
	}
}
