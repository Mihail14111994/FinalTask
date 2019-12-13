package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventPage extends PageObject{
    @FindBy(css = ".select.ticket-qty")
    List<WebElement> ticketsNrBox;

    @FindBy(css = ".select.ticket-qty > option")
    List <WebElement> ticketsNr;

    @FindBy(css = ".btn.btn-submit.btn-primary")
    WebElement submitNrOfTickets;

    @FindBy(xpath = "//*[@id='form-add-to-cart']/form/table/tbody/tr[1]/td[2]/label")
    WebElement priceOfTicket;

    @FindBy (xpath = "//*[@id='content']/div[3]/div[1]/div[2]/div/div[3]/a")
    WebElement btndetails;

    public WebElement getBtndetails() {
        return btndetails;
    }

    public WebElement getPriceOfTicket() {
        return priceOfTicket;
    }

    public WebElement getSubmitNrOfTickets() {
        return submitNrOfTickets;
    }

    public List<WebElement> getTicketsNr() {
        return ticketsNr;
    }

    public List<WebElement> getTicketsNrBox() {
        return ticketsNrBox;
    }
}
