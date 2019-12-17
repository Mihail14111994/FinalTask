package stepImplementation;

import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import sun.jvm.hotspot.utilities.Assert;

import java.util.List;
import java.util.Random;

public class PlacesSteps {

    static DriverFactory driverFactory = new DriverFactory();
//    static WebDriver driver = driverFactory.newDriver();
    static WebDriver driver = DriverFactory.getDriver();
    static WebDriverWait wait = new WebDriverWait(driver,10);
    static SearchPage searchPage = new SearchPage();
    static PlacesPage placesPage = new PlacesPage();
    static PlacesElementPage placesElementPage = new PlacesElementPage();
    static OptionsPlacesPage optionsPage = new OptionsPlacesPage();
    static HomePage homePage = new HomePage();
    static String enHomePageURL = "https://www.fest.md/en/";
    static String categoryName;
    static String subcategoryName;

    public static void accessHomePage() {
        driver.get(enHomePageURL);
    }

    public  static void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public static void teardown(){
        driver.quit();
    }

    //    Scenario Outline: See details of a chosen place

    public static void accessPlacesPage() {
        wait.until(ExpectedConditions.visibilityOf(homePage.getPlacesMenu()));
        homePage.getPlacesMenu().click();
    }

    public static void checkUserIsOnPlacesPage(){
        Assert.that(placesPage.getPageTitle().isDisplayed(), "The Places page title is wrong");
    }

    public static void checkUserIsOnHomePage(){
        Assert.that(homePage.getBtnHome().isDisplayed(), "The Home page title is wrong");
    }

    public static void clickOnCategoryDropdown(String category){
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

    public static void clickOnCategory(String category){
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

    public static void userClicksOnSeeOnMapButton(){
        wait.until(ExpectedConditions.visibilityOf(placesPage.getBtnSeeOnMap()));
        List <WebElement> places = getAllThePlacesTypeFromCategory();
        System.out.println(places.size());
        Assert.that(places.size() != 0, "Nu exista locuri");
        placesPage.getBtnSeeOnMap().click();
    }

    public static void clickOnSubcategory(){

        List<WebElement> subcategories = null;
        if(categoryName.equals("Restaurants"))
            subcategories = placesPage.getDblRestaurants();
        if(categoryName.equalsIgnoreCase("Bars and cafes")) {
            subcategories = placesPage.getDblBarsAndCafes();
            System.out.println("bars and cafes is clicked");

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

    public static void checkPlaceBelongsToSubcategory(){
        wait.until(ExpectedConditions.elementToBeClickable(placesPage.getCategories().get(1)));
        List<WebElement> places = getAllThePlacesTypeFromCategory();

        if(places.size() > 0){
            wait.until(ExpectedConditions.visibilityOf(places.get(places.size()-1)));
            Assert.that(getRandomElement(places).getText().contains(subcategoryName.substring(0,subcategoryName.length()-3)), "The subcategory isn't in the type of the place");
        }
        if(places.size() == 0){
            Assert.that(true, "");
        }
    }

    public static void checkAllThePlacesPresentOnMap(){
        wait.until(ExpectedConditions.visibilityOf(placesPage.getMapFromPlacesPage()));
    }

    public static List<WebElement> getAllThePlacesTypeFromCategory(){
        return placesPage.getPlacesElementType();
    }

    public static void userClicksOnSearchButton(){
        wait.until(ExpectedConditions.visibilityOf(homePage.getTxtSearchbar()));
        homePage.getTxtSearchbar().click();
    }

    public static void userClicksOnOptionButton() {
        wait.until(ExpectedConditions.visibilityOf(placesPage.getBtnOptions()));
        placesPage.getBtnOptions().click();
    }

    public static void checkThemeValuesFromOptions(String theme){
        optionsPage.getDdlTheme().click();
        wait.until(ExpectedConditions.elementToBeClickable(optionsPage.getDblThemes().get(24)));
        for (WebElement element: optionsPage.getDblThemes()) {
            if (element.getText().contains(theme)){
                element.click();
                break;}
        }
        optionsPage.getDdlTheme().click();
    }

    public static void checkPriceValuesFromOptions(String price){
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
    }

    public static void checkFacilitiesValuesFromOptions(String facilities){
        for (WebElement element: optionsPage.getDblFacilities()) {
            if (facilities.contains(element.getText().substring(0, element.getText().length() - 1))){
                element.click();
                break;}
        }
    }

    public static void userClicksOnOptionsSearchButton() {
        optionsPage.getBtnOptionsSearch().click();
    }

    public static void selectAPlacesElement(){
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getBtnSuggestedEvent()));
        List<WebElement> places = placesElementPage.getBtnDetailsOfAPlacesElement();

        if(places.size() > 0){
            getRandomElement(places).click();
        }
        if(places.size() == 0){
            Assert.that(true, "");
        }
    }

    public static void checkPlacesElementDetailsCorrespondence(){
        wait.until(ExpectedConditions.elementToBeClickable(placesPage.getCategories().get(1)));
    }

    public static void userTypeTextInSearchbar(String inputText){
        wait.until(ExpectedConditions.visibilityOf(homePage.getTxtSearchbar()));
        homePage.getTxtSearchbar().sendKeys(inputText);
        homePage.getBtnSearch().click();
    }

    public static void checkTheResultOfSearch(String locationName){
        wait.until(ExpectedConditions.visibilityOf(searchPage.getTxaSearchFor()));
        Assert.that(searchPage.getTxaSearchFor().getText().contains(locationName), "Didn't get to results of search");
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
