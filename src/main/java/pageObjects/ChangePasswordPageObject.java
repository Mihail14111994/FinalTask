package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPageObject extends PageObject {
    @FindBy(xpath = "//input[@id='formChangePassword_currentPassword']")
    private WebElement txtCurrentPasswordField;

    @FindBy(xpath = "//input[@id='formChangePassword_password']")
    private WebElement txtNewPasswordField;

    @FindBy(xpath = "//input[@id='formChangePassword_passwordConfirm']")
    private WebElement txtConfirmPasswordField;

    @FindBy(xpath = "//button[@id='formChangePassword_btn-submit']")
    private WebElement btnChangePassword;

    public WebElement getTxtCurrentPasswordField() {
        return txtCurrentPasswordField;
    }

    public WebElement getTxtNewPasswordField() {
        return txtNewPasswordField;
    }

    public WebElement getTxtConfirmPasswordField() {
        return txtConfirmPasswordField;
    }

    public WebElement getBtnChangePassword() {
        return btnChangePassword;
    }
}
