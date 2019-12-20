package stepImplementation;

import actionMethods.*;
import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterSteps {
    HomePage homePage = new HomePage();
    RegisterPageObject registerPage = new RegisterPageObject();
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    private MyAccountPage myAccountPage = new MyAccountPage();
    LoginPageObject loginPage = new LoginPageObject();
    DeleteAccountWindowObject deleteAccount = new DeleteAccountWindowObject();
    LoginRegisterPageObject loginRegisterPage = new LoginRegisterPageObject();
    Borders borders = new Borders();
    Screenshot screenshot = new Screenshot();
    String screenshotsPath = "target\\screenshots\\registration\\"; //change to your folder
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");


    String workingEmail;
    String workingPassword;
//    String nameScenario=findingFolder.findingFolder(screenshotsPath);

//    public void  getScenario(String scenario){
//        nameScenario = scenario;
//    }


    public void openRegisterWindow() throws IOException {

        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        homePage.getBtnOpenRegistration().click();
        wait.until(ExpectedConditions.visibilityOf(registerPage.getTxtEmail()));
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");


    }

    public void fillDataInEmailPasswordFieldsRegister(String email, String password) throws IOException {
        workingEmail = email;
        workingPassword = password;
        switch (password) {
            case "null": {
                registerPage.getTxtEmail().sendKeys(email);
                registerPage.getTxtConfirmPassword().sendKeys("OneTwoThree");
                screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                break;
            }
            case "PassWithAnotherConfirm": {
                registerPage.getTxtEmail().sendKeys(email);
                registerPage.getTxtPassword().sendKeys("password");
                registerPage.getTxtConfirmPassword().sendKeys("anotherPassword");
                screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                break;
            }
            default: {
                if (email.equals("null")) {
                    registerPage.getTxtPassword().sendKeys(password);
                    registerPage.getTxtConfirmPassword().sendKeys(password);
                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                } else {
                    registerPage.getTxtEmail().sendKeys(email);
                    registerPage.getTxtPassword().sendKeys(password);
                    registerPage.getTxtConfirmPassword().sendKeys(password);
                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                }
            }
        }
    }

    public void clickRegisterButton() throws IOException {
        ScrollingPixels scrollingPixels = new ScrollingPixels();
        scrollingPixels.scrollingPixels(driver, 0, 250);
        registerPage.getBtnRegistration().click();
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
    }

    public void checkThatHomePageIsDisplayed() throws IOException {
        if (!driver.getCurrentUrl().equals("fest.md")) {
            driver.get(homePage.getLinkHomePage());
        }
        wait.until(ExpectedConditions.visibilityOf(homePage.getTtlCalendar()));
        System.out.println(homePage.getTtlCalendar().isDisplayed());
        assertThat(homePage.getTtlCalendar().isDisplayed(), is(true));
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
    }

    public void makeLogout() throws IOException {
        myAccountPage.getDdUser().click();
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        myAccountPage.getBtnOpenMyAccountPage().click();
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        assertThat(driver.getPageSource().contains(workingEmail), is(true));
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        myAccountPage.getDdUser().click();
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        myAccountPage.getBtnLogout().click();
        wait.until(ExpectedConditions.visibilityOf(homePage.getBtnOpenLogin()));
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
    }

    public void checkFailingRegisterWithTheSameCredentials() {
        wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgError()));
        assertThat(registerPage.getMsgError().isDisplayed(), is(true));
    }

    public void openLoginWindow() throws IOException {
        homePage.getBtnOpenLogin().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getTxtEmail()));
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
    }

    public void fillDataInEmailPasswordFieldsLogin(String email, String password) throws IOException {
        workingEmail=email;
        workingPassword=password;
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
        loginPage.getTxtEmail().sendKeys(email);
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        loginPage.getTxtPassword().sendKeys(password);
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
    }

    public void clickLoginButton() throws IOException {
        ScrollingPixels scrollingPixels = new ScrollingPixels();
        scrollingPixels.scrollingPixels(driver, 0, 250);
        loginPage.getBtnLogin().click();
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");

    }

    public void getMyAccountPage() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getDdUser()));
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        myAccountPage.getDdUser().click();
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        myAccountPage.getBtnOpenMyAccountPage().click();
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getBtnDeleteAccount()));
        assertThat(driver.getPageSource().contains(workingEmail), is(true));
    }

    public void deleteAccount() throws IOException {
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        myAccountPage.getBtnDeleteAccount().click();
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        deleteAccount.getTxtCurrentPassword().sendKeys(workingPassword);
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        ScrollingPixels scrollingPixels = new ScrollingPixels();
        scrollingPixels.scrollingPixels(driver, 0, 250);
        deleteAccount.getBtnDeleteAccountSubmit().click();
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
    }

    public void checkThatAccWasDeleted() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(loginPage.getMsgErrorEmail()));
        assertThat(loginPage.getMsgErrorEmail().isDisplayed(), is(true));
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
    }

    public void checkingErrorMessages(String errorMessage) throws IOException {

        if (workingEmail.equals("null")) {
            wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorEmail()));
            assertThat(driver.getPageSource().contains(errorMessage), is(true));
            assertThat(errorMessage.equals("Acest câmp nu poate fi gol."), is(true));
            screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        } else {
            if (!workingEmail.contains("@")) {
                wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorEmail()));
                assertThat(driver.getPageSource().contains(errorMessage), is(true));
                assertThat(errorMessage.equals("Adresa de email introdusă nu este validă."), is(true));
                screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
            }
        }
        if (workingPassword.equals("null")) {
            wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorPassword()));
            assertThat(driver.getPageSource().contains(errorMessage), is(true));
            assertThat(errorMessage.equals("Acest câmp nu poate fi gol."), is(true));
            screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        } else {
            if (workingPassword.equals("PassWithAnotherConfirm")) {
                wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorConfirmPassword()));
                assertThat(driver.getPageSource().contains(errorMessage), is(true));
                assertThat(errorMessage.equals("Parolele introduse nu coincid."), is(true));
                screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
            }
        }
    }

    public void checkingUIRegister(DataTable element) throws IOException {
        List<String> list = element.asList();
        wait.until(ExpectedConditions.visibilityOf(registerPage.getTtlRegister()));
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case ("Register title"):
                    assertThat(registerPage.getTtlRegister().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTtlRegister(), driver, Colours.BLUE);
                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    borders.undrawBorder(registerPage.getTtlRegister(), driver);
                    break;
                case ("Email field"):
                    assertThat(registerPage.getTxtEmail().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTxtEmail(), driver, Colours.RED);
                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    borders.undrawBorder(registerPage.getTxtEmail(), driver);
                    break;
                case ("Password field"):
                    assertThat(registerPage.getTxtPassword().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTxtPassword(), driver, Colours.GREEN);
                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                case ("Confirm password field"):
                    assertThat(registerPage.getTxtConfirmPassword().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTxtConfirmPassword(), driver, Colours.RED);
                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                case ("Register button"):
                    assertThat(registerPage.getBtnRegistration().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getBtnRegistration(), driver, Colours.RED);
                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                case ("Login button"):
                    assertThat(registerPage.getBtnLoginSwitch().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getBtnLoginSwitch(), driver, Colours.RED);
                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                case ("Login with facebook button"):
                    assertThat(registerPage.getBtnFacebookLogin().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getBtnFacebookLogin(), driver, Colours.RED);
                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                case ("Recieve newletter checkbox"):
                    assertThat(registerPage.getCbSubscrubing().isDisplayed(), is(true));
                    JavascriptExecutor jse = (JavascriptExecutor) driver;
                    jse.executeScript("window.scrollBy(0,250)", "");
                    registerPage.getCbSubscrubing().click();
                    borders.drawBorder(registerPage.getCbSubscrubing(), driver, Colours.BLUE);
                    assertThat(registerPage.getMsgcbSubscribing().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getMsgcbSubscribing(), driver, Colours.RED);
                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
            }

//            LocalDateTime dateTime = LocalDateTime.now();
//            String formattedDateTime = dateTime.format(formatter);
//            String pathToFile=screenshotsPath+formattedDateTime;
//            System.out.println(screenshotsPath);
//            screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
//        System.out.println(i);
        }
    }

    public void checkinUILogin(DataTable elements) {
        List<String> list = elements.asList();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getTtlLogin()));
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case ("Login title"):
                    assertThat(loginPage.getTtlLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getTtlLogin(), driver, Colours.GREEN);
                    break;
                case ("Email field"):
                    assertThat(loginPage.getTxtEmail().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getTxtEmail(), driver, Colours.RED);
                    break;
                case ("Password field"):
                    assertThat(loginPage.getTxtPassword().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getTxtPassword(), driver, Colours.BLUE);
                    break;
                case ("Register button"):
                    assertThat(loginPage.getBtnRegisterswitch().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getBtnRegisterswitch(), driver, Colours.RED);
                    break;
                case ("Login button"):
                    assertThat(loginPage.getBtnLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getBtnLogin(), driver, Colours.RED);
                    break;
                case ("Login with facebook button"):
                    assertThat(loginPage.getBtnFacebookLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getBtnFacebookLogin(), driver, Colours.RED);
                    break;
                case ("Forgot password link"):
                    assertThat(loginPage.getLnkForgot().isDisplayed(), is(true));
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
                    assertThat(loginRegisterPage.getTtlLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTtlLogin(), driver, Colours.GREEN);
                    break;
                case ("Register title"):
                    assertThat(loginRegisterPage.getTtlRegister().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTtlRegister(), driver, Colours.GREEN);
                    break;
                case ("LoginRegister title"):
                    assertThat(loginRegisterPage.getTtlLoginRegister().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTtlLoginRegister(), driver, Colours.GREEN);
                    break;
                case ("Email register field"):
                    assertThat(loginRegisterPage.getTxtRegisterEmail().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTxtRegisterEmail(), driver, Colours.RED);
                    break;
                case ("Email login field"):
                    assertThat(loginRegisterPage.getTxtLoginEmail().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTxtLoginEmail(), driver, Colours.RED);
                    break;
                case ("Password register field"):
                    assertThat(loginRegisterPage.getTxtRegisterPassword().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTxtRegisterPassword(), driver, Colours.RED);
                    break;
                case ("Password login field"):
                    assertThat(loginRegisterPage.getTxtLoginPassword().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTxtLoginPassword(), driver, Colours.RED);
                    break;
                case ("Confirm password field"):
                    assertThat(loginRegisterPage.getTxtRegisterConfirmPassword().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getTxtRegisterConfirmPassword(), driver, Colours.RED);
                    break;
                case ("Forgot Password Link"):
                    assertThat(loginRegisterPage.getLinkForgotPassword().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getLinkForgotPassword(), driver, Colours.BLUE);
                    break;
                case ("Facebook login register button"):
                    assertThat(loginRegisterPage.getBtnFacebookLoginRegister().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getBtnFacebookLoginRegister(), driver, Colours.RED);
                    break;
                case ("Recieve newletter checkbox"):
                    assertThat(loginRegisterPage.getCbSubscribeNewsletter().isDisplayed(), is(true));
                    assertThat(loginRegisterPage.getTtlCbSubscribe().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getCbSubscribeNewsletter(), driver, Colours.RED);
                    borders.drawBorder(loginRegisterPage.getTtlCbSubscribe(), driver, Colours.RED);
                    break;
                case ("Register button"):
                    assertThat(loginRegisterPage.getBtnRegister().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getBtnRegister(), driver, Colours.RED);
                    break;
                case ("Login button"):
                    assertThat(loginRegisterPage.getBtnLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginRegisterPage.getBtnLogin(), driver, Colours.RED);
                    break;


            }
            System.out.println(i);
        }
    }
}
