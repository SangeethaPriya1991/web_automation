package AutomationExercise;

import Hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    WebDriver driver;

    public Loginpage() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    WebElement emailInputLocator;
    @FindBy(name = "password")
    WebElement passwordInputLocator;
    @FindBy(css = "button")
    WebElement loginButtonLocator;
    @FindBy(linkText = "Logout")
    WebElement logoutLinkLocator;
    @FindBy(css = "p[style='color: red;']")
    WebElement errorMessageLocator;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
    WebElement emailError;

    public void ValidLogin(String emailaddress, String password){
        emailInputLocator.sendKeys(emailaddress);
        passwordInputLocator.sendKeys(password);
    }

    public void Invalidlogin(String email, String password) {
        emailInputLocator.sendKeys(email);
        passwordInputLocator.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButtonLocator.click();
    }

    public boolean checkLogoutLink() {

        return logoutLinkLocator.isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return errorMessageLocator.isDisplayed();
    }
     public String getEmailValidationMessage() {
        return emailInputLocator.getAttribute("validationMessage");
     }


}
