package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistrationPage extends PageObject{
    @FindBy(id = "formLogin_email")
    private WebElement emailLogin;

    @FindBy(id = "formLogin_password")
    private WebElement passwordLogin;

    @FindBy(xpath = "//*[@id='formLogin_forgot-password']/a")
    private WebElement forgotPasswordLink;

    @FindBy(id = "formLogin_btn-submit")
    private WebElement btnLogin;

    @FindBy(id="formRegister_email")
    private WebElement emailRegister;

    @FindBy(id="formRegister_password")
    private WebElement passwordRegister;

    @FindBy(id="formRegister_passwordConfirm")
    private WebElement passwordConfirmRegister;

    @FindBy(id="formRegister_subscribeNewsletter")
    private WebElement newsletterSelect;

    @FindBy (id="formRegister_btn-submit")
    private WebElement btnRegister;

    public WebElement getEmailLogin() {
        return emailLogin;
    }

    public WebElement getPasswordLogin() {
        return passwordLogin;
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }

    public WebElement getEmailRegister() {
        return emailRegister;
    }

    public WebElement getPasswordRegister() {
        return passwordRegister;
    }

    public WebElement getPasswordConfirmRegister() {
        return passwordConfirmRegister;
    }

    public WebElement getNewsletterSelect() {
        return newsletterSelect;
    }

    public WebElement getBtnRegister() {
        return btnRegister;
    }
}

