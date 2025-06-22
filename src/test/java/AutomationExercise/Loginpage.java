package AutomationExercise;

import Hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

     WebDriver driver;

    private  By emailInputLocator=By.name("email");
    private  By passwordInputLocator=By.name("password");
    private  By loginButtonLocator=By.cssSelector("button");
    private  By logoutLinkLocator = By.linkText("Logout");

    public Loginpage(){
        this.driver= Hooks.driver;
       // PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email){
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }
    public void enterPassword(String password){
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton(){
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }
    public boolean checkLogoutLink() {
        return driver.findElements(logoutLinkLocator).getFirst().isDisplayed();
    }

    public void login(String email, String password){
            enterEmail(email);
            enterPassword(password);
            clickLoginButton();
        }

        public String getEmailValidationMessage(){
         return  driver.findElement(emailInputLocator).getAttribute("validationMessage");
        }

    }
