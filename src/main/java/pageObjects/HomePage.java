package pageObjects;

import driverFactory.DriverFactory;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageObject{
//    @FindBy(xpath="//a[@href='/ro/bilete']")
    @FindBy(css="body > div.main-nav > div > div.links > ul > li:nth-child(1) > a")
    WebElement ticketsMenu;

    @FindBy(xpath = "//a[@href='/ro/evenimente']")
    WebElement eventsMenu;

    public WebElement getTicketsMenu() {
        return ticketsMenu;
    }

    public WebElement getEventsMenu() {
        return eventsMenu;
    }
}
