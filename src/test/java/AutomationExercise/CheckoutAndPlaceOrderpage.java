package AutomationExercise;

import Hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CheckoutAndPlaceOrderpage {
    private WebDriver driver;
    private By cartButtonlocator = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]");
    private By cartInfoSection = By.id("cart_info");
    private By paymentpage = By.xpath("//*[@id=\"cart_items\"]/div/div[2]");

    public CheckoutAndPlaceOrderpage() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToCart() {
        driver.findElement(cartButtonlocator).click();
    }

    public boolean isProductInCart(String productName, int expectedQuantity) {
        WebElement cartSection = driver.findElement(cartInfoSection);
        List<WebElement> rows = cartSection.findElements(By.tagName("tr"));


        for (WebElement row : rows) {
            List<WebElement> descriptions = row.findElements(By.className("cart_description"));
            List<WebElement> quantity = row.findElements(By.className("cart_quantity"));
            if (!descriptions.isEmpty() && !quantity.isEmpty()) {
                WebElement description = descriptions.get(0);
                List<WebElement> anchors = description.findElements(By.tagName("a"));
                if (anchors.size() == 1) {
                    String text = anchors.get(0).getText();
                    if (productName.equals(text)) {
                        WebElement quantityElement = quantity.get(0);
                        String quantityText = quantityElement.getText().replaceAll("[^0-9]", "");

                        if (Integer.parseInt(quantityText) == expectedQuantity) {
                            return true;
                        }
                    }
                }
            }

        }return false;
    }

    public void clickProceedToCheckout() {
        WebElement checkout = driver.findElement(By.id("cart_items"));
        WebElement proceedToCheckout = checkout.findElement(By.id("do_action"));
        WebElement button = proceedToCheckout.findElement(By.tagName("a"));
        button.click();
    }
    public void clickPlaceOrder(){
        WebElement placeOrder = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a"));
        placeOrder.click();
    }

    public void PaymentPageDisplay(){
        WebElement paymentpagedisplay = driver.findElement(paymentpage);
        Assert.assertTrue(paymentpagedisplay.isDisplayed());
        System.out.println("Payment page displayed");
    }

}
