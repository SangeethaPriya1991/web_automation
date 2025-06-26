package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinitions", "Hooks"}, 
        plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json"},
        monochrome = true,
      //  tags = "@LoginFunctionality",
        publish = true)

public class TestRunner {


}
