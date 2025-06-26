package StepDefinitions;

import Hooks.Hooks;
import AutomationExercise.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginPageStepDef {

    public WebDriver driver = Hooks.driver;
    private Loginpage loginpage;

    public LoginPageStepDef() {
        this.loginpage = new Loginpage();
    }

    @Given("I am on the Automation Exercise page")
    public void i_am_on_the_Automation_exercise_page() {
        driver.get("https://automationexercise.com/login");
    }

    @Given("I have entered valid username and password")
    public void ValidCredential() {
        loginpage.ValidLogin("Sarah@example.com","sarah123#");
    }

    @Given("I have entered invalid {string} and {string}")
    public void InvalidCredential(String email, String password) {
            loginpage.Invalidlogin(email,password);

    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginpage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(loginpage.checkLogoutLink());
    }

    @Then("I should see an error message indicating {string}")
    public void VerifyErrorMessage(String message) {
        Assert.assertTrue("Error Message not displayed", loginpage.isErrorDisplayed());
    }


    @Then("the email field should show a validation error")
    public void theEmailFieldShouldShowAValidationError() {
        String message = loginpage.getEmailValidationMessage();
        System.out.println("Error " + message);
        Assert.assertTrue(message.contains("@"));

    }

}


