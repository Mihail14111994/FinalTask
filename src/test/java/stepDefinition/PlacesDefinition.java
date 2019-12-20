package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepImplementation.PlacesSteps;

public class PlacesDefinition  {

    PlacesSteps placesSteps = new PlacesSteps();

    //    Scenario Outline: See details of a chosen place

    @Given("User is on Places page")
    public void useIsOnPlacesPage() {
        placesSteps.accessPlacesPage();
        placesSteps.checkUserIsOnPlacesPage();
    }

    @When("User clicks on {} dropdown")
    public void userClicksOnCategoryDropdown(String category) {
        placesSteps.clickOnCategoryDropdown(category);
    }

    @And("User clicks on subcategory")
    public void userClicksOnSubcategory() {
        placesSteps.clickOnSubcategory();
    }

    @Then("User is able to see the places that belong to subcategories")
    public void userIsAbleToSeeThePlacesThatBelongToSubcategories() {
        placesSteps.checkPlaceBelongsToSubcategory();
    }

    //  Scenario Outline: See a category of places on the map
    @When("User clicks on {} category")
    public void userClicksOnCategory(String category) {
        placesSteps.clickOnCategory(category);
        placesSteps.checkPresenceOfPlaces();
    }

    @And("User clicks on See on map button")
    public void userClicksOnSeeOnMapButton() {
        placesSteps.userClicksOnSeeOnMapButton();
    }

    @Then("User is able to see the places off the chosen {} places on the map")
    public void userIsAbleToSeeThePlacesOnTheMap(String category) {
        placesSteps.checkThePlacesPresentOnMap(category);
    }

    //  Scenario: Check Search-bar
    @Given("User is on Home page")
    public void useIsOnHomePage() {
        placesSteps.checkUserIsOnHomePage();
    }
    @And("User type a potential {} location name in Searchbar")
    public void userClicksSearchButtonAndTipeText(String inputText) {
        placesSteps.userClicksOnSearchButton();
        placesSteps.userTypeTextInSearchbar(inputText);
    }

    @Then("User see the results matching his {} request")
    public void userSeeTheResultsMatchingHisRequest(String locationName) {
        placesSteps.checkTheResultOfSearch(locationName);
    }

    //  Scenario Outline: Places filtering
    @And("User clicks Options button")
    public void userClicksOptionButton() {
        placesSteps.userClicksOnOptionButton();
    }

    @Then("User choose values for {}, {} and for {}")
    public void userChooseValuesForThemePriceAndForFacilities(String theme, String price, String facilities) {
        placesSteps.checkThemeValuesFromOptions(theme);
        placesSteps.checkPriceValuesFromOptions(price);
        placesSteps.checkFacilitiesValuesFromOptions(facilities);
        placesSteps.userClicksOnOptionsSearchButton();
    }

    @Then("User is able to see a list of places corresponding to filters {}, {}, {}")
    public void userIsAbleToSeeAListOfPlacesCorrespondingToFilters(String theme, String price, String facility) {
        placesSteps.selectAPlacesElement();
        placesSteps.checkPlacesElementDetailsCorrespondence(theme, price, facility);
    }

    @And("Check any Places Category from the checkboxes list")
    public void checkAnyPlacesCategoryFromTheCheckboxesList() {
        placesSteps.checkARandomCheckboxFromMapLegend();
    }

    @Then("User can see the places of the chosen category on the Map")
    public void userCanSeeThePlacesOfTheChosenCategoryOnTheMap() {

    }

}
