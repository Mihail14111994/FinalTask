package stepDefinition;

import driverFactory.DriverFactory;
import gherkin.ast.Feature;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import stepImplementation.CommonSteps;


public class CommonDefinitions {
    private final static Logger logger = Logger.getLogger(CommonDefinitions.class);
    CommonSteps commonSteps = new CommonSteps();

    @Given("Fest.md login page is displayed")
    public void loginPageIsDisplayed() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.fest.md/ro/login-register");
    }

    @Given("Fest.md home page is displayed")
    public void HomePageIsDisplayed() {
        WebDriver driver = DriverFactory.getDriver();
        logger.info("Initializing driver...");
        driver.manage().window().maximize();
        driver.get("https://www.fest.md");
    }

    @Given("Fest.md english page is displayed")
    public void EnPageIsDisplayed() {
        WebDriver driver = DriverFactory.getDriver();
        logger.info("Initializing driver...");
        driver.manage().window().maximize();
        driver.get("https://www.fest.md/en");
    }

    @After
    public void teardown() {
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
