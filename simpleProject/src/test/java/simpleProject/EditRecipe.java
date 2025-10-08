package simpleProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditRecipe {
	 public static void main(String[] args) throws InterruptedException {
	        // Setup ChromeDriver automatically
	        WebDriverManager.chromedriver().setup();

	        // Launch browser
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Open login page
	        driver.get("http://192.168.5.66:8001/login"); // Replace with your actual login URL
	      

	        System.out.println("Page Title: " + driver.getTitle());
	        //Login Credentials
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("userautomation@smartcontrols.in");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("user@123");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//button[@class='px-4 btn btn-primary']")).click();
	        
	        //navigate to recipe management
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//span[contains(text(),'Recipe Management')]")).click();
	        //navigate to recipes
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//li[@class='nav-item']//span[contains(text(),'Recipes')]")).click();
	        By EditIconLocator = By.xpath("(//i[@class='icon-pencil icons font-1xl px-2 cp'])[1]");

	        // Wait until the element is clickable
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait1.until(ExpectedConditions.presenceOfElementLocated(EditIconLocator));
	        wait1.until(ExpectedConditions.elementToBeClickable(EditIconLocator));

	        // Always re-find and click (fresh reference)
	        driver.findElement(EditIconLocator).click();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        WebElement description = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//textarea[@name='recipeDescription']")
	            )
	        );

	        description.clear();
	        description.sendKeys("Recipe Automation2_Edit");

//	        //Scrolling the page
	        Thread.sleep(3000);
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
////	        click next button
	        Thread.sleep(3000);

	        driver.findElement(By.xpath("(//textarea[@id='text-input'])[2]")).sendKeys("Edit");
	        Thread.sleep(3000);

	       
   driver.findElement(By.xpath("//button[@id='UncontrolledTooltipRecipeEditGen']//span[contains(text(),'Edit')]")).click();
	        

   Thread.sleep(3000);

   
   driver.findElement(By.xpath("//a[@class='nav-link']//span[contains(text(),'Weighing')]")).click();

	         Thread.sleep(3000);
	         driver.findElement(By.xpath("(//span[contains(text(),'Add')])[1]")).click();
//	         Thread.sleep(3000);
//	         WebElement dropdown = driver.findElement(By.xpath("//div[@class='Select is-clearable is-searchable Select--single']"));
//	         JavascriptExecutor js1 = (JavascriptExecutor) driver;
//	         js1.executeScript("arguments[0].scrollIntoView(true);", dropdown);
//	         Thread.sleep(500);
//	         js1.executeScript("arguments[0].click();", dropdown);
//	         Thread.sleep(3000);
//
//	         driver.findElement(By.xpath("//td[normalize-space()='32-30001']/preceding-sibling::td//input[@type='radio']")).click();
//	         Thread.sleep(3000);
//
//	         driver.findElement(By.xpath("//button[@class='btn btn-primary']//span[contains(text(),'Submit')]")).click();
//	         Thread.sleep(3000);
//	         WebElement scaleDropdown = driver.findElement(By.xpath("//select[@name='scaleId']"));
//
//	         
//	         Select select1 = new Select(scaleDropdown);
//
//	         
//	         select1.selectByIndex(1);
//	         Thread.sleep(3000);
//	         driver.findElement(By.xpath("//input[@name='setWeight']")).sendKeys("10");
//	         Thread.sleep(3000);
//	         WebElement Noofcharges = driver.findElement(By.xpath("//select[@name='chargesNo']"));
//
//	         
//	         Select select2 = new Select(Noofcharges);
//
//	         
//	         select2.selectByIndex(1);
//	         Thread.sleep(3000);
//
//	         driver.findElement(By.xpath("//button[@class='mt-3 btn btn-outline-success btn-block']//span[contains(text(),'Add')]")).click();
//

   
// List of material codes to add one by one
//	         WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
//	         JavascriptExecutor js1 = (JavascriptExecutor) driver;
//
//	         String[] materialCodes = {"11-00003", "31-00126", "32-30001"};
//
//	         for (String code : materialCodes) {
//	             // === Click the main "Add" button to start a new material entry ===
//	             WebElement addEntryBtn = wait11.until(ExpectedConditions
//	                 .elementToBeClickable(By.xpath("(//span[contains(text(),'Add')])[1]")));
//	             js1.executeScript("arguments[0].scrollIntoView(true);", addEntryBtn);
//	             js1.executeScript("arguments[0].click();", addEntryBtn);
//
//	             // === Open material dropdown ===
//	             WebElement dropdown = wait11.until(ExpectedConditions
//	                 .visibilityOfElementLocated(By.xpath("//div[contains(@class,'Select') and contains(@class,'is-searchable')]")));
//	             js1.executeScript("arguments[0].scrollIntoView(true);", dropdown);
//	             js1.executeScript("arguments[0].click();", dropdown);
//
//	             // === Select the material by radio button ===
//	             String radioXpath = "//td[normalize-space()='" + code + "']/preceding-sibling::td//input[@type='radio']";
//	             WebElement radio = wait11.until(ExpectedConditions
//	                 .elementToBeClickable(By.xpath(radioXpath)));
//	             radio.click();
//
//	             // === Submit the selection ===
//	             WebElement submitBtn = wait11.until(ExpectedConditions
//	                 .elementToBeClickable(By.xpath("//button[@class='btn btn-primary']//span[contains(text(),'Submit')]")));
//	             submitBtn.click();
//
//	             // === Select Scale Dropdown ===
//	             WebElement scaleDropdown = wait11.until(
//	                 ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='scaleId']"))
//	             );
//	             Select scaleSelect = new Select(scaleDropdown);
//
//	             // Wait until at least two options are available
//	             wait11.until(d -> scaleSelect.getOptions().size() > 1);
//
//	             // Select the second option (index=1)
//	             scaleSelect.selectByIndex(1);
//
//	             // === Enter weight ===
//	             WebElement weightField = wait11.until(
//	                 ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='setWeight']"))
//	             );
//	             weightField.clear();
//	             weightField.sendKeys("10");
//
//	             // === Select number of charges ===
//	             WebElement chargesDropdown = wait11.until(
//	                 ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='chargesNo']"))
//	             );
//	             Select chargesSelect = new Select(chargesDropdown);
//	             chargesSelect.selectByIndex(1);
//
//	             // === Click Add button to save this material entry ===
//	             WebElement addBtn = wait11.until(ExpectedConditions
//	                 .elementToBeClickable(By.xpath("//button[@class='mt-3 btn btn-outline-success btn-block']//span[contains(text(),'Add')]")));
//	             js1.executeScript("arguments[0].scrollIntoView(true);", addBtn);
//	             js1.executeScript("arguments[0].click();", addBtn);
//	         }
	         WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
	         JavascriptExecutor js1 = (JavascriptExecutor) driver;

	         String[] materialCodes = {"11-00003", "31-00126", "32-30001"};

	         for (String code : materialCodes) {
	             // === Click the main "Add" button to start a new material entry ===
	             WebElement addEntryBtn = wait11.until(ExpectedConditions
	                 .elementToBeClickable(By.xpath("(//span[contains(text(),'Add')])[1]")));
	             js1.executeScript("arguments[0].scrollIntoView(true);", addEntryBtn);
	             js1.executeScript("arguments[0].click();", addEntryBtn);

	             // === Open material dropdown ===
	             WebElement dropdown = wait11.until(ExpectedConditions
	                 .visibilityOfElementLocated(By.xpath("//div[contains(@class,'Select') and contains(@class,'is-searchable')]")));
	             js1.executeScript("arguments[0].scrollIntoView(true);", dropdown);
	             js1.executeScript("arguments[0].click();", dropdown);

	             // === Select the material by radio button ===
	             String radioXpath = "//td[normalize-space()='" + code + "']/preceding-sibling::td//input[@type='radio']";
	             WebElement radio = wait11.until(ExpectedConditions
	                 .elementToBeClickable(By.xpath(radioXpath)));
	             radio.click();

	             // === Submit the selection ===
	             WebElement submitBtn = wait11.until(ExpectedConditions
	                 .elementToBeClickable(By.xpath("//button[@class='btn btn-primary']//span[contains(text(),'Submit')]")));
	             submitBtn.click();

	             // === Wait for scale dropdown to refresh ===
	             WebElement scaleDropdown = wait11.until(
	                 ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='scaleId']"))
	             );
	             Select scaleSelect = new Select(scaleDropdown);

	             // Wait until scale options are properly loaded (>=2 options)
	             wait11.until(dr -> {
	                 int optionCount = scaleSelect.getOptions().size();
	                 System.out.println("Scale options loaded: " + optionCount);
	                 return optionCount > 1;
	             });

	             // === Small buffer to ensure UI sync ===
	             Thread.sleep(1000);

	             // Select the second option (index=1)
	             scaleSelect.selectByIndex(1);

	             // === Enter weight ===
	             WebElement weightField = wait11.until(
	                 ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='setWeight']"))
	             );
	             weightField.clear();
	             weightField.sendKeys("10");

	             // === Select number of charges ===
	             WebElement chargesDropdown = wait11.until(
	                 ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='chargesNo']"))
	             );
	             Select chargesSelect = new Select(chargesDropdown);
	             chargesSelect.selectByIndex(1);

	             // === Click Add button to save this material entry ===
	             WebElement addBtn = wait11.until(ExpectedConditions
	                 .elementToBeClickable(By.xpath("//button[@class='mt-3 btn btn-outline-success btn-block']//span[contains(text(),'Add')]")));
	             js1.executeScript("arguments[0].scrollIntoView(true);", addBtn);
	             js1.executeScript("arguments[0].click();", addBtn);
	         } 


	         Thread.sleep(3000);

	         driver.findElement(By.xpath("(//span[contains(text(),'Next')])[1]")).click();
	         Thread.sleep(3000);

	         driver.findElement(By.xpath("(//button[@class='pull-right btn btn-outline-primary btn-block']//span[contains(text(),'Add')])[2]")).click();
	         Thread.sleep(3000);
	         WebElement MixingAction1 = driver.findElement(By.xpath("//select[@name='mixingAction']"));

	         
	         Select select5 = new Select(MixingAction1);

	         
	         select5.selectByVisibleText("Feed Oil1 With Ram Down");
	         Thread.sleep(3000);
	         WebElement MixingMode1 = driver.findElement(By.xpath("//select[@name='mixingMode']"));

	                 
	                 Select select6 = new Select(MixingMode1);

	                 
	                 select6.selectByIndex(1);
	                 Thread.sleep(3000);

	                 driver.findElement(By.xpath("//button[@class='mt-2 btn btn-outline-success btn-block']//span[contains(text(),'Add')]")).click();
	                 
	              // Better to target the <a> instead of <i>
	                 WebDriverWait wait111 = new WebDriverWait(driver, Duration.ofSeconds(10));
	                 WebElement arrowUp = wait111.until(
	                     ExpectedConditions.elementToBeClickable(By.xpath("//i[@id='Tooltip-arrow-up3']/parent::a"))
	                 );
	                 arrowUp.click();

//	                 Thread.sleep(3000);
//
//	                 driver.findElement(By.xpath("//i[@id='Tooltip-arrow-up3']")).click();
	                 Thread.sleep(3000);

	                 driver.findElement(By.xpath("(//button[@class='btn btn-outline-success btn-block'])[2]")).click();
//	                 Thread.sleep(3000);
//
//	                 driver.findElement(By.xpath("//label[contains(text(),'Mixer Override Energy')]")).clear();
//	                 Thread.sleep(3000);
//
//	                 driver.findElement(By.xpath("//label[contains(text(),'Mixer Override Energy')]")).sendKeys("2");
	                 WebElement mixerInput = driver.findElement(
	                		    By.xpath("//label[contains(text(),'Mixer Override Energy')]/following::input[1]")
	                		);

	                		mixerInput.clear();
	                		mixerInput.sendKeys("123");

   

}
}	