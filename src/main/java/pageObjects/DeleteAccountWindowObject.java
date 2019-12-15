package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountWindowObject extends PageObject {

    @FindBy(xpath = "//input[@id='formDeleteAccount_currentPassword']")
    private WebElement txtCurrentPassword;

    @FindBy(xpath = "//button[@id='formDeleteAccount_btn-submit']")
    private WebElement btnDeleteAccountSubmit;

    @FindBy(xpath = "//button[@id='formDeleteAccount_cancel']")
    private WebElement btnCancelDelete;

    public WebElement getTxtCurrentPassword() {
        return txtCurrentPassword;
    }

    public WebElement getBtnDeleteAccountSubmit() {
        return btnDeleteAccountSubmit;
    }

    public WebElement getBtnCancelDelete() {
        return btnCancelDelete;
    }
}
