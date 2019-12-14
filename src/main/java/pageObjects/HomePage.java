package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{
//    @FindBy(xpath="//a[@href='/ro/bilete']")
    @FindBy(css="body > div.main-nav > div > div.links > ul > li:nth-child(1) > a")
    WebElement ticketsMenu;

    @FindBy(xpath = "//a[@href='/ro/evenimente']")
    WebElement eventsMenu;

    @FindBy(xpath = "//*[@class='links']//a//span[text()='Places']")
    WebElement placesMenu;

    public WebElement getPlacesMenu() { return placesMenu; }

    public WebElement getTicketsMenu() {
        return ticketsMenu;
    }

    public WebElement getEventsMenu() {
        return eventsMenu;
    }
}
