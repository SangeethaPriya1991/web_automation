package StepDefinitions;

import Hooks.Hooks;
import AutomationExercise.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageStepDef {

    public WebDriver driver = Hooks.driver;
    private Loginpage loginpage;

    @Given("I am on the Automation Exercise page")
    public void i_am_on_the_Automation_exercise_page() {
        driver.get("https://automationexercise.com/login");
        loginpage = new Loginpage();
    }

    @Given("I have entered valid username and password")
    public void i_have_entered_valid_username_and_password() {
        loginpage.enterEmail("Sarah@example.com");
        loginpage.enterPassword("sarah123#");
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginpage.enterEmail(username);
        loginpage.enterPassword(password);
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
    public void i_should_see_an_error_message_indicating(String message) {
        Assert.assertTrue(driver.findElement(By.cssSelector("p[style='color: red;']")).isDisplayed());
    }


    @Then("the email field should show a validation error")
    public void theEmailFieldShouldShowAValidationError() {
        String message = loginpage.getEmailValidationMessage();
        System.out.println(message);
        Assert.assertTrue(message.contains("@"));

    }

}


