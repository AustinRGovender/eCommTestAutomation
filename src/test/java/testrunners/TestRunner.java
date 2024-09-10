package testrunners;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        plugin = {
                "pretty",
                "json:target/cucumber-report.json",
                "html:target/cucumber-reports"
        },
        tags = "@ContactUs" // Change this to @Products or other tags as needed
)
public class TestRunner {
}
