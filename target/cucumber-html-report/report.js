$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/Places.feature");
formatter.feature({
  "name": "\u0027Places\u0027 page",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Fest.md english page is displayed",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonDefinitions.EnPageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Select Places from the  Map",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@places"
    },
    {
      "name": "@placesMap"
    },
    {
      "name": "@map"
    }
  ]
});
formatter.step({
  "name": "User is on Places page",
  "keyword": "Given "
});
formatter.match({
  "location": "PlacesDefinition.useIsOnPlacesPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User clicks on See on map button",
  "keyword": "And "
});
formatter.match({
  "location": "PlacesDefinition.userClicksOnSeeOnMapButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check any Places Category from the checkboxes list",
  "keyword": "And "
});
formatter.match({
  "location": "PlacesDefinition.checkAnyPlacesCategoryFromTheCheckboxesList()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User can see the places of the chosen category on the Map",
  "keyword": "Then "
});
formatter.match({
  "location": "PlacesDefinition.userCanSeeThePlacesOfTheChosenCategoryOnTheMap()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Facility corresponds\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:26)\n\tat stepImplementation.PlacesSteps.userCanSeeThePlacesOnTheMap(PlacesSteps.java:256)\n\tat stepDefinition.PlacesDefinition.userCanSeeThePlacesOfTheChosenCategoryOnTheMap(PlacesDefinition.java:99)\n\tat ✽.User can see the places of the chosen category on the Map(file:src/test/features/Places.feature:60)\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});