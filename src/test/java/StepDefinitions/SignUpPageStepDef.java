package StepDefinitions;

import AutomationExercise.AccountInformationPage;
import AutomationExercise.SignUppage;
import Hooks.Hooks;
import Pojo.SignUpData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SignUpPageStepDef {
    public WebDriver driver = Hooks.driver;
    private SignUppage signuppage;
     private SignUpData signupdata;
     private AccountInformationPage accountinfopage;

    public SignUpPageStepDef() {
        this.signuppage = new SignUppage();
        this.accountinfopage = new AccountInformationPage();
        ObjectMapper mapper = new ObjectMapper();
        try{
            signupdata = mapper.readValue(new File("src/test/resources/DataFolder/SignUp.json"),SignUpData.class);
            String randomName = "Grace"+ new Random().nextInt(10000);
            String randomEmail = randomName.toLowerCase()+"@example.com";
            signupdata.setPassword(randomName);
            signupdata.setEmail(randomEmail);
        }catch( IOException e)
        {
            e.printStackTrace();
        }
    }

    @Given("the user is on Automation Exercise page")
    public void the_user_is_on_Automation_exercise_page() {
        driver.get("https://automationexercise.com/login");
    }

    @Given("user click Signup_login link and SignUp page should display")
    public void ClickSignUpLink() {
        signuppage.clickSignupLink();
        String loginKeyword = signuppage.getLoginPageKeyword();
        Assert.assertEquals("Keyword does not match", "login", loginKeyword);
    }

    @When("user enter the name and email address")
    public void FillDetails() {
        signuppage.fillSignUpForm(signupdata.getName(), signupdata.getEmail());
    }

    @And("click on SignUp button")
    public void clickOnSignUpButton() {
        signuppage.ClickSignupButton();
    }

    @Then("the user should see the account information page")
    public void AccountInformationPageDisplay() {
        String signupkeyword = signuppage.SignUpPageURL();
        Assert.assertEquals("SignUp URL validation failed", "signup", signupkeyword);
    }
    @When("the user selects a gender and verify the name and email")
    public void VerifyNameAndEmail() {
        accountinfopage.selectGender();
        String actualName =  accountinfopage.verifyName();
        String actualEmail = accountinfopage.verifyEmail();

        String expectedName = signupdata.getName();
        String expectedEmail = signupdata.getEmail();

        Assert.assertEquals("Name not found",expectedName,actualName);
        Assert.assertEquals("Email not found",expectedEmail,actualEmail);
    }

    @And("the user sets a password, select Data of Birth, check the Sign up for our newsletter box")
    public void EnterAccountDetails() {
        accountinfopage.enterPassword(signupdata.getPassword());
        accountinfopage.selectDay(signupdata.getDay());
        accountinfopage.selectMonth(signupdata.getMonth());
        accountinfopage.selectYear(signupdata.getYear());
        accountinfopage.selectNewsletter();
    }

    @And("the user enters firstname,lastname,company,address,selects country,state,city,zipcode and mobile number")
    public void EnterAddressDetails() {
        accountinfopage.FirstName(signupdata.getFirstName());
        accountinfopage.LastName(signupdata.getLastName());
        accountinfopage.Company(signupdata.getCompanyName());
        accountinfopage.SelectCountry(signupdata.getCountry());
        accountinfopage.Address1(signupdata.getAddress1());
        accountinfopage.Address2(signupdata.getAddress2());
        accountinfopage.State(signupdata.getState());
        accountinfopage.City(signupdata.getCity());
        accountinfopage.Zipcode(signupdata.getZip());
        accountinfopage.MobileNumber(signupdata.getPhone());
    }

    @Then("the user clicks on Create Account and account should be successfully created")
    public void CreateAccountSuccessfully() {
        accountinfopage.SubmitButton();
        accountinfopage.AccountCreated();
    }
}
