package AutomationExercise;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import Hooks.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage {
    WebDriver driver;

    public AccountInformationPage() {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "uniform-id_gender1")
    WebElement gender;
    @FindBy(id = "name")
    WebElement Name;
    @FindBy(id = "email")
    WebElement Email;
    @FindBy(name = "password")
    WebElement Password;
    @FindBy(id = "days")
    WebElement Day;
    @FindBy(id = "months")
    WebElement Month;
    @FindBy(id = "years")
    WebElement Year;
    @FindBy(id = "newsletter")
    WebElement Newsletter;
    @FindBy(id = "first_name")
    WebElement FirstName;
    @FindBy(id = "last_name")
    WebElement LastName;
    @FindBy(id ="company")
    WebElement Company;
    @FindBy(id = "address1")
    WebElement Address1;
    @FindBy(id = "address2")
    WebElement Address2;
    @FindBy(id = "country")
    WebElement Country;
    @FindBy(id = "state")
    WebElement State;
    @FindBy(id ="city")
    WebElement City;
    @FindBy(id ="zipcode" )
    WebElement Zipcode;
    @FindBy(id = "mobile_number")
    WebElement MobileNumber;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/button")
    WebElement SubmitButton;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement AccountCreated;

    public String VerifySignUpPage() {
       String currentURL = driver.getCurrentUrl();
        return currentURL.substring(currentURL.indexOf("/")+1);
    }

    public void selectGender() {
        gender.click();
    }

    public String verifyName() {
        return Name.getDomProperty("value");
    }

    public String verifyEmail() {
        return Email.getDomProperty("value");
    }

    public void enterPassword(String password) {
        Password.sendKeys(password);
    }

    public void selectDay(String day) {
        Day.sendKeys(day);
    }

    public void selectMonth(String month) {
        Month.sendKeys(month);
    }

    public void selectYear(String year) {
        Year.sendKeys(year);
    }

    public void selectNewsletter() {
        Newsletter.click();
    }
    public void FirstName(String firstName) {
        FirstName.sendKeys(firstName);
    }
    public void LastName(String lastName) {
        LastName.sendKeys(lastName);
    }
    public void Company(String company) {
        Company.sendKeys(company);
    }
    public void Address1(String address1) {
        Address1.sendKeys(address1);
    }
    public void Address2(String address2) {
        Address2.sendKeys(address2);
    }
    public void SelectCountry(String country) {
        Select selectCountry = new Select(Country);
        selectCountry.selectByVisibleText(country);
    }
    public void State(String state) {
        State.sendKeys(state);
    }
    public void City(String city) {
        City.sendKeys(city);
    }
    public void Zipcode(String zipcode) {
        Zipcode.sendKeys(zipcode);
    }
    public void MobileNumber(String mobileNumber) {
        MobileNumber.sendKeys(mobileNumber);
    }
    public void SubmitButton() {
        SubmitButton.click();
    }
    public void AccountCreated() {
        AccountCreated.isDisplayed();
        System.out.println("Account Created Successfully");
    }



}
