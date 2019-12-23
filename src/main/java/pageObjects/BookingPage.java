package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BookingPage extends PageObject {

    @FindBy(xpath = "//*[@id='content']/div[4]/table/tbody/tr/td[4]")
    private WebElement amountToBePaid;

    @FindBy(xpath = "//*[@id='formCheckout_paymentMethod_1']")
    private WebElement radioBtnTerminal;

    @FindBy(xpath = "//*[@id='formCheckout_firstName']")
    private WebElement fldFirstName;

    @FindBy(xpath = "//*[@id='formCheckout_lastName']")
    private WebElement fldLastName;

    @FindBy(xpath = "//*[@id='formCheckout_phone']")
    private WebElement fldPhoneNr;

    @FindBy(xpath = "//*[@id='formCheckout_btn-submit']")
    private WebElement btnContinue;

    @FindBy(xpath = "//*[@id='order']/table/tbody/tr/td[4]")
    private WebElement totalPriceConfirm;

    @FindBy(id = "formConfirmOrder_btn-submit")
    private WebElement btnSubmitConfirm;

    @FindBy(xpath = "//*[@id='orders']/div[1]/div[2]/div/div[2]/button ")
    private WebElement btnBookingDetails;

    @FindBy(className = "field-error")
    private List<WebElement> lblError;

    public WebElement getAmountToBePaid() {
        return amountToBePaid;
    }

    public WebElement getRadioBtnTerminal() {
        return radioBtnTerminal;
    }

    public WebElement getFldFirstName() {
        return fldFirstName;
    }

    public WebElement getFldLastName() {
        return fldLastName;
    }

    public WebElement getFldPhoneNr() {
        return fldPhoneNr;
    }

    public WebElement getBtnContinue() {
        return btnContinue;
    }

    public WebElement getTotalPriceConfirm() {
        return totalPriceConfirm;
    }

    public WebElement getBtnSubmitConfirm() {
        return btnSubmitConfirm;
    }

    public WebElement getBtnBookingDetails() {
        return btnBookingDetails;
    }

    public List<WebElement> getLblError() {
        return lblError;
    }
}
