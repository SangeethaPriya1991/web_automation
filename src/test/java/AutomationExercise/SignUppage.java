package AutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Hooks.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUppage {
    WebDriver driver;

    public SignUppage() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
    WebElement signupLink;

    @FindBy(tagName = "form")
    List<WebElement> forms;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    WebElement signupButton;

    public void clickSignupLink() {
        signupLink.click();
    }

    public String   getLoginPageKeyword(){
        String loginURL = driver.getCurrentUrl();
        return  loginURL.substring(loginURL.lastIndexOf("/")+1);
    }
    public void fillSignUpForm(String name,String email) {
        for (WebElement form : forms) {
            String actions = form.getAttribute("action");
            if (actions != null && actions.contains("signup")) {
                form.findElement(By.name("name")).sendKeys(name);
                form.findElement(By.name("email")).sendKeys(email);
            }
        }
    }
    public void ClickSignupButton(){
        signupButton.click();
    }

    public String SignUpPageURL(){
        String signupURL = driver.getCurrentUrl();
        return signupURL.substring(signupURL.lastIndexOf("/")+1);

    }








}
