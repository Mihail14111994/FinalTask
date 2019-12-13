package stepDefinition;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
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

    @Given("Fest.md page is displayed")
    public void HomePageIsDisplayed(String arg0) {

    }

    @Given("Fest.md/EN page is displayed")
    public void a(){

    }


}
