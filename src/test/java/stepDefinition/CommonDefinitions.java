package stepDefinition;

import driverFactory.DriverFactory;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import stepImplementation.CommonSteps;

import java.io.FileNotFoundException;


public class CommonDefinitions {
    private final static Logger logger = Logger.getLogger(CommonDefinitions.class);
    CommonSteps commonSteps = new CommonSteps();

    @Given("The {} page is displayed")
    public void festPageIsDisplayed(String url) throws FileNotFoundException {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void teardown() throws FileNotFoundException {
        DriverFactory.getDriver().close();
        DriverFactory.getDriver().quit();
        DriverFactory.setDriverNull();
        logger.info("Driver is closed");
    }

    @Before
    public void beforeTest (Scenario scenario){
        commonSteps.beforeScenario(scenario);
    }
}
