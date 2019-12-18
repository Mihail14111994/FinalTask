package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlacesPage  extends  PageObject{

    @FindBy(xpath = "//h1[@class = 'page-title bordered']")
    WebElement pageTitle;

    @FindBy(xpath = "//*[@class = 'btn btn-primary toggle-map']")
    WebElement btnSeeOnMap;

    @FindBy(xpath = "//*[@class = 'btn btn-secondary toggle-places-filter']")
    WebElement btnOptions;

    @FindBy(xpath="//*[@class='dropdown-toggle']//h2")
    List<WebElement> ddlCategories;

    @FindBy(xpath="//*[@class = 'tab']")
    List<WebElement> Categories;

    @FindBy(xpath="//*[@data-tabtarget='restaurant']//ul/li/a")
    List<WebElement> dblRestaurants;

    @FindBy(xpath="//*[@data-tabtarget='bars-and-cafe']//ul/li/a")
    List<WebElement> dblBarsAndCafes;

    @FindBy(xpath= "//*[@data-tabtarget='sports']//ul/li/a")
    List<WebElement> dblSportsEntertainment;

    @FindBy(xpath = "//*[@class = 'oneline ellipsis']")
    List<WebElement> placesElementType;

    public WebElement getAdBanner() {
        return adBanner;
    }
    @FindBy(xpath = "//*[@id='aswift_1']")
    WebElement adBanner;

    public List<WebElement> getDblBarsAndCafes() {
        return dblBarsAndCafes;
    }

    public List<WebElement> getDblSportsEntertainment() {
        return dblSportsEntertainment;
    }

    public List<WebElement> getPlacesElementType() {
        return placesElementType;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public WebElement getBtnSeeOnMap() {
        return btnSeeOnMap;
    }

    public WebElement getBtnOptions() {
        return btnOptions;
    }

    public List<WebElement> getDdlCategories() {
        return ddlCategories;
    }

    public List<WebElement> getCategories() {
        return Categories;
    }

    public List<WebElement> getDblRestaurants() {
        return dblRestaurants;
    }

}
