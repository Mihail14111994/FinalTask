package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

    String linkHomePage = "https://www.fest.md/ro/";

    public String getLinkHomePage() {
        return linkHomePage;
    }

    @FindBy(xpath = "//div[contains(@class, 'float-right')]//a[@class='bar-item inlined padded login']")
    private WebElement btnOpenLogin;

    @FindBy(css="body > div.main-nav > div > div.links > ul > li:nth-child(1) > a")
    private WebElement ticketsMenu;

    @FindBy(xpath = "//*[@class='links']//a//span[text()='Places']")
    private WebElement PlacesMenu;

    @FindBy(xpath = "//*[@class = 'form-control large searchbar-search']")
    private WebElement txtSearchbar;

    @FindBy(xpath = "//*[@class = 'icon icon-search']")
    private WebElement btnSearch;

    @FindBy(xpath = "//a[@href='/ro/evenimente']")
    private WebElement eventsMenu;

    @FindBy (xpath = "//*[@id='header']/div[2]/a")
    private WebElement btnMyBookings;

    @FindBy (css = "div.bar-item.inlined.username > a")
    private WebElement ddUserInformation;

    @FindBy (css = "div.bar-item.inlined.username.open > ul > li:nth-child(2) > a")
    private WebElement btnMyAccount;
  
    @FindBy(xpath = "//div[contains(@class, 'float-right')]//a[@class='bar-item inlined padded register hidden-on-tablet']" )
    private WebElement btnOpenRegistration;

    @FindBy(xpath = "//h2[@id='dateslider-title']")
    private WebElement ttlCalendar;

    @FindBy(xpath = "//a[contains(text(),'Suggest Event')]")
    private WebElement btnSuggestedEvent;


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
        return PlacesMenu;
    }

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
