package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventPage extends PageObject{
    @FindBy (xpath = "//*[@id='content']/div[3]/div[1]/div[2]/div/div[1]/span")
    WebElement nameOfEvent;

    public WebElement getNameOfEvent() {
        return nameOfEvent;
    }

    @FindBy(css = ".select.ticket-qty")
    List<WebElement> ticketsNrBox;

    @FindBy(xpath = "//*[@id='form-add-to-cart']/form/table/tbody/tr[1]/td[3]/label/select")
    WebElement boxOfTickets;

    @FindBy(css = ".select.ticket-qty > option")
    List <WebElement> ticketsNr;

    @FindBy(css = ".btn.btn-submit.btn-primary")
    WebElement submitNrOfTickets;

    @FindBy(xpath = "//*[@id='form-add-to-cart']/form/table/tbody/tr[1]/td[2]/label")
    WebElement priceOfTicket;

    @FindBy (xpath = "//*[@id='content']/div[3]/div[1]/div[2]/div/div[3]/a")
    WebElement btndetails;

    @FindBy (xpath = "//*[@id='content']/div[4]/table/tbody/tr/td[4]")
    WebElement amountToBePaid;

    @FindBy (xpath="//*[@id='formCheckout_paymentMethod_1']")
    WebElement radioBtnTerminal;

    @FindBy(xpath = "//*[@id='formCheckout_firstName']")
    WebElement fldFirstName;

    @FindBy (xpath = "//*[@id='formCheckout_lastName']")
    WebElement fldLastName;

    @FindBy (xpath = "//*[@id='formCheckout_phone']")
    WebElement fldPhoneNr;

    @FindBy (xpath = "//*[@id='formCheckout_btn-submit']")
    WebElement btnContinue;

    @FindBy (xpath = "//*[@id='order']/table/tbody/tr/td[4]")
    WebElement totalPriceConfirm;

    @FindBy (id = "formConfirmOrder_btn-submit")
    WebElement btnSubmitConfirm;

    @FindBy (xpath = "//*[@id='header']/div[2]/a")
    WebElement btnMyBookings;

    @FindBy (xpath = "//*[@id='orders']/div[1]/div[2]/div/div[2]/button ")
    WebElement btnBookingDetails;

    @FindBy (xpath = "//*[@id='orders']/div[1]/div[2]/div/div[1]/span")
    WebElement nameOfBookingEvent;

    @FindBy (className = "field-error")
    List <WebElement> lblError;

    public List<WebElement> getLblError() {
        return lblError;
    }

    public WebElement getNameOfBookingEvent() {
        return nameOfBookingEvent;
    }

    public WebElement getBtnBookingDetails() {
        return btnBookingDetails;
    }

    public WebElement getBtnSubmitConfirm() {
        return btnSubmitConfirm;
    }

    public WebElement getBtnMyBookings() {
        return btnMyBookings;
    }

    public WebElement getTotalPriceConfirm() {
        return totalPriceConfirm;
    }

    public WebElement getBtnContinue() {
        return btnContinue;
    }

    public WebElement getFldLastName() {
        return fldLastName;
    }

    public WebElement getFldPhoneNr() {
        return fldPhoneNr;
    }

    public WebElement getFldFirstName() {
        return fldFirstName;
    }

    public WebElement getRadioBtnTerminal() {
        return radioBtnTerminal;
    }

    public WebElement getAmountToBePaid() {
        return amountToBePaid;
    }

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

    public WebElement getBoxOfTickets() {
        return boxOfTickets;
    }
}
