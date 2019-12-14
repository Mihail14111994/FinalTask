package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageObject extends  PageObject{

    @FindBy(xpath = "//*[@id='formRegisterUser']/div[1]/h2")
    private WebElement ttlRegister;

    @FindBy(xpath = "//input[@id='formRegisterUser_email']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@id='formRegisterUser_password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@id='formRegisterUser_passwordConfirm']")
    private WebElement txtConfirmPassword;

    @FindBy(xpath = "//div[contains(@id, 'formRegisterUser_group_submit')]//button[@name='btn-submit']")
    private WebElement btnRegistration;

    @FindBy(xpath = "//button[@class='btn btn-secondary btn-small btn-switch-login active']")
    private WebElement btnLoginSwitch;

    @FindBy(xpath = "//button[@class='btn btn-small btn-auth-facebook']")
    private WebElement btnFacebookLogin;

    @FindBy(xpath = "//input[@id='formRegisterUser_subscribeNewsletter']")
    private WebElement cbSubscrubing;

    @FindBy(xpath = "//span[@class='field-error']")
    private WebElement msgError;

    @FindBy(xpath = "//*[@id='formRegisterUser_subscribeNewsletter_field']/label")
    private WebElement msgcbSubscribing;

    @FindBy(xpath = "//div[@id='formRegisterUser_email_field']//div[@class='field-errors']")
    private WebElement msgErrorEmail;

    @FindBy(xpath = "//div[@id='formRegisterUser_password_field']//div[@class='field-errors']")
    private WebElement msgErrorPassword;

    @FindBy(xpath = "//div[@id='formRegisterUser_passwordConfirm_field']//div[@class='field-errors']")
    private WebElement msgErrorConfirmPassword;

    public WebElement getMsgcbSubscribing() {
        return msgcbSubscribing;
    }

    public WebElement getMsgError() {
        return msgError;
    }

    public WebElement getTtlRegister() {
        return ttlRegister;
    }

    public WebElement getTxtEmail() {
        return txtEmail;
    }

    public WebElement getTxtPassword() {
        return txtPassword;
    }

    public WebElement getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public WebElement getBtnRegistration() {
        return btnRegistration;
    }

    public WebElement getBtnLoginSwitch() {
        return btnLoginSwitch;
    }

    public WebElement getBtnFacebookLogin() {
        return btnFacebookLogin;
    }

    public WebElement getCbSubscrubing() {
        return cbSubscrubing;
    }

    public void setTtlRegister(WebElement ttlRegister) {
        this.ttlRegister = ttlRegister;
    }

    public void setTxtEmail(WebElement txtEmail) {
        this.txtEmail = txtEmail;
    }

    public void setTxtPassword(WebElement txtPassword) {
        this.txtPassword = txtPassword;
    }

    public void setTxtConfirmPassword(WebElement txtConfirmPassword) {
        this.txtConfirmPassword = txtConfirmPassword;
    }

    public void setBtnRegistration(WebElement btnRegistration) {
        this.btnRegistration = btnRegistration;
    }

    public void setBtnLoginSwitch(WebElement btnLoginSwitch) {
        this.btnLoginSwitch = btnLoginSwitch;
    }

    public void setBtnFacebookLogin(WebElement btnFacebookLogin) {
        this.btnFacebookLogin = btnFacebookLogin;
    }

    public void setCbSubscrubing(WebElement cbSubscrubing) {
        this.cbSubscrubing = cbSubscrubing;
    }

    public WebElement getMsgErrorEmail() {
        return msgErrorEmail;
    }

    public WebElement getMsgErrorPassword() {
        return msgErrorPassword;
    }

    public WebElement getMsgErrorConfirmPassword() {
        return msgErrorConfirmPassword;
    }
}
