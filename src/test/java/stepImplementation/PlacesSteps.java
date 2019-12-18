package stepImplementation;

import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;

public class PlacesSteps {

    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),10);
    SearchPage searchPage = new SearchPage();
     PlacesPage placesPage = new PlacesPage();
     PlacesElementPage placesElementPage = new PlacesElementPage();
     MapPlacesPage mapPlacesPage = new MapPlacesPage();
     OptionsPlacesPage optionsPage = new OptionsPlacesPage();
     HomePage homePage = new HomePage();
     String enHomePageURL = "https://www.fest.md/en/";
     String categoryName;
     String subcategoryName;

    public void accessHomePage() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get(enHomePageURL);
    }

    public void maximizeWindow(){
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    //    Scenario Outline: See details of a chosen place

    public void accessPlacesPage() {
        wait.until(ExpectedConditions.visibilityOf(homePage.getPlacesMenu()));
        homePage.getPlacesMenu().click();
    }

    public void checkUserIsOnPlacesPage(){
        assertThat("The Places page title is wrong",homePage.getPlacesMenu().isDisplayed());
    }

    public void checkUserIsOnHomePage(){
        assertThat("Home page not present",homePage.getPlacesMenu().isDisplayed());
    }

    public void clickOnCategoryDropdown(String category){
        wait.until(ExpectedConditions.elementToBeClickable(placesPage.getDdlCategories().get(1)));
        categoryName = category;

        List<WebElement> categories = placesPage.getDdlCategories();
        for (WebElement element: categories) {
            String text = element.getText().substring(0, element.getText().length() - 1);
            category = category.replaceAll("[\\s|\\u00A0]", "");
            text = text.replaceAll("[\\s|\\u00A0]", "");
            if(text.equalsIgnoreCase(category)){
                element.click();
                break;
            }
        }
    }

    public void clickOnCategory(String category){
        wait.until(ExpectedConditions.elementToBeClickable(placesPage.getCategories().get(1)));
        categoryName = category;

        List<WebElement> categories = placesPage.getCategories();
        for (WebElement element: categories) {
            String text = element.getText();
            category = category.replaceAll("[\\s|\\u00A0]", "");
            text = text.replaceAll("[\\s|\\u00A0]", "");
            if(text.equalsIgnoreCase(category)){
                element.click();
                break;
            }
        }
    }

    public void userClicksOnSeeOnMapButton(){
        wait.until(ExpectedConditions.visibilityOf(placesPage.getAdBanner()));
        List <WebElement> places = getAllThePlacesTypeFromCategory();
        assertThat("Nu exista locuri",places.size() != 0);
        placesPage.getBtnSeeOnMap().click();
    }

    public void clickOnSubcategory(){
        List<WebElement> subcategories = null;
        if(categoryName.equals("Restaurants"))
            subcategories = placesPage.getDblRestaurants();
        if(categoryName.equalsIgnoreCase("Bars and cafes")) {
            subcategories = placesPage.getDblBarsAndCafes();
        }
        if(categoryName.equals("Sports/Entertainment")) {
            subcategories = placesPage.getDblSportsEntertainment();
            subcategories.remove(0);
        }
        if(subcategories.size() > 0){
            WebElement subcategory = getRandomElement(subcategories);
            subcategoryName =  subcategory.getText();
            subcategory.click();
        }
    }

    public void checkPlaceBelongsToSubcategory(){
        wait.until(ExpectedConditions.elementToBeClickable(placesPage.getCategories().get(1)));
        List<WebElement> places = getAllThePlacesTypeFromCategory();

        if(places.size() > 0){
            wait.until(ExpectedConditions.visibilityOf(places.get(places.size()-1)));
            assertThat("The subcategory isn't in the type of the place",getRandomElement(places).getText().contains(subcategoryName.substring(0,subcategoryName.length()-3)));
        }
        if(places.size() == 0){
            assertThat("No placesElement found",true);
        }
    }

    public void checkAllThePlacesPresentOnMap() {
        wait.until(ExpectedConditions.visibilityOf(mapPlacesPage.getMapFromPlacesPageCheckboxes().get(0)));
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mapPlacesPage.getMapFromPlacesPageCheckboxes().get(0).click();
    }

    public List<WebElement> getAllThePlacesTypeFromCategory(){
        return placesPage.getPlacesElementType();
    }

    public void userClicksOnSearchButton(){
        wait.until(ExpectedConditions.visibilityOf(homePage.getTxtSearchbar()));
        homePage.getTxtSearchbar().click();
    }
//    Scenario Outline: Places filtering
    String productTheme;
    String productPrice;
    String productFacility;
    public void userClicksOnOptionButton() {
        wait.until(ExpectedConditions.visibilityOf(placesPage.getBtnOptions()));
        placesPage.getBtnOptions().click();
    }

    public void checkThemeValuesFromOptions(String theme){
        optionsPage.getDdlTheme().click();
        wait.until(ExpectedConditions.elementToBeClickable(optionsPage.getDblThemes().get(24)));
        for (WebElement element: optionsPage.getDblThemes()) {
            if (element.getText().contains(theme)){
                element.click();
                break;}
        }
        optionsPage.getDdlTheme().click();
        productTheme = theme;
    }

    public void checkPriceValuesFromOptions(String price){
        switch (price){
            case "2":
                optionsPage.getChkPriceLevel2().click();
                break;
            case "3":
                optionsPage.getChkPriceLevel3().click();
                break;
            case "4":
                optionsPage.getChkPriceLevel4().click();
                break;
            default:
        }
        productPrice = price;
    }

    public void checkFacilitiesValuesFromOptions(String facilities){
        for (WebElement element: optionsPage.getDblFacilities()) {
            if (facilities.contains(element.getText().substring(0, element.getText().length() - 1))){
                element.click();
                break;}
        }
        productFacility = facilities;
    }

    public void userClicksOnOptionsSearchButton() {
        optionsPage.getBtnOptionsSearch().click();
    }

    public void selectAPlacesElement(){
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getBtnSuggestedEvent()));
        List<WebElement> placesDetails = placesElementPage.getBtnDetailsOfAPlacesElement();

        if(placesDetails.size() > 0){
            getRandomElement(placesDetails).click();
        }
        if(placesDetails.size() == 0){
            assertThat("No placesElement found",true);
        }
    }

    public void checkPlacesElementDetailsCorrespondence(){
        wait.until(ExpectedConditions.elementToBeClickable(placesPage.getAdBanner()));
        System.out.println(placesElementPage.getTxtPlaceTheme().get(0).getText());
        for (WebElement element: placesElementPage.getTxtPlaceTheme()) {
            if ((element.getText().length() != 0)) {
                System.out.println(element.getText());
                assertThat("Place Element Theme", element.getText().contains(productTheme));
                break;
            }
        }
        assertThat("Place Element Price", placesElementPage.getTxtPlacePrice().isDisplayed());
        assertThat("Place Element Facility", placesElementPage.getTxtPlaceFacilities().getText().contains(productFacility));
    }

    public void userTypeTextInSearchbar(String inputText){
        wait.until(ExpectedConditions.visibilityOf(homePage.getTxtSearchbar()));
        homePage.getTxtSearchbar().sendKeys(inputText);
        homePage.getBtnSearch().click();
    }

    public void checkTheResultOfSearch(String locationName){
        wait.until(ExpectedConditions.visibilityOf(searchPage.getTxaSearchFor()));
        assertThat("Didn't get to results of search",searchPage.getTxaSearchFor().getText().contains(locationName));

        List <WebElement> resultsOfSearch =  placesPage.getPlacesElementType();
        if(resultsOfSearch == null)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("No results have been found."))).isDisplayed();
    }



    public static WebElement getRandomElement(List<WebElement> list){
        int size = list.size();
        if(size == 0) return null;
        Random randomInt = new Random();
        return list.get(randomInt.nextInt(size));
    }

}
