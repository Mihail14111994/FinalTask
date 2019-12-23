package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TicketSectionsPage extends PageObject {
    @FindBy(xpath = "//*[@id='content']/div[3]/div[1]/div[2]/div/div[1]/span")
    private WebElement nameOfEvent;

    @FindBy(css = ".select.ticket-qty")
    private List<WebElement> ticketsNrBox;

    @FindBy(xpath = "//*[@id='form-add-to-cart']/form/table/tbody/tr[1]/td[3]/label/select")
    private List<WebElement> boxOfTickets;

    @FindBy(css = ".select.ticket-qty > option")
    private List<WebElement> ticketsNr;

    @FindBy(css = ".btn.btn-submit.btn-primary")
    private WebElement btnSubmitNrOfTickets;

    @FindBy(css = ".btn.btn-submit.btn-primary.disabled")
    private WebElement btnSubmitNrOfTicketsDisabled;

    @FindBy(xpath = "//*[@id='form-add-to-cart']/form/table/tbody/tr[1]/td[2]/label")
    private WebElement priceOfTicket;

    @FindBy(xpath = "//*[@id='content']/div[3]/div[1]/div[2]/div/div[3]/a")
    private WebElement btndetails;

    @FindBy(xpath = "//*[@id='orders']/div[1]/div[2]/div/div[1]/span")
    private WebElement nameOfBookingEvent;

    public WebElement getNameOfEvent() {
        return nameOfEvent;
    }

    public WebElement getNameOfBookingEvent() {
        return nameOfBookingEvent;
    }

    public WebElement getBtndetails() {
        return btndetails;
    }

    public WebElement getPriceOfTicket() {
        return priceOfTicket;
    }

    public WebElement getBtnSubmitNrOfTickets() {
        return btnSubmitNrOfTickets;
    }

    public WebElement getBtnSubmitNrOfTicketsDisabled() {
        return btnSubmitNrOfTicketsDisabled;
    }

    public List<WebElement> getTicketsNr() {
        return ticketsNr;
    }

    public List<WebElement> getTicketsNrBox() {
        return ticketsNrBox;
    }

    public List<WebElement> getBoxOfTickets() {
        return boxOfTickets;
    }
}
