package stepDefinition;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;



public class CommonDefinitions {
    final static Logger logger = Logger.getLogger(CommonDefinitions.class);

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
    public void teardown(){
        DriverFactory.getDriver().close();
        DriverFactory.getDriver().quit();
        DriverFactory.setDriverNull();
    }

}
