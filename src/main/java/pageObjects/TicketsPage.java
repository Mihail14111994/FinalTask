package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TicketsPage extends PageObject{
    @FindBy(xpath = "//*[@id='content']/h1")
    WebElement pageName;

    @FindBy(xpath="//*[@id='onsale-tabber']/div/div/h2")
    List<WebElement> sectionNames;

    @FindBy(xpath="//div[@data-type='concert']/div[2]/div/div[3]/a")
    List<WebElement> listOfConcerts;

//    @FindBy(css="#onsale-contents > div[style='display: block;'] > div.content > div > div.display-tr.oneline.buttons > a")

    @FindBy(xpath = "//div[@data-type='conference']/div[2]/div/div[3]/a")
    List<WebElement> listOfEvents;

    public WebElement getAdBanner() {
        return adBanner;
    }

    @FindBy(xpath = "//*[@id='aswift_1']")
    WebElement adBanner;

    public List<WebElement> getListOfEvents() {
        return listOfEvents;
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
