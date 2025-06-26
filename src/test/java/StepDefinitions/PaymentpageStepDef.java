package StepDefinitions;

import AutomationExercise.Paymentpage;
import Pojo.PaymentData;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import Hooks.Hooks;
import java.io.File;
import java.io.IOException;

public class PaymentpageStepDef {
     WebDriver driver;
    Paymentpage paymentpage;
    PaymentData paymentdata;

    public PaymentpageStepDef() {
        this.driver = Hooks.driver;
        this.paymentpage = new Paymentpage();
        ObjectMapper mapper = new ObjectMapper();
        try
        {
            this.paymentdata = mapper.readValue(new File("src/test/resources/DataFolder/payment.json"), PaymentData.class);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Given("the user is on the payment page")
    public void VerifyPaymentpageDisplay() {
        paymentpage.PaymentPageDisplay();
    }

    @When("user should enters card name,card number, cvc, expiry month and expiry year")
    public void EnterCardDetails() {
            paymentpage.entercardName(paymentdata.getCardName());
            paymentpage.entercardNumber(paymentdata.getCardNumber());
            paymentpage.entercvc(paymentdata.getCvc());
            paymentpage.enterexpiry_month(paymentdata.getExpiryMonth());
            paymentpage.enterexpiry_year(paymentdata.getExpiryYear());
    }

    @And("the user clicks on submit page")
    public void theUserClicksOnSubmitPage() {
        paymentpage.clickSubmitButton();
    }


    @Then("the user should see the confirmation message")
    public void theUserShouldSeeTheConfirmationMessage() {
        paymentpage.ConfirmationMessage();
    }
}

