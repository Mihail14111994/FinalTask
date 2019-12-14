package stepImplementation;

import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.HomePage;
import pageObjects.PlacesPage;

import java.util.List;
import java.util.Random;

public class PlacesSteps {

    static DriverFactory driverFactory = new DriverFactory();
    static WebDriver driver = driverFactory.newDriver();
    static WebDriverWait wait = new WebDriverWait(driver,10);
    static PlacesPage placesPage = new PlacesPage();
    static HomePage homePage = new HomePage();
    static String enHomePageURL = "https://www.fest.md/en/";
    static String categoryName;
    static String subcategoryName;

    public static void accessHomePage(){
        driver.get(enHomePageURL);
    }

    public  static void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public static void teardown(){
        driver.quit();
    }

    public static void accessPlacesPage(){
        wait.until(ExpectedConditions.visibilityOf(homePage.getPlacesMenu()));
        homePage.getPlacesMenu().click();
    }

    public static void checkUserIsOnPlacesPage(){
         Assert.assertTrue(placesPage.getPageTitle().isDisplayed());
    }

    public static void clickOnCategoryDropdown(String category){
        wait.until(ExpectedConditions.elementToBeClickable(placesPage.getDblCategories().get(1)));
        categoryName = category;

        List<WebElement> categories = placesPage.getDblCategories();
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
        List<WebElement> places = placesPage.getPlacesElements();

        if(places.size() > 0){
            wait.until(ExpectedConditions.visibilityOf(places.get(places.size()-1)));
            Assert.assertTrue(getRandomElement(places).getText().contains(subcategoryName.substring(0,subcategoryName.length()-1)));
        }
        if(places.size() == 0){
            Assert.assertTrue(true);
        }
    }

    public static WebElement getRandomElement(List<WebElement> list){
        int size = list.size();
        if(size == 0) return null;
        Random randomInt = new Random();
        return list.get(randomInt.nextInt(size));

    }

}
