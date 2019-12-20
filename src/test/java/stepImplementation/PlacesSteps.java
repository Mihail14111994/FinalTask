package stepImplementation;

import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.List;
import static actionMethods.Click.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static stepDefinition.CommonDefinitions.getRandomElement;

public class PlacesSteps {

    static WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 20);

    SearchPage searchPage = new SearchPage();
    PlacesPage placesPage = new PlacesPage();
    PlacesElementPage placesElementPage = new PlacesElementPage();
    MapPlacesPage mapPlacesPage = new MapPlacesPage();
    OptionsPlacesPage optionsPage = new OptionsPlacesPage();
    HomePage homePage = new HomePage();
    String categoryName;
    String subcategoryName;
    String randomLegendElementText;


    //    Scenario Outline: See details of a chosen place

    public void accessPlacesPage() {
        wait.until(ExpectedConditions.visibilityOf(homePage.getPlacesMenu()));
        click(homePage.getPlacesMenu());
    }

    public void checkUserIsOnPlacesPage() {
        assertThat("The Places page title is wrong", homePage.getPlacesMenu().isDisplayed());
    }

    public void checkUserIsOnHomePage() {
        assertThat("Home page not present", homePage.getPlacesMenu().isDisplayed());
    }

    public void clickOnCategoryDropdown(String category) {
        wait.until(ExpectedConditions.elementToBeClickable(placesPage.getDdlCategories().get(1)));
        categoryName = category;

        List<WebElement> categories = placesPage.getDdlCategories();
        for (WebElement element : categories) {
            String text = element.getText().substring(0, element.getText().length() - 1);
            category = category.replaceAll("[\\s|\\u00A0]", "");
            text = text.replaceAll("[\\s|\\u00A0]", "");
            if (text.equalsIgnoreCase(category)) {
                click(element);
                break;
            }
        }
    }

    public void clickOnCategory(String category) {
        wait.until(ExpectedConditions.elementToBeClickable(placesPage.getCategories().get(1)));
        categoryName = category;

        List<WebElement> categories = placesPage.getCategories();
        for (WebElement element : categories) {
            String text = element.getText();
            category = category.replaceAll("[\\s|\\u00A0]", "");
            text = text.replaceAll("[\\s|\\u00A0]", "");
            if (text.equalsIgnoreCase(category)) {
                click(element);
                break;
            }
        }
    }

    public void checkPresenceOfPlaces() {
        wait.until(ExpectedConditions.visibilityOf(placesPage.getAdBanner()));
        List<WebElement> places = getAllThePlacesTypeFromCategory();
        assertThat("Nu exista locuri", places.size() != 0);
    }

    public void userClicksOnSeeOnMapButton() {
        click(placesPage.getBtnSeeOnMap());
    }

    public void clickOnSubcategory() {
        List<WebElement> subcategories = null;
        if (categoryName.equals("Restaurants"))
            subcategories = placesPage.getDblRestaurants();
        if (categoryName.equalsIgnoreCase("Bars and cafes")) {
            subcategories = placesPage.getDblBarsAndCafes();
        }
        if (categoryName.equals("Sports/Entertainment")) {
            subcategories = placesPage.getDblSportsEntertainment();
            subcategories.remove(0);
        }
        if (subcategories.size() > 0) {
            WebElement subcategory = getRandomElement(subcategories);
            subcategoryName = subcategory.getText();
            click(subcategory);
        }
    }

    public void checkPlaceBelongsToSubcategory() {
        wait.until(ExpectedConditions.elementToBeClickable(placesPage.getCategories().get(1)));
        List<WebElement> places = getAllThePlacesTypeFromCategory();

        if (places.size() > 0) {
//            waitPageFullyLoaded();
            wait.until(ExpectedConditions.visibilityOf(places.get(places.size() - 1)));
            assertThat("The subcategory isn't in the type of the place", getRandomElement(places).getText().contains(subcategoryName.substring(0, subcategoryName.length() - 3)));
        }
        if (places.size() == 0) {
            assertThat("No placesElement found", true);
        }
    }

    public void checkThePlacesPresentOnMap(String category) {
        wait.until(ExpectedConditions.visibilityOf(mapPlacesPage.getChkMapCheckboxes().get(0)));
        assertThat("The places are not on the map", mapPlacesPage.getChkMapCheckboxes().get(0).getText().equalsIgnoreCase(category));
    }

    public List<WebElement> getAllThePlacesTypeFromCategory() {
        return placesElementPage.getPlacesElementType();
    }

    public void userClicksOnSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(homePage.getTxtSearchbar()));
        click(homePage.getTxtSearchbar());
    }

    //    Scenario Outline: Places filtering

    public void userClicksOnOptionButton() {
        wait.until(ExpectedConditions.visibilityOf(placesPage.getBtnOptions()));
        click(placesPage.getBtnOptions());
    }

    public void checkThemeValuesFromOptions(String theme) {
        click(optionsPage.getDdlTheme());
        wait.until(ExpectedConditions.elementToBeClickable(optionsPage.getDblThemes().get(24)));
        for (WebElement element : optionsPage.getDblThemes()) {
            if (element.getText().contains(theme)) {
                click(element);
                break;
            }
        }
        click(optionsPage.getDdlTheme());
    }

    public void checkPriceValuesFromOptions(String price) {
        switch (price) {
            case "2":
                click(optionsPage.getChkPriceLevel2());
                break;
            case "3":
                click(optionsPage.getChkPriceLevel3());
                break;
            case "4":
                click(optionsPage.getChkPriceLevel4());
                break;
            default:
        }
    }

    public void checkFacilitiesValuesFromOptions(String facilities) {
        for (WebElement element : optionsPage.getDblFacilities()) {
            if (facilities.contains(element.getText().substring(0, element.getText().length() - 1))) {
                click(element);
                break;
            }
        }
    }

    public void userClicksOnOptionsSearchButton() {click(optionsPage.getBtnOptionsSearch());
    }

    public void selectAPlacesElement() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getBtnSuggestedEvent()));
        List<WebElement> places = placesElementPage.getBtnDetailsOfAPlacesElement();

        if (places.size() > 0) {
            click(getRandomElement(places));

        }
        if (places.size() == 0) {
            assertThat("No placesElement found", true);
        }
    }

    public void checkPlacesElementDetailsCorrespondence(String theme, String price, String facility) {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getBtnSuggestedEvent()));
        assertThat("Facility corresponds", DriverFactory.getDriver().getPageSource().contains(facility));
        assertThat("Theme corresponds", DriverFactory.getDriver().getPageSource().contains(theme));
        String classEl = placesElementPage.getTxtPlacePrice().get(0).getAttribute("class");
        assertThat("Price corresponds", classEl.contains(price));
    }

    public void userTypeTextInSearchbar(String inputText) {
        wait.until(ExpectedConditions.visibilityOf(homePage.getTxtSearchbar()));
        homePage.getTxtSearchbar().sendKeys(inputText);
        click(homePage.getBtnSearch());
    }

    public void checkTheResultOfSearch(String locationName) {
        wait.until(ExpectedConditions.visibilityOf(searchPage.getTxaSearchFor()));
        assertThat("Didn't get to results of search", searchPage.getTxaSearchFor().getText().contains(locationName));

        List<WebElement> resultsOfSearch = placesElementPage.getBtnDetailsOfAPlacesElement();
        if (resultsOfSearch == null)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("No results have been found."))).isDisplayed();
    }

    public void checkARandomCheckboxFromMapLegend() {
        wait.until(ExpectedConditions.visibilityOf(mapPlacesPage.getChkMapCheckboxes().get(0)));
        List<WebElement> places = mapPlacesPage.getChkMapCheckboxes();
        // uncheck the first 3 checkboxes(checked by default)
        click(places.get(0));
        click(places.get(1));
        click(places.get(2));

        WebElement randomLegendElement = getRandomElement(places);
        randomLegendElementText = randomLegendElement.getText();
        click(randomLegendElement);
        click(mapPlacesPage.getBtnMapCloseLegend());

        List<WebElement> pinpoints = mapPlacesPage.getMapPinpoints();
        for (WebElement pinpoint : pinpoints) {
            if (pinpoint.isDisplayed()) {
                Actions actions = new Actions(DriverFactory.getDriver());
                actions.moveToElement(pinpoint).perform();
                actions.moveToElement(pinpoint, 60, 0).perform();
                try {
                    click(pinpoint);
                    break;
                } catch (ElementClickInterceptedException e) {
                    e.getLocalizedMessage();
                }
            }
            wait.until(ExpectedConditions.elementToBeClickable(homePage.getBtnSuggestedEvent()));
            assertThat("Facility corresponds", DriverFactory.getDriver().getPageSource().contains(randomLegendElementText));
        }
    }
}
