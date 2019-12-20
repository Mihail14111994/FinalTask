package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/Registration.feature",
        glue = "stepDefinition",
        plugin = {"pretty", "html:target/cucumber-html-report-registration", "json:target/cucumber.json-registration"}
//        tags = "@Valik"
)
public class RegistrationRunner {
}
