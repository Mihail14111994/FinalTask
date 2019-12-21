package stepImplementation;

import driverFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static actionMethods.Click.click;
import static actionMethods.RandomLink.randomLink;
import static actionMethods.Screenshot.takeScreenshot;
import static actionMethods.Wait.waitFor;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlacesSteps {

    private SearchPage searchPage = new SearchPage();
    private PlacesPage placesPage = new PlacesPage();
    private PlacesElementPage placesElementPage = new PlacesElementPage();
    private MapPlacesPage mapPlacesPage = new MapPlacesPage();
    private OptionsPlacesPage optionsPage = new OptionsPlacesPage();
    private HomePage homePage = new HomePage();
    private String categoryName;
    private String subcategoryName;
    private String randomLegendElementText;
    private String path = "target\\screenshots\\places\\";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
    private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
    Actions actions = new Actions(DriverFactory.getDriver());

    //    Scenario Outline: See details of a chosen place

    public void accessPlacesPage() throws IOException {
        waitFor(homePage.getPlacesMenu());
        click(homePage.getPlacesMenu(), path);
    }

    public void checkUserIsOnPlacesPage() {
        assertThat("The Places page title is wrong", homePage.getPlacesMenu().isDisplayed());
    }

    public void checkUserIsOnHomePage() {
        assertThat("Home page not present", homePage.getPlacesMenu().isDisplayed());
    }

    public void clickOnCategoryDropdown(String category) throws IOException {
        waitFor(placesPage.getDdlCategories().get(1));
        categoryName = category;

        List<WebElement> categories = placesPage.getDdlCategories();
        for (WebElement element : categories) {
            String text = element.getText().substring(0, element.getText().length() - 1);
            category = category.replaceAll("[\\s|\\u00A0]", "");
            text = text.replaceAll("[\\s|\\u00A0]", "");
            if (text.equalsIgnoreCase(category)) {
                click(element, path);
                break;
            }
        }
    }

    public void clickOnCategory(String category) throws IOException {
        waitFor(placesPage.getCategories().get(1));
        categoryName = category;

        List<WebElement> categories = placesPage.getCategories();
        for (WebElement element : categories) {
            String text = element.getText();
            category = category.replaceAll("[\\s|\\u00A0]", "");
            text = text.replaceAll("[\\s|\\u00A0]", "");
            if (text.equalsIgnoreCase(category)) {
                click(element, path);
                break;
            }
        }
    }

    public void checkPresenceOfPlaces() {
        waitFor(placesPage.getAdBanner());
        List<WebElement> places = getAllThePlacesTypeFromCategory();
        assertThat("Nu exista locuri", places.size() != 0);
    }

    public void userClicksOnSeeOnMapButton() throws IOException {
        click(placesPage.getBtnSeeOnMap(), path);
    }

    public void clickOnSubcategory() throws IOException {
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
            WebElement subcategory = randomLink(subcategories);
            subcategoryName = subcategory.getText();
            click(subcategory, path);
        }
    }

    public void checkPlaceBelongsToSubcategory() {
        waitFor(placesPage.getCategories().get(1));
        List<WebElement> places = getAllThePlacesTypeFromCategory();

        if (places.size() > 0) {
            waitFor(places.get(places.size() - 1));
            assertThat("The subcategory isn't in the type of the place", randomLink(places).getText().contains(subcategoryName.substring(0, subcategoryName.length() - 3)));
        }
        if (places.size() == 0) {
            assertThat("No placesElement found", true);
        }
    }

    public void checkThePlacesPresentOnMap(String category) throws IOException {
        waitFor(mapPlacesPage.getChkMapCheckboxes().get(0));
        assertThat("The places are not on the map", mapPlacesPage.getChkMapCheckboxes().get(0).getText().equalsIgnoreCase(category));
        click(mapPlacesPage.getChkMapCheckboxes().get(0), path);
    }

    public List<WebElement> getAllThePlacesTypeFromCategory() {
        return placesElementPage.getPlacesElementType();
    }

    public void userClicksOnSearchButton() throws IOException {
        click(homePage.getTxtSearchbar(), path);
    }

    //    Scenario Outline: Places filtering

    public void userClicksOnOptionButton() throws IOException {
        click(placesPage.getBtnOptions(), path);
    }

    public void checkThemeValuesFromOptions(String theme) throws IOException {
        click(optionsPage.getDdlTheme(), path);
        for (WebElement element : optionsPage.getDblThemes()) {
            if (element.getText().contains(theme)) {
                click(element, path);
                break;
            }
        }
        click(optionsPage.getDdlTheme(), path);
    }

    public void checkPriceValuesFromOptions(String price) throws IOException {
        switch (price) {
            case "2":
                click(optionsPage.getChkPriceLevel2(), path);
                break;
            case "3":
                click(optionsPage.getChkPriceLevel3(), path);
                break;
            case "4":
                click(optionsPage.getChkPriceLevel4(), path);
                break;
            default:
        }
    }

    public void checkFacilitiesValuesFromOptions(String facilities) throws IOException {
        for (WebElement element : optionsPage.getDblFacilities()) {
            if (facilities.contains(element.getText().substring(0, element.getText().length() - 1))) {
                click(element, path);
                break;
            }
        }
    }

    public void userClicksOnOptionsSearchButton() throws IOException {
        click(optionsPage.getBtnOptionsSearch(), path);
    }

    public void selectAPlacesElement() throws IOException {
        waitFor(homePage.getBtnSuggestedEvent());
        List<WebElement> places = placesElementPage.getBtnDetailsOfAPlacesElement();

        if (places.size() > 0) {
            click(randomLink(places), path);

        }
        if (places.size() == 0) {
            assertThat("No placesElement found", true);
        }
    }

    public void checkPlacesElementDetailsCorrespondence(String theme, String price, String facility) throws IOException {
        waitFor(homePage.getBtnSuggestedEvent());
        assertThat("Facility corresponds", DriverFactory.getDriver().getPageSource().contains(facility));
        actions.moveToElement(placesElementPage.getTxtPlacePrice().get(0)).perform();
        takeScreenshot(DriverFactory.getDriver(),path + LocalDateTime.now().format(formatter) + ".jpg");
        assertThat("Theme corresponds", DriverFactory.getDriver().getPageSource().contains(theme));
        String classEl = placesElementPage.getTxtPlacePrice().get(0).getAttribute("class");
        assertThat("Price corresponds", classEl.contains(price));
    }

    public void userTypeTextInSearchbar(String inputText) throws IOException {
        waitFor(homePage.getTxtSearchbar());
        homePage.getTxtSearchbar().sendKeys(inputText);
        click(homePage.getBtnSearch(), path);
    }

    public void checkTheResultOfSearch(String locationName) throws IOException {
        waitFor(searchPage.getTxaSearchFor());
        assertThat("Didn't get to results of search", searchPage.getTxaSearchFor().getText().contains(locationName));

        List<WebElement> resultsOfSearch = placesElementPage.getBtnDetailsOfAPlacesElement();
        if (resultsOfSearch == null)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("No results have been found."))).isDisplayed();
        takeScreenshot(DriverFactory.getDriver(), path + LocalDateTime.now().format(formatter) + ".jpg");
    }

    public void checkARandomCheckboxFromMapLegend() throws IOException {
        waitFor(mapPlacesPage.getChkMapCheckboxes().get(0));
        List<WebElement> places = mapPlacesPage.getChkMapCheckboxes();
        // uncheck the first 3 checkboxes(checked by default)
        click(places.get(0), path);
        click(places.get(1), path);
        click(places.get(2), path);

        WebElement randomLegendElement = randomLink(places);
        randomLegendElementText = randomLegendElement.getText();
        click(randomLegendElement, path);
        click(mapPlacesPage.getBtnMapCloseLegend(), path);
    }

    public void userCanSeeThePlacesOnTheMap() throws IOException {
        List<WebElement> pinpoints = mapPlacesPage.getMapPinpoints();
        for (WebElement pinpoint : pinpoints) {
            if (pinpoint.isDisplayed()) {
                    actions.moveToElement(pinpoint).moveByOffset(60, 0).perform();
                takeScreenshot(DriverFactory.getDriver(), path + LocalDateTime.now().format(formatter) + ".jpg");
                try {
                    actions.moveToElement(pinpoint).moveByOffset(60, 0).click().perform();
                    break;
                } catch (ElementClickInterceptedException e) {
                    e.getLocalizedMessage();
                }
            }
        }
        waitFor(placesPage.getPageTitle());
        assertThat("Chosen place is not displayed (from map)", DriverFactory.getDriver().getPageSource().contains(randomLegendElementText));
        takeScreenshot(DriverFactory.getDriver(), path + LocalDateTime.now().format(formatter) + ".jpg");
    }
}
