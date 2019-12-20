package stepDefinition;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class CommonDefinitions {

    @Given("Fest.md login page is displayed")
    public void loginPageIsDisplayed() {
    WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.fest.md/ro/login-register");
    }

    @Given("Fest.md home page is displayed")
    public void HomePageIsDisplayed() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.fest.md");
    }

    @Given("Fest.md english page is displayed")
    public void EnPageIsDisplayed() {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.fest.md/en");
    }


    public static WebElement getRandomElement(List<WebElement> list) {
        int size = list.size();
        if (size == 0) return null;
        Random randomInt = new Random();
        return list.get(randomInt.nextInt(size));
    }

    @After
    public void teardown(){
        DriverFactory.getDriver().close();
        DriverFactory.getDriver().quit();
        DriverFactory.setDriverNull();
    }

}
