package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//@Data
public class LoginPageObject extends PageObject {


    @FindBy(xpath = "//form[@id='formLoginUser']")
    private WebElement frmLogin;

    @FindBy(xpath = "//*[@id='formLoginUser']/div[1]/h2")
    private WebElement ttlLogin;

    @FindBy(xpath = "//input[@id='formLoginUser_email']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@id='formLoginUser_password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//*[@id='formLoginUser_forgot-password']/a")
    private WebElement lnkForgot;

    @FindBy(xpath = "//button[@id='formLoginUser_btn-submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//button[@class='btn btn-secondary btn-small btn-switch-register active']")
    private WebElement btnRegisterswitch;

    @FindBy(xpath = "//button[@class='btn btn-small btn-auth-facebook']")
    private WebElement btnFacebookLogin;

    @FindBy(xpath = "//div[@id='formLoginUser_email_field']//div[@class='field-errors']")
    private WebElement msgErrorEmail;



    public WebElement getMsgErrorEmail() {
        return msgErrorEmail;
    }


    public WebElement getFrmLogin() {
        return frmLogin;
    }

    public WebElement getTtlLogin() {
        return ttlLogin;
    }

    public WebElement getTxtEmail() {
        return txtEmail;
    }

    public WebElement getTxtPassword() {
        return txtPassword;
    }

    public WebElement getLnkForgot() {
        return lnkForgot;
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }

    public WebElement getBtnRegisterswitch() {
        return btnRegisterswitch;
    }

    public WebElement getBtnFacebookLogin() {
        return btnFacebookLogin;
    }


}
