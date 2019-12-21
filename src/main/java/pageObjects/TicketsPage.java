package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TicketsPage extends PageObject{
    @FindBy(xpath = "//*[@id='content']/h1")
    WebElement pageName;

    @FindBy(xpath="//div[@id='content']/div//div/h2")
    List<WebElement> sectionNames;

    @FindBy(xpath="//div[@data-type='concert']/div[2]/div/div[3]/a")
    List<WebElement> listOfConcerts;

    @FindBy(css="#onsale-contents > div:not([style='display: none;']) > div.content > div > div.display-tr.oneline.buttons > a")
    List<WebElement> listOfEvents;

    public List<WebElement> getListOfEvents() {
        return listOfEvents;
    }

    public List<WebElement> getListOfParties() {
        return listOfEvents;
    }

    @FindBy(xpath = "//div[@data-type='conference']/div[2]/div/div[3]/a")
    List<WebElement> listOfConferences;

    public WebElement getAdBanner() {
        return adBanner;
    }

    @FindBy(xpath = "//*[@id='aswift_1']")
    WebElement adBanner;

    public List<WebElement> getListOfConferences() {
        return listOfConferences;
    }
    public List<WebElement> getListOfConcerts() {
        return listOfConcerts;
    }

    public List <WebElement> getSectionNames() {
        return sectionNames;
    }

    public WebElement getPageName() {
        return pageName;
    }
}
