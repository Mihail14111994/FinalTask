package stepImplementation;

import actionMethods.Borders;
import actionMethods.Colours;
import actionMethods.ScrollingPixels;
import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class RegisterSteps {
    HomePage homePage = new HomePage();
    RegisterPageObject registerPage = new RegisterPageObject();
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    MyAccountPage myAccountPage = new MyAccountPage();
    LoginPageObject loginPage = new LoginPageObject();
    DeleteAccountWindowObject deleteAccount = new DeleteAccountWindowObject();
    LoginRegisterPageObject loginRegisterPage = new LoginRegisterPageObject();
    Borders borders = new Borders();
    TakesScreenshot scrShot =((TakesScreenshot)driver);

    String workingEmail;
    String workingPassword;

    public void openRegisterWindow() {
        homePage.getBtnOpenRegistration().click();
        wait.until(ExpectedConditions.visibilityOf(registerPage.getTxtEmail()));
    }

    public void fillDataInEmailPasswordFieldsRegister(String email, String password) {
        workingEmail = email;
        workingPassword = password;
        switch (password) {
            case "null": {
                registerPage.getTxtEmail().sendKeys(email);
                registerPage.getTxtConfirmPassword().sendKeys("OneTwoThree");
                break;
            }
            case "PassWithAnotherConfirm": {
                registerPage.getTxtEmail().sendKeys(email);
                registerPage.getTxtPassword().sendKeys("password");
                registerPage.getTxtConfirmPassword().sendKeys("anotherPassword");
                break;
            }
            default: {
                if (email.equals("null")) {
                    registerPage.getTxtPassword().sendKeys(password);
                    registerPage.getTxtConfirmPassword().sendKeys(password);
                    break;
                } else {
                    registerPage.getTxtEmail().sendKeys(email);
                    registerPage.getTxtPassword().sendKeys(password);
                    registerPage.getTxtConfirmPassword().sendKeys(password);
                    break;
                }
            }
        }
    }

    public void clickRegisterButton() {
        ScrollingPixels scrollingPixels = new ScrollingPixels();
        scrollingPixels.scrollingPixels(driver, 0, 250);
        registerPage.getBtnRegistration().click();
    }

    public void checkThatHomePageIsDisplayed() {
        if (driver.getCurrentUrl() != "fest.md") {
            driver.get(homePage.getLinkHomePage());
        }
        wait.until(ExpectedConditions.visibilityOf(homePage.getTtlCalendar()));
        System.out.println(homePage.getTtlCalendar().isDisplayed());
        MatcherAssert.assertThat(homePage.getTtlCalendar().isDisplayed(), is(true));
    }

    public void makeLogout() {
        myAccountPage.getDdUser().click();
        myAccountPage.getBtnOpenMyAccountPage().click();
        MatcherAssert.assertThat(driver.getPageSource().contains(workingEmail), is(true));
        myAccountPage.getDdUser().click();
        myAccountPage.getBtnLogout().click();
        wait.until(ExpectedConditions.visibilityOf(homePage.getBtnOpenLogin()));
    }

    public void checkFailingRegisterWithTheSameCredentials() {
        wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgError()));
        MatcherAssert.assertThat(registerPage.getMsgError().isDisplayed(), is(true));
    }

    public void openLoginWindow() {
        homePage.getBtnOpenLogin().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getTxtEmail()));
    }

    public void fillDataInEmailPasswordFieldsLogin(String email, String password) {
        workingEmail=email;
        workingPassword=password;
        loginPage.getTxtEmail().sendKeys(email);
        loginPage.getTxtPassword().sendKeys(password);
    }

    public void clickLoginButton() {
        ScrollingPixels scrollingPixels = new ScrollingPixels();
        scrollingPixels.scrollingPixels(driver, 0, 250);
        loginPage.getBtnLogin().click();

    }

    public void getMyAccountPage() {
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getDdUser()));
        myAccountPage.getDdUser().click();
        myAccountPage.getBtnOpenMyAccountPage().click();
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getBtnDeleteAccount()));
        MatcherAssert.assertThat(driver.getPageSource().contains(workingEmail), is(true));
    }

    public void deleteAccount() {
        myAccountPage.getBtnDeleteAccount().click();
        deleteAccount.getTxtCurrentPassword().sendKeys(workingPassword);
        ScrollingPixels scrollingPixels = new ScrollingPixels();
        scrollingPixels.scrollingPixels(driver, 0, 250);
        deleteAccount.getBtnDeleteAccountSubmit().click();
    }

    public void checkThatAccWasDeleted() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.getMsgErrorEmail()));
        MatcherAssert.assertThat(loginPage.getMsgErrorEmail().isDisplayed(), is(true));
    }

    public void checkingErrorMessages(String errorMessage) {

        if (workingEmail.equals("null")) {
            wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorEmail()));
            MatcherAssert.assertThat(driver.getPageSource().contains(errorMessage), is(true));
            MatcherAssert.assertThat(errorMessage.equals("Acest câmp nu poate fi gol."), is(true));
        } else {
            if (!workingEmail.contains("@")) {
                wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorEmail()));
                MatcherAssert.assertThat(driver.getPageSource().contains(errorMessage), is(true));
                MatcherAssert.assertThat(errorMessage.equals("Adresa de email introdusă nu este validă."), is(true));
            }
        }
        if (workingPassword.equals("null")) {
            wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorPassword()));
            MatcherAssert.assertThat(driver.getPageSource().contains(errorMessage), is(true));
            MatcherAssert.assertThat(errorMessage.equals("Acest câmp nu poate fi gol."), is(true));
        } else {
            if (workingPassword.equals("PassWithAnotherConfirm")) {
                wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorConfirmPassword()));
                MatcherAssert.assertThat(driver.getPageSource().contains(errorMessage), is(true));
                MatcherAssert.assertThat(errorMessage.equals("Parolele introduse nu coincid."), is(true));
            }
        }
    }

    public void checkingUIRegister(DataTable element) throws IOException {
        List<String> list = element.asList();
        wait.until(ExpectedConditions.visibilityOf(registerPage.getTtlRegister()));
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case ("Register title"):
                    MatcherAssert.assertThat(registerPage.getTtlRegister().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTtlRegister(), driver, Colours.BLUE);
                    break;
                case ("Email field"):
                    MatcherAssert.assertThat(registerPage.getTxtEmail().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTxtEmail(), driver, Colours.RED);
                    break;
                case ("Password field"):
                    MatcherAssert.assertThat(registerPage.getTxtPassword().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTxtPassword(), driver, Colours.GREEN);
                    break;
                case ("Confirm password field"):
                    MatcherAssert.assertThat(registerPage.getTxtConfirmPassword().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTxtConfirmPassword(), driver, Colours.RED);
                    break;
                case ("Register button"):
                    MatcherAssert.assertThat(registerPage.getBtnRegistration().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getBtnRegistration(), driver, Colours.RED);
                    break;
                case ("Login button"):
                    MatcherAssert.assertThat(registerPage.getBtnLoginSwitch().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getBtnLoginSwitch(), driver, Colours.RED);
                    break;
                case ("Login with facebook button"):
                    MatcherAssert.assertThat(registerPage.getBtnFacebookLogin().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getBtnFacebookLogin(), driver, Colours.RED);
                    break;
                case ("Recieve newletter checkbox"):
                    MatcherAssert.assertThat(registerPage.getCbSubscrubing().isDisplayed(), is(true));
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    jse.executeScript("window.scrollBy(0,250)", "");
                    registerPage.getCbSubscrubing().click();
                    borders.drawBorder(registerPage.getCbSubscrubing(), driver, Colours.BLUE);
                    MatcherAssert.assertThat(registerPage.getMsgcbSubscribing().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getMsgcbSubscribing(), driver, Colours.RED);
                    break;
            }
//        System.out.println(i);
        }
    }

    public void checkinUILogin(DataTable elements) {
        List<String> list = elements.asList();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getTtlLogin()));
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case ("Login title"):
                    MatcherAssert.assertThat(loginPage.getTtlLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getTtlLogin(), driver, Colours.GREEN);
                    break;
                case ("Email field"):
                    MatcherAssert.assertThat(loginPage.getTxtEmail().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getTxtEmail(), driver, Colours.RED);
                    break;
                case ("Password field"):
                    MatcherAssert.assertThat(loginPage.getTxtPassword().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getTxtPassword(), driver, Colours.BLUE);
                    break;
                case ("Register button"):
                    MatcherAssert.assertThat(loginPage.getBtnRegisterswitch().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getBtnRegisterswitch(), driver, Colours.RED);
                    break;
                case ("Login button"):
                    MatcherAssert.assertThat(loginPage.getBtnLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getBtnLogin(), driver, Colours.RED);
                    break;
                case ("Login with facebook button"):
                    MatcherAssert.assertThat(loginPage.getBtnFacebookLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getBtnFacebookLogin(), driver, Colours.RED);
                    break;
                case ("Forgot password link"):
                    MatcherAssert.assertThat(loginPage.getLnkForgot().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getLnkForgot(), driver, Colours.BLUE);
                    break;
            }
//        System.out.println(i);
        }
    }

    public void getLoginRegisterPage() {
        driver.get(loginRegisterPage.getLink());
    }

    public void checkingUILoginRegisterPage(DataTable elements) {
        List<String> list = elements.asList();
        wait.until(ExpectedConditions.visibilityOf(loginRegisterPage.getBtnLogin()));
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case ("Login title"):
                    MatcherAssert.assertThat(loginRegisterPage.getTtlLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTtlLogin(), driver, Colours.GREEN);
                    break;
                case ("Register title"):
                    MatcherAssert.assertThat(loginRegisterPage.getTtlRegister().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTtlRegister(), driver, Colours.GREEN);
                    break;
                case ("LoginRegister title"):
                    MatcherAssert.assertThat(loginRegisterPage.getTtlLoginRegister().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTtlLoginRegister(), driver, Colours.GREEN);
                    break;
                case ("Email register field"):
                    MatcherAssert.assertThat(loginRegisterPage.getTxtRegisterEmail().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTxtRegisterEmail(), driver, Colours.RED);
                    break;
                case ("Email login field"):
                    MatcherAssert.assertThat(loginRegisterPage.getTxtLoginEmail().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTxtLoginEmail(), driver, Colours.RED);
                    break;
                case ("Password register field"):
                    MatcherAssert.assertThat(loginRegisterPage.getTxtRegisterPassword().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTxtRegisterPassword(), driver, Colours.RED);
                    break;
                case ("Password login field"):
                    MatcherAssert.assertThat(loginRegisterPage.getTxtLoginPassword().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTxtLoginPassword(), driver, Colours.RED);
                    break;
                case ("Confirm password field"):
                    MatcherAssert.assertThat(loginRegisterPage.getTxtRegisterConfirmPassword().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTxtRegisterConfirmPassword(), driver, Colours.RED);
                    break;
                case ("Forgot Password Link"):
                    MatcherAssert.assertThat(loginRegisterPage.getLinkForgotPassword().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getLinkForgotPassword(), driver, Colours.BLUE);
                    break;
                case ("Facebook login register button"):
                    MatcherAssert.assertThat(loginRegisterPage.getBtnFacebookLoginRegister().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getBtnFacebookLoginRegister(), driver, Colours.RED);
                    break;
                case ("Recieve newletter checkbox"):
                    MatcherAssert.assertThat(loginRegisterPage.getCbSubscribeNewsletter().isDisplayed(), is(true));
                    MatcherAssert.assertThat(loginRegisterPage.getTtlCbSubscribe().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getCbSubscribeNewsletter(), driver, Colours.RED);
                    borders.drawBorder(loginRegisterPage.getTtlCbSubscribe(), driver, Colours.RED);
                    break;
                case ("Register button"):
                    MatcherAssert.assertThat(loginRegisterPage.getBtnRegister().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getBtnRegister(), driver, Colours.RED);
                    break;
                case ("Login button"):
                    MatcherAssert.assertThat(loginRegisterPage.getBtnLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getBtnLogin(), driver, Colours.RED);
                    break;


            }
            System.out.println(i);
        }
    }
}
