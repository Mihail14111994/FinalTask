package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//@Data
public class LoginPageObject {

    @FindBy(xpath = "//*[@id='formRegister_email_field']/div/span")
    private WebElement emailField;

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

    public WebElement getEmailField() {
        return emailField;
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

    public void setEmailField(WebElement emailField) {
        this.emailField = emailField;
    }

    public void setFrmLogin(WebElement frmLogin) {
        this.frmLogin = frmLogin;
    }

    public void setTtlLogin(WebElement ttlLogin) {
        this.ttlLogin = ttlLogin;
    }

    public void setTxtEmail(WebElement txtEmail) {
        this.txtEmail = txtEmail;
    }

    public void setTxtPassword(WebElement txtPassword) {
        this.txtPassword = txtPassword;
    }

    public void setLnkForgot(WebElement lnkForgot) {
        this.lnkForgot = lnkForgot;
    }

    public void setBtnLogin(WebElement btnLogin) {
        this.btnLogin = btnLogin;
    }

    public void setBtnRegisterswitch(WebElement btnRegisterswitch) {
        this.btnRegisterswitch = btnRegisterswitch;
    }

    public void setBtnFacebookLogin(WebElement btnFacebookLogin) {
        this.btnFacebookLogin = btnFacebookLogin;
    }
}
