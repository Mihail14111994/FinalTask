package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistrationPage extends PageObject{
    @FindBy(id = "formLogin_email")
    WebElement emailLogin;

    @FindBy(id = "formLogin_password")
    WebElement passwordLogin;

    @FindBy(xpath = "//*[@id='formLogin_forgot-password']/a")
    WebElement forgotPasswordLink;

    @FindBy(id = "formLogin_btn-submit")
    WebElement btnLogin;

    @FindBy(id="formRegister_email")
    WebElement emailRegister;

    @FindBy(id="formRegister_password")
    WebElement passwordRegister;

    @FindBy(id="formRegister_passwordConfirm")
    WebElement passwordConfirmRegister;

    @FindBy(id="formRegister_subscribeNewsletter")
    WebElement newsletterSelect;

    @FindBy (id="formRegister_btn-submit")
    WebElement btnRegister;

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

