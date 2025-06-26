package AutomationExercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowseDriver {
    public static WebDriver driver;

    public BrowseDriver() {
        this.driver = driver;
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/driver.edgedriver_win64/msedgedriver.exe");
        this.driver.manage().window().maximize();
        this.driver =new ChromeDriver();
    }
    public void close(){
        this.driver.quit();
    }
}
