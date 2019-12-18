package stepDefinition;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonDefinitions {
    DriverFactory driverFactory = new DriverFactory();
    @Given("Fest.md login page is displayed")
    public void loginPageIsDisplayed() {

        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.fest.md/ro/login-register");
    }

    @Given("Fest.md home page is displayed")
    public void HomePageIsDisplayed() {
        WebDriver driver = DriverFactory.newDriver();
        driver.manage().window().maximize();
        driver.get("https://www.fest.md");
    }

//    @Given("Fest.md/EN home page is displayed")
//    public void EnPageIsDisplayed() {
//        WebDriver driver = DriverFactory.newDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.fest.md/en");
//    }
}
