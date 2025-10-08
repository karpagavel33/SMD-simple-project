package stepDefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(Hooks.driver);

    @Given("User is on login page")
    public void user_is_on_login_page() {
        loginPage.openLoginPage("http://192.168.5.66:8001/login");
    }

    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage.login("userautomation@smartcontrols.in", "user@123");
    }
}
