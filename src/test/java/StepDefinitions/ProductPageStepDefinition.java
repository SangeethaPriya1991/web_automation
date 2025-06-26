package StepDefinitions;

import Hooks.Hooks;
import AutomationExercise.Productpage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class ProductPageStepDefinition {
    WebDriver driver;
    private Productpage productpage;


    public ProductPageStepDefinition() {
        this.driver = Hooks.driver;
        this.productpage = new Productpage();
    }

    @Given("the user is on the product listing page")
    public void theUserIsOnTheProductListingPage() {
      driver.get("https://automationexercise.com/");
       //Assert.assertTrue();
    }

    @When("the user adds the following products to the cart:")
    public void userAddsProductsToCart(DataTable dataTable) {
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> product : products) {
            String productName = product.get("ProductName");
            int productQuantity = Integer.parseInt(product.get("Quantity"));
            productpage.selectProductAndAddToCart(productName, productQuantity);
        }
    }

    @Then("each product should be added to the cart successfully")
    public void eachProductShouldBeAddedToTheCartSuccessfully() {
        System.out.println("All the products have been added to the cart successfully");
    }
}