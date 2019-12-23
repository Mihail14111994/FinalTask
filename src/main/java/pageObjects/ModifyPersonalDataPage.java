package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModifyPersonalDataPage extends PageObject {

    @FindBy(xpath = "//input[@id='formAccount_firstName']")
    private WebElement txtFirstName;

    @FindBy(xpath = "//input[@id='formAccount_lastName']")
    private WebElement txtLastName;

    @FindBy(xpath = "//input[@id='formAccount_phone']")
    private WebElement txtAccountPhone;

    @FindBy(xpath = "//input[@id='formAccount_city']")
    private WebElement txtAccountCity;

    @FindBy(xpath = "//input[@id='formAccount_address']")
    private WebElement txtAccountAddress;

    @FindBy(xpath = "//button[@id='formAccount_btn-submit']")
    private WebElement btnSubmitModify;

    @FindBy(xpath = "//button[@id='formAccount_cancel']")
    private WebElement btnCancelModify;

    public WebElement getTxtFirstName() {
        return txtFirstName;
    }

    public WebElement getTxtLastName() {
        return txtLastName;
    }

    public WebElement getTxtAccountPhone() {
        return txtAccountPhone;
    }

    public WebElement getTxtAccountCity() {
        return txtAccountCity;
    }

    public WebElement getTxtAccountAddress() {
        return txtAccountAddress;
    }

    public WebElement getBtnSubmitModify() {
        return btnSubmitModify;
    }

    public WebElement getBtnCancelModify() {
        return btnCancelModify;
    }
}
