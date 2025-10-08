package simpleProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class viewRecipe {
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
	      
	        
	        By firstEyeIconLocator = By.xpath("(//i[@class='icon-eye icons font-1xl px-2 cp'])[1]");

	        // Wait until the element is clickable
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait1.until(ExpectedConditions.presenceOfElementLocated(firstEyeIconLocator));
	        wait1.until(ExpectedConditions.elementToBeClickable(firstEyeIconLocator));

	        // Always re-find and click (fresh reference)
	        driver.findElement(firstEyeIconLocator).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//span[contains(text(),'Level 1 Release')]")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//span[contains(text(),'Level 2 Release')]")).click();

	        

}}
