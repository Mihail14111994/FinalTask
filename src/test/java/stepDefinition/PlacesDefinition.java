package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepImplementation.PlacesSteps;

public class PlacesDefinition {


    @Before
    public void beforeTests(){
        PlacesSteps.accessHomePage();
        PlacesSteps.maximizeWindow();
    }

    @After
    public void quitDriver(){
        PlacesSteps.teardown();
    }

    @Given("Use is on Places page")
    public void useIsOnPlacesPage() {
        PlacesSteps.accessPlacesPage();
        PlacesSteps.checkUserIsOnPlacesPage();
    }

    @When("User clicks on {} dropdown")
    public void userClicksOnCategoryDropdown(String category) {
        PlacesSteps.clickOnCategoryDropdown(category);
    }

    @And("User clicks on subcategory")
    public void userClicksOnSubcategory() {
        PlacesSteps.clickOnSubcategory();
    }

    @Then("User is able to see the places that belong to subcategories")
    public void userIsAbleToSeeThePlacesThatBelongToSubcategories() {
        PlacesSteps.checkPlaceBelongsToSubcategory();
    }
//
//    @Then("User is able to see details, contact information")
//    public void userIsAbleToSeeDetailsContactInformationAndFacilitiesOfThatPlaceSelected() {
//    }
//
//    @Given("User is on Places page")
//    public void userIsOnPlacesPage() {
//    }
//
//    @When("User clicks on {string} category")
//    public void userClicksOnCategory(String arg0) {
//    }
//
//    @And("User clicks on {string} button")
//    public void userClicksOnButton(String arg0) {
//    }
//
//    @Then("User is able to see all the {string} places on the map")
//    public void userIsAbleToSeeAllThePlacesOnTheMap(String arg0) {
//    }
//
//    @When("User clicks on {string}See on map\" button")
//    public void userClicksOnSeeOnMapButton(String arg0) throws Throwable {    // Write code here that turns the phrase above into concrete actions    throw new cucumber.api.PendingException();}
//}
//
//    @And("User checks <category> to be pointed on the map")
//    public void userChecksCategoryToBePointedOnTheMap() {
//    }
//
//    @Then("User is able to see <category> places on the map")
//    public void userIsAbleToSeeCategoryPlacesOnTheMap() {
//    }
//
//    @And("User is able to click on a <category> place")
//    public void userIsAbleToClickOnACategoryPlace() {
//    }
//
//    @And("User is able to see details of the <category>")
//    public void userIsAbleToSeeDetailsOfTheCategory() {
//
//    }

}
