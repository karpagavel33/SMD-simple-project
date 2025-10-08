package simpleProject;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchBrowser {
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
        Thread.sleep(3000);
        //Click add new Button
        driver.findElement(By.xpath("//span[contains(text(),'Add New')]")).click();
        Thread.sleep(3000);
        // Selecting Line from Dropdown
        WebElement lineDropdown = driver.findElement(By.xpath("//select[@name='lineId']"));

        
        Select select = new Select(lineDropdown);

        
        select.selectByVisibleText("YOHTMix4");
        // Enter Recipe name
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='recipeName']")).sendKeys("Recipe Automation1");
        // Enter Product name
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='productName']")).sendKeys("Recipe Automation1");
        //Enter description
        Thread.sleep(3000);
        driver.findElement(By.xpath("//textarea[@name='recipeDescription']")).sendKeys("Recipe Automation1");
        //Scrolling the page
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
//        click next button
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//span[contains(text(),'Next')])[1]")).click();
        Thread.sleep(3000);
        WebElement dropdown = driver.findElement(By.xpath("//div[@class='Select is-clearable is-searchable Select--single']"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", dropdown);
        Thread.sleep(500);
        js1.executeScript("arguments[0].click();", dropdown);
//        Thread.sleep(3000);
//        WebElement matDropdown = driver.findElement(By.xpath("//div[@class='Select is-clearable is-searchable Select--single']"));
//
//        
//        Select select11 = new Select(matDropdown);
//
//        
//        select11.selectByIndex(1);
//        Thread.sleep(3000);
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//table//tr[2]/td[1])")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@class='btn btn-primary']//span[contains(text(),'Submit')]")).click();
        
        Thread.sleep(3000);
        WebElement scaleDropdown = driver.findElement(By.xpath("//select[@name='scaleId']"));

        
        Select select1 = new Select(scaleDropdown);

        
        select1.selectByIndex(1);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='setWeight']")).sendKeys("10");
        Thread.sleep(3000);
        WebElement Noofcharges = driver.findElement(By.xpath("//select[@name='chargesNo']"));

        
        Select select2 = new Select(Noofcharges);

        
        select2.selectByIndex(1);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@class='mt-3 btn btn-outline-success btn-block']//span[contains(text(),'Add')]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("(//span[contains(text(),'Next')])[2]")).click();
        Thread.sleep(3000);
        //mixing start
        WebElement MixingAction = driver.findElement(By.xpath("//select[@name='mixingAction']"));

        
        Select select3 = new Select(MixingAction);

        
        select3.selectByIndex(1);
        Thread.sleep(3000);
        WebElement MixingMode = driver.findElement(By.xpath("//select[@name='mixingMode']"));

        
        Select select4 = new Select(MixingMode);

        
        select4.selectByIndex(1);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@class='btn btn-outline-success btn-block']//span[contains(text(),'Add')]")).click();
        Thread.sleep(3000);
        WebElement MixingAction1 = driver.findElement(By.xpath("//select[@name='mixingAction']"));

        
        Select select5 = new Select(MixingAction1);

        
        select5.selectByVisibleText("Feed Oil1 With Ram Down");
        Thread.sleep(3000);
WebElement MixingMode1 = driver.findElement(By.xpath("//select[@name='mixingMode']"));

        
        Select select6 = new Select(MixingMode1);

        
        select6.selectByIndex(1);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@class='btn btn-outline-success btn-block']//span[contains(text(),'Add')]")).click();

        Thread.sleep(3000);
        Thread.sleep(3000);
        WebElement MixingAction2 = driver.findElement(By.xpath("//select[@name='mixingAction']"));

        
        Select select7 = new Select(MixingAction2);

        
        
        select7.selectByVisibleText("Batch Discharge With Ram Float");
        Thread.sleep(3000);
WebElement MixingMode2 = driver.findElement(By.xpath("//select[@name='mixingMode']"));

        
        Select select8 = new Select(MixingMode2);

        
        select8.selectByIndex(1);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[@class='btn btn-outline-success btn-block']//span[contains(text(),'Add')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("(//span[contains(text(),'Next')])[3]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
        // view Recipe
//        
     // Locator for the first eye icon
     // Define the locator
       




        // Close browser
        //driver.quit();
    }
}