package testRunners;

import cucumber.api.CucumberOptions;
import driverFactory.DriverFactory;

@CucumberOptions(features="src/test/features", glue="src/test/stepDefinition")
  class TestRunner_FestPlaces extends DriverFactory {


}
