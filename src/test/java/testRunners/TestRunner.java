package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "stepDefinition",
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"},
        tags = {"@Fest"}
)
public class TestRunner {

}
