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

    @FindBy(xpath = "//a[@href='/ro/evenimente']")
    WebElement eventsMenu;

    @FindBy(xpath = "//div[contains(@class, 'float-right')]//a[@class='bar-item inlined padded register hidden-on-tablet']" )
    WebElement btnOpenRegistration;

    @FindBy(xpath = "//h2[@id='dateslider-title']")
    WebElement ttlCalendar;

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

    public WebElement getEventsMenu() {
        return eventsMenu;
    }
}
