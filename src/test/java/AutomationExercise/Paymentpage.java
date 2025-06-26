package AutomationExercise;

import Hooks.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Paymentpage {

    WebDriver driver;

    public Paymentpage() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[2]")
    WebElement paymentPageDisplay;

    @FindBy(name = "name_on_card")
    WebElement cardNameField;

    @FindBy(name = "card_number")
    WebElement cardNumberField;

    @FindBy(name = "cvc")
    WebElement cvcField;

    @FindBy(name = "expiry_month")
    WebElement expiry_monthField;

    @FindBy(name = "expiry_year")
    WebElement expiry_yearField;

    @FindBy(id = "submit")
    WebElement submitButton;

    @FindBy(xpath = "//p[contains(text(), 'Congratulations! Your order has been confirmed!')]")
    WebElement confirmationMessage;

    public void PaymentPageDisplay() {
        Assert.assertTrue(paymentPageDisplay.isDisplayed(),"Payment page is not displayed");
        System.out.println("Payment page displayed");
    }

    public void entercardName(String cardName) {
        cardNameField.sendKeys(cardName);
    }

    public void entercardNumber(int cardNumber) {
        cardNumberField.sendKeys(String.valueOf(cardNumber));
    }

    public void entercvc(int cvc) {
        cvcField.sendKeys(String.valueOf(cvc));
    }

    public void enterexpiry_month(int expiry_month) {
        expiry_monthField.sendKeys(String.valueOf(expiry_month));
    }

    public void enterexpiry_year(int expiry_year) {
        expiry_yearField.sendKeys(String.valueOf(expiry_year));
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void ConfirmationMessage() {
        String actualmessage =confirmationMessage.getText();
        System.out.println(actualmessage);
        String expectedmessage = "Congratulations! Your order has been confirmed!";
        Assert.assertEquals(actualmessage, expectedmessage,"Order confirmation message mismatch!");
    }
}
