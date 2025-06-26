package StepDefinitions;

import Hooks.Hooks;
import AutomationExercise.CheckoutAndPlaceOrderpage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class CheckoutAndPlaceOrderpageStepDefinition {

     WebDriver driver;
    private CheckoutAndPlaceOrderpage checkoutandplaceorderpage;

    public CheckoutAndPlaceOrderpageStepDefinition() {
        this.driver = Hooks.driver;
        this.checkoutandplaceorderpage = new CheckoutAndPlaceOrderpage();
    }
    @Given("the user is on the cart listing page")
    public void the_user_is_on_the_cart_listing_page() {
        checkoutandplaceorderpage.navigateToCart();
    }

    @Then("each product should be present in the cart with the correct quantity")
    public void verifyProductsAddedToCart(DataTable dataTable) {
        List<Map<String,String>>  products = dataTable.asMaps(String.class, String.class);
        for (Map<String,String> row : products) {
            String productName = row.get("ProductName");
            int expectedQuantity = Integer.parseInt(row.get("Quantity"));
            boolean isCorrect = checkoutandplaceorderpage.isProductInCart(productName, expectedQuantity);
            Assert.assertTrue("Product '" + productName + " ' does not have the expected quantity: " + expectedQuantity,isCorrect);
            System.out.println("Product '" + productName + " 'has the expected quantity: " + expectedQuantity);

        }
    }

    @When("the user click on Proceed to checkout button")
    public void ClickOnProceedToCheckoutButton() {
        checkoutandplaceorderpage.clickProceedToCheckout();
    }

    @And("click on Place Order button")
    public void ClickOnPlaceOrderButton() {
        checkoutandplaceorderpage.clickPlaceOrder();
    }

    @Then("Payment page should display")
    public void PaymentPageDisplay() {
      checkoutandplaceorderpage.PaymentPageDisplay();
    }
}
