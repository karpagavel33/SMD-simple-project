package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class LoginPage extends BasePage {

    private By email = By.xpath("//input[@name='email']");
    private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@class='px-4 btn btn-primary']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage(String url) {
        driver.get(url);
        // wait until email field is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
    }

    public void login(String userEmail, String userPassword) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        emailField.clear();
        emailField.sendKeys(userEmail);

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        passwordField.clear();
        passwordField.sendKeys(userPassword);

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }
}

