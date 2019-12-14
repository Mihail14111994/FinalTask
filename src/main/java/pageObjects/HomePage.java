package pageObjects;

import driverFactory.DriverFactory;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageObject{
    @FindBy(css="body > div.main-nav > div > div.links > ul > li:nth-child(1) > a")
    WebElement ticketsMenu;

    @FindBy(xpath = "//a[@href='/ro/evenimente']")
    WebElement eventsMenu;

    @FindBy (xpath = "//*[@id='header']/div[2]/a")
    WebElement btnMyBookings;

    @FindBy (css = "div.bar-item.inlined.username > a")
    WebElement ddUserInformation;

    @FindBy (css = "div.bar-item.inlined.username.open > ul > li:nth-child(2) > a")
    WebElement btnMyAccount;


    public WebElement getTicketsMenu() {
        return ticketsMenu;
    }

    public WebElement getEventsMenu() {
        return eventsMenu;
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
