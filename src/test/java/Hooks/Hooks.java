package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {


    public static WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Hook is running!");
        if (driver == null) {
            driver = new ChromeDriver();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}
