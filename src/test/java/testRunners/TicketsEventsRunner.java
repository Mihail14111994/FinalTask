package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/EventsNavigation.feature",
        glue = "stepDefinition",
        plugin = {"pretty"}
//        tags = "@Doina"
)
public class TicketsEventsRunner {
}
