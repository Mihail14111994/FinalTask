package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

//    @FindBy(xpath="//a[@href='/ro/bilete']")
    String linkHomePage = "https://www.fest.md/ro/";

    public String getLinkHomePage() {
        return linkHomePage;
    }

    @FindBy(xpath = "//div[contains(@class, 'float-right')]//a[@class='bar-item inlined padded login']")
    WebElement btnOpenLogin;

    @FindBy(css="body > div.main-nav > div > div.links > ul > li:nth-child(1) > a")
    WebElement ticketsMenu;

    @FindBy(xpath = "//*[@class='links']//a//span[text()='Places']")
    WebElement PlacesMenu;

    @FindBy(xpath = "//*[@class = 'form-control large searchbar-search']")
    WebElement txtSearchbar;

    @FindBy(xpath = "//*[@class = 'icon icon-search']")
    WebElement btnSearch;

    @FindBy(xpath = "//a[@href='/ro/evenimente']")
    WebElement eventsMenu;

    @FindBy(xpath = "//*[@class='links']//a//span[text()='Places']")
    WebElement placesMenu;


    @FindBy (xpath = "//*[@id='header']/div[2]/a")
    WebElement btnMyBookings;

    @FindBy (css = "div.bar-item.inlined.username > a")
    WebElement ddUserInformation;

    @FindBy (css = "div.bar-item.inlined.username.open > ul > li:nth-child(2) > a")
    WebElement btnMyAccount;
  
    @FindBy(xpath = "//div[contains(@class, 'float-right')]//a[@class='bar-item inlined padded register hidden-on-tablet']" )
    WebElement btnOpenRegistration;

    @FindBy(xpath = "//h2[@id='dateslider-title']")
    WebElement ttlCalendar;

    @FindBy(xpath = "//a[contains(text(),'Suggest Event')]")
    WebElement btnSuggestedEvent;

    @FindBy(xpath = "//div[@class='site-logo']//a")
    WebElement btnHome;

    public WebElement getBtnHome() {
        return btnHome;
    }

    public WebElement getTtlCalendar() {
        return ttlCalendar;
    }

    public WebElement getBtnOpenRegistration() {
        return btnOpenRegistration;
    }

    public WebElement getBtnOpenLogin() {
        return btnOpenLogin;
    }

    public WebElement getTicketsMenu() {
        return ticketsMenu;
    }

    public WebElement getTxtSearchbar() {
        return txtSearchbar;
    }

    public WebElement getBtnSearch() {
        return btnSearch;
    }

    public WebElement getEventsMenu() {
        return eventsMenu;
    }

    public WebElement getBtnSuggestedEvent() {
        return btnSuggestedEvent;
    }

    public WebElement getPlacesMenu() {
        return PlacesMenu;}
    public WebElement getBtnMyBookings() {
        return btnMyBookings;
    }

    public WebElement getDdUserInformation() {
        return ddUserInformation;
    }

    public WebElement getBtnMyAccount() {
        return btnMyAccount;
    }
}
