package stepDefinition;

import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlacesPage{
    DriverFactory driverFactory=new DriverFactory();
    WebDriver driver = driverFactory.newDriver();
    WebDriverWait wait = new WebDriverWait(driver, 2);

    @Given("Use is on Places page")
    public void useIsOnPlacesPage() {
        driver.get("https://www.fest.md/en/places");
    }

    @When("User clicks on {} dropdown")
    public void userClicksOnBarsAndCafesDropdown() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[3]/div[3]/a/div/div"))).click();
    }

    @And("User clicks on {}")
    public void userClicksOnTeahouses() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div[3]/div[3]/ul/li[9]/a"))).click();
    }

    @And("User clicks on one of the {} on the page")
    public void userClicksOnOneOfTheTeahousesName() {
    }

    @Then("User is able to see details, contact information and facilities of that {}")
    public void userIsAbleToSeeDetailsContactInformationAndFacilitiesOfThatPlace() {
    }

    @Given("User is on Places page")
    public void userIsOnPlacesPage() {
    }

    @When("User clicks on {} category")
    public void userClicksOnCinemaCategory() {
    }

    //*[@id="content"]/div[6]/div[1]/div/div[2]/div/div[2]/div/div[1]/a
    //*[@id="content"]/div[6]/div[1]/div/div[2]/div/div[2]/div/div[1]/a

    @And("User clicks on {} button")
    public void userClicksOnSeeOnMapButton() {
    }

    @Then("User is able to see all the {} places on the map")
    public void userIsAbleToSeeAllTheCinemaPlacesOnTheMap() {
    }
//
//    @And("User checks Karting Places to be pointed on the map")
//    public void userChecksKartingPlacesToBePointedOnTheMap() {
//    }
//
//    @Then("User is able to se Karting places on the map")
//    public void userIsAbleToSeKartingPlacesOnTheMap() {
//    }
//
//    @And("User is able to click on a Karting place")
//    public void userIsAbleToClickOnAKartingPlace() {
//    }
//
//    @And("User is able to see details of the place")
//    public void userIsAbleToSeeDetailsOfThePlace() {
//    }
//
//    @And("User clicks Options button")
//    public void userClicksOptionsButton() {
//    }
//
//    @And("User checks values for <theme>, <priceLevel> and for <facilities>")
//    public void userChecksValuesForThemePriceLevelAndForFacilities() {
//    }
//
//    @And("User clicks Search button")
//    public void userClicksSearchButton() {
//    }
//
//    @Then("User is able to see a list of places corresponding filtering")
//    public void userIsAbleToSeeAListOfPlacesCorrespondingFiltering() {
//    }
}
