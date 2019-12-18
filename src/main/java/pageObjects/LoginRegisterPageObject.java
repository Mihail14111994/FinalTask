package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegisterPageObject extends PageObject {

    String link = "https://www.fest.md/ro/login-register";

    @FindBy(xpath = "//input[@id='formLogin_email']")
    private WebElement txtLoginEmail;

    @FindBy(xpath = "//input[@id='formLogin_password']")
    private WebElement txtLoginPassword;

    @FindBy(xpath = "//button[@id='formLogin_btn-submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id='formLogin_forgot-password']/a")
    private WebElement linkForgotPassword;

    @FindBy(xpath = "//*[@id='content']/div[3]/div/div[2]/button")
    private WebElement btnFacebookLoginRegister;

    @FindBy(xpath = "//input[@id='formRegister_email']")
    private WebElement txtRegisterEmail;

    @FindBy(xpath = "//input[@id='formRegister_password']")
    private WebElement txtRegisterPassword;

    @FindBy(xpath = "//input[@id='formRegister_passwordConfirm']")
    private WebElement txtRegisterConfirmPassword;

    @FindBy(xpath = "//input[@id='formRegister_subscribeNewsletter']")
    private WebElement cbSubscribeNewsletter;

    @FindBy(xpath = "//button[@id='formRegister_btn-submit']")
    private WebElement btnRegister;

    @FindBy(xpath = "//h1[@class='page-title bordered']")
    private WebElement ttlLoginRegister;

    @FindBy(xpath = "//*[@id='formLogin']/div[1]/h2")
    private WebElement ttlLogin;

    @FindBy(xpath = "//*[@id='formRegister']/div[1]/h2")
    private WebElement ttlRegister;

    @FindBy(xpath = "//*[@id='formRegister_subscribeNewsletter_field']/label")
    private WebElement ttlCbSubscribe;

    public WebElement getTtlCbSubscribe() {
        return ttlCbSubscribe;
    }

    public WebElement getTtlLoginRegister() {
        return ttlLoginRegister;
    }

    public WebElement getTtlLogin() {
        return ttlLogin;
    }

    public WebElement getTtlRegister() {
        return ttlRegister;
    }

    public String getLink() {
        return link;
    }

    public WebElement getTxtLoginEmail() {
        return txtLoginEmail;
    }

    public WebElement getTxtLoginPassword() {
        return txtLoginPassword;
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }

    public WebElement getLinkForgotPassword() {
        return linkForgotPassword;
    }

    public WebElement getBtnFacebookLoginRegister() {
        return btnFacebookLoginRegister;
    }

    public WebElement getTxtRegisterEmail() {
        return txtRegisterEmail;
    }

    public WebElement getTxtRegisterPassword() {
        return txtRegisterPassword;
    }

    public WebElement getTxtRegisterConfirmPassword() {
        return txtRegisterConfirmPassword;
    }

    public WebElement getCbSubscribeNewsletter() {
        return cbSubscribeNewsletter;
    }

    public WebElement getBtnRegister() {
        return btnRegister;
    }
}
