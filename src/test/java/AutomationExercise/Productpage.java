package AutomationExercise;

import Hooks.Hooks;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Productpage {
    private WebDriver driver;

    @FindBy(css = ".product-image-wrapper")
    List<WebElement> products;



    public Productpage() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }

    public void selectProductAndAddToCart(String productName, int quantity) {
        for (WebElement product : products) {
            List<WebElement> productText = product.findElements(By.tagName("p"));
            if (productText.get(0).getText().equals(productName)) {
                List<WebElement> viewProduct = product.findElements(By.className("choose"));
                if (!viewProduct.isEmpty()) {
                    WebElement anchor = viewProduct.get(0).findElement(By.tagName("a"));
                    if (anchor.getAttribute("href") != null) {
                        anchor.click();
                    }
                }

                WebElement verifyProduct = driver.findElement(By.xpath("//*[@class='product-information']/h2"));
                if (productName.equals(verifyProduct.getText())) {
                    WebElement quantityInput = driver.findElement(By.id("quantity"));
                    quantityInput.clear();
                    quantityInput.sendKeys(String.valueOf(quantity));

                    driver.findElement(By.xpath("//*[@class='product-information']//following::span/button")).click();

                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                    WebElement addedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));
                    String message = addedMessage.findElement(By.tagName("p")).getText();
                    Assert.assertEquals("Your product has been added to cart.", message);

                    addedMessage.findElement(By.tagName("button")).click();
                    driver.navigate().back();
                    break;
                }
            }
        }
    }


}





