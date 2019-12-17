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
    public void beforeTests() {
        PlacesSteps.accessHomePage();
        PlacesSteps.maximizeWindow();
    }

    @After
    public void quitDriver() {
        PlacesSteps.teardown();
    }

    //    Scenario Outline: See details of a chosen place
    @Given("User is on Places page")
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

    //  Scenario Outline: See a category of places on the map
    @When("User clicks on {} category")
    public void userClicksOnCategory(String category) {
        PlacesSteps.clickOnCategory(category);
    }

    @And("User clicks on See on map button")
    public void userClicksOnSeeOnMapButton() {
        PlacesSteps.userClicksOnSeeOnMapButton();
    }

    @Then("User is able to see all the places on the map")
    public void userIsAbleToSeeAllThePlacesOnTheMap() {
        PlacesSteps.checkAllThePlacesPresentOnMap();
    }

    //  Scenario: Check Search-bar
    @Given("User is on Home page")
    public void useIsOnHomePage() {
        PlacesSteps.checkUserIsOnHomePage();
    }
    @And("User type a potential {} location name in Searchbar")
    public void userClicksSearchButtonAndTipeText(String inputText) {
        PlacesSteps.userClicksOnSearchButton();
        PlacesSteps.userTypeTextInSearchbar(inputText);
    }

    @Then("User see the results matching his {} request")
    public void userSeeTheResultsMatchingHisRequest(String locationName) {
        PlacesSteps.checkTheResultOfSearch(locationName);
    }

    //  Scenario Outline: Places filtering
    @And("User clicks Options button")
    public void userClicksOptionButton() {
        PlacesSteps.userClicksOnOptionButton();
    }

    @Then("User choose values for {}, {} and for {}")
    public void userChooseValuesForThemePriceAndForFacilities(String theme, String price, String facilities) {
        PlacesSteps.checkThemeValuesFromOptions(theme);
        PlacesSteps.checkPriceValuesFromOptions(price);
        PlacesSteps.checkFacilitiesValuesFromOptions(facilities);
        PlacesSteps.userClicksOnOptionsSearchButton();
    }

    @Then("User is able to see a list of places corresponding to filters")
    public void userIsAbleToSeeAListOfPlacesCorrespondingToFilters() {
        PlacesSteps.selectAPlacesElement();
        PlacesSteps.checkPlacesElementDetailsCorrespondence();
    }
}
