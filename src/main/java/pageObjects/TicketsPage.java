package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TicketsPage extends PageObject {

    @FindBy(xpath = "//*[@id='content']/h1")
    private WebElement pageName;

    @FindBy(xpath = "//div[@id='content']/div//div/h2")
    private List<WebElement> sectionNames;

    @FindBy(xpath = "//div[@data-type='concert']/div[2]/div/div[3]/a")
    private List<WebElement> listOfConcerts;

    @FindBy(css = "#onsale-contents > div:not([style='display: none;']) > div.content > div > div.display-tr.oneline.buttons > a")
    private List<WebElement> listOfEvents;

    @FindBy(xpath = "//div[@data-type='conference']/div[2]/div/div[3]/a")
    private List<WebElement> listOfConferences;

    @FindBy(xpath = "//*[@id='aswift_1']")
    private WebElement adBanner;

    public List<WebElement> getListOfParties() {
        return listOfEvents;
    }

    public WebElement getAdBanner() {
        return adBanner;
    }

    public List<WebElement> getListOfConferences() {
        return listOfConferences;
    }

    public List<WebElement> getListOfConcerts() {
        return listOfConcerts;
    }

    public List<WebElement> getSectionNames() {
        return sectionNames;
    }

    public WebElement getPageName() {
        return pageName;
    }
}
