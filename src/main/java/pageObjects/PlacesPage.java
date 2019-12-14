package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlacesPage  extends  PageObject{

    @FindBy(xpath = "'//*[@class='links']//a//span[text()='Places']")
    WebElement btnPlaces;

    @FindBy(xpath = "//h1[@class='page-title bordered']")
    WebElement pageTitle;

    @FindBy(xpath="//*[@class=\"dropdown-toggle\"]//h2")
    List<WebElement> dblCategories;

    @FindBy(xpath="//*[@data-tabtarget='restaurant']//ul/li/a")
    List<WebElement> dblRestaurants;

    @FindBy(xpath="//*[@data-tabtarget='bars-and-cafe']//ul/li/a")
    List<WebElement> dblBarsAndCafes;

    @FindBy(xpath= "//*[@data-tabtarget='sports']//ul/li/a")
    List<WebElement> dblSportsEntertainment;

    @FindBy(className = "oneline ellipsis")
    List<WebElement> placesElements;

    public WebElement getBtnTitle() {
        return btnPlaces;
    }

    public List<WebElement> getDblBarsAndCafes() {
        return dblBarsAndCafes;
    }

    public List<WebElement> getDblSportsEntertainment() {
        return dblSportsEntertainment;
    }

    public List<WebElement> getPlacesElements() {
        return placesElements;
    }

    public WebElement getPageTitle() {
        return pageTitle;
    }

    public List<WebElement> getDblCategories() {
        return dblCategories;
    }

    public List<WebElement> getDblRestaurants() {
        return dblRestaurants;
    }
}
