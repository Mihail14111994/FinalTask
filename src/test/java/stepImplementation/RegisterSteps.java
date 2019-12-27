package stepImplementation;

import actionMethods.BorderScreen;
import actionMethods.Scrolling;
import actionMethods.ScrollingPixels;
import enums.Colours;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

import static actionMethods.Click.click;
import static actionMethods.Screenshot.takeScreenshot;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterSteps extends CommonSteps {
    private String screenshotsPath = "target\\screenshots\\registration\\"; //change to your folder
    private Logger logger = Logger.getLogger(RegisterSteps.class);

    public void openRegisterWindow() throws IOException {
        takeScreenshot();
        click(homePage.getBtnOpenRegistration(), screenshotsPath);
        logger.info("Registration window was opened");
        wait.until(ExpectedConditions.visibilityOf(registerPage.getTxtEmail()));

    }

    public void fillDataInEmailPasswordFieldsRegister(String email, String password) throws IOException {
        workingEmail = email;
        workingPassword = password;
        switch (password) {
            case "null": {
                registerPage.getTxtEmail().sendKeys(email);
                logger.info("In email field was filled " + email);
                registerPage.getTxtConfirmPassword().sendKeys("OneTwoThree");
                logger.info("In password field was filled " + password);
                takeScreenshot();
                break;
            }
            case "PassWithAnotherConfirm": {
                registerPage.getTxtEmail().sendKeys(email);
                logger.info("In email field was filled " + email);
                registerPage.getTxtPassword().sendKeys("password");
                logger.info("In password field was filled " + password);
                registerPage.getTxtConfirmPassword().sendKeys("anotherPassword");
                logger.info("In password field was filled another password");
                takeScreenshot();
                break;
            }
            default: {
                if (email.equals("null")) {
                    registerPage.getTxtPassword().sendKeys(password);
                    logger.info("In password field was filled " + password);
                    registerPage.getTxtConfirmPassword().sendKeys(password);
                    logger.info("In confirm password field was filled " + password);
                    takeScreenshot();
                    break;
                } else {
                    registerPage.getTxtEmail().sendKeys(email);
                    logger.info("In email field was filled " + email);
                    registerPage.getTxtPassword().sendKeys(password);
                    logger.info("In password field was filled " + password);
                    registerPage.getTxtConfirmPassword().sendKeys(password);
                    logger.info("In confirm password field was filled " + password);
                    takeScreenshot();
                    break;
                }
            }
        }
    }

    public void clickRegisterButton() throws IOException {
        ScrollingPixels.scrollingPixels(driver, 0, 250);
        click(registerPage.getBtnRegistration(), screenshotsPath);
        logger.info("Register button was clicked ");
    }

    public void checkThatHomePageIsDisplayed() throws IOException {
        if (!driver.getCurrentUrl().equals("fest.md")) {
            driver.get(homePage.getLinkHomePage());
        }
        wait.until(ExpectedConditions.visibilityOf(homePage.getTtlCalendar()));
        logger.info("Home page is displayed ");
        assertThat(homePage.getTtlCalendar().isDisplayed(), is(true));
        takeScreenshot();
    }

    public void makeLogout() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getDdUser()));
        click(myAccountPage.getDdUser(), screenshotsPath);
        logger.info("User drop-down was opened ");
        takeScreenshot();
        click(myAccountPage.getBtnOpenMyAccountPage(), screenshotsPath);
        logger.info("My account button was clicked ");
        takeScreenshot();
        assertThat(driver.getPageSource().contains(workingEmail), is(true));
        takeScreenshot();
        logger.info("My account page was opened ");
        click(myAccountPage.getDdUser(), screenshotsPath);
        logger.info("User drop-down was opened ");
        takeScreenshot();
        click(myAccountPage.getBtnLogout(), screenshotsPath);
        logger.info("Logout button was clicked ");
        wait.until(ExpectedConditions.visibilityOf(homePage.getBtnOpenLogin()));
        takeScreenshot();
    }

    public void checkFailingRegisterWithTheSameCredentials() {
        wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgError()));
        assertThat(registerPage.getMsgError().isDisplayed(), is(true));
        logger.warn("Error message is displayed ");
        logger.warn("REGISTRATION WITH SAME CREDENTIALS IMPOSSIBLE ");
        logger.warn("Account registered in DB system ");
    }

    public void openLoginWindow() throws IOException {
        click(homePage.getBtnOpenLogin(), screenshotsPath);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getTxtEmail()));
        logger.info("Login window is displayed ");
        takeScreenshot();
    }

    public void fillDataInEmailPasswordFieldsLogin(String email, String password) throws IOException {
        workingEmail = email;
        workingPassword = password;
        takeScreenshot();
        loginPage.getTxtEmail().sendKeys(email);
        logger.info("In email field was filled " + email);
        takeScreenshot();
        loginPage.getTxtPassword().sendKeys(password);
        logger.info("In password field was filled " + password);
        takeScreenshot();
    }

    public void clickLoginButton() throws IOException {
        ScrollingPixels.scrollingPixels(driver, 0, 250);
        logger.info("Login button was clicked ");
        logger.info("Login successful ");
        click(loginPage.getBtnLogin(), screenshotsPath);
        takeScreenshot();

    }

    public void getMyAccountPage() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getDdUser()));
        click(myAccountPage.getDdUser(), screenshotsPath);
        logger.info("User drop-down was opened ");
        takeScreenshot();
        click(myAccountPage.getBtnOpenMyAccountPage(), screenshotsPath);
        logger.info("My account button was clicked ");
        takeScreenshot();
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getBtnDeleteAccount()));
        assertThat(driver.getPageSource().contains(workingEmail), is(true));
        takeScreenshot();
        logger.info("My account page was opened ");
    }

    public void deleteAccount() throws IOException {
        click(myAccountPage.getBtnDeleteAccount(), screenshotsPath);
        logger.info("Delete button was clicked ");
        logger.info("Delete window was opened ");
        takeScreenshot();
        deleteAccount.getTxtCurrentPassword().sendKeys(workingPassword);
        logger.info("In current password field filled " + workingPassword);
        takeScreenshot();
        ScrollingPixels.scrollingPixels(driver, 0, 250);
        click(deleteAccount.getBtnDeleteAccountSubmit(), screenshotsPath);
        logger.info("Deleting was confirmed ");
        logger.info("Account was deleted");
        takeScreenshot();
    }

    public void checkThatAccWasDeleted() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(loginPage.getMsgErrorEmail()));
        assertThat(loginPage.getMsgErrorEmail().isDisplayed(), is(true));
        logger.warn("Error message is displayed ");
        logger.warn("Login WITH SAME CREDENTIALS IMPOSSIBLE ");
        logger.warn("Account deleted from DB system ");
        takeScreenshot();
    }

    public void checkingErrorMessages(String errorMessage) throws IOException {

        if (workingEmail.equals("null")) {
            wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorEmail()));
            assertThat(driver.getPageSource().contains(errorMessage), is(true));
            assertThat(errorMessage.equals("Acest câmp nu poate fi gol."), is(true));
            logger.warn("Error message is displayed ");
            logger.warn("Login WITH this data IMPOSSIBLE ");
            takeScreenshot();
        } else {
            if (!workingEmail.contains("@")) {
                wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorEmail()));
                assertThat(driver.getPageSource().contains(errorMessage), is(true));
                assertThat(errorMessage.equals("Adresa de email introdusă nu este validă."), is(true));
                logger.warn("Error message is displayed ");
                logger.warn("Login WITH this data IMPOSSIBLE ");
                takeScreenshot();
            }
        }
        if (workingPassword.equals("null")) {
            wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorPassword()));
            assertThat(driver.getPageSource().contains(errorMessage), is(true));
            assertThat(errorMessage.equals("Acest câmp nu poate fi gol."), is(true));
            logger.warn("Error message is displayed ");
            logger.warn("Login WITH this data IMPOSSIBLE ");
            takeScreenshot();
        } else {
            if (workingPassword.equals("PassWithAnotherConfirm")) {
                wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorConfirmPassword()));
                assertThat(driver.getPageSource().contains(errorMessage), is(true));
                assertThat(errorMessage.equals("Parolele introduse nu coincid."), is(true));
                logger.warn("Error message is displayed ");
                logger.warn("Login WITH this data IMPOSSIBLE ");
                takeScreenshot();
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
                    BorderScreen.safeBorderScreen(registerPage.getTtlRegister(), Colours.GREEN, screenshotsPath);
                    logger.info(list.get(i) + "is displayed ");
                    break;
                case ("Email field"):
                    assertThat(registerPage.getTxtEmail().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(registerPage.getTxtEmail(), Colours.BLUE, screenshotsPath);
                    break;
                case ("Password field"):
                    assertThat(registerPage.getTxtPassword().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(registerPage.getTxtPassword(), Colours.BLUE, screenshotsPath);
                    break;
                case ("Confirm password field"):
                    assertThat(registerPage.getTxtConfirmPassword().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(registerPage.getTxtConfirmPassword(), Colours.BLUE, screenshotsPath);
                    break;
                case ("Register button"):
                    assertThat(registerPage.getBtnRegistration().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(registerPage.getBtnRegistration(), Colours.RED, screenshotsPath);
                    break;
                case ("Login button"):
                    assertThat(registerPage.getBtnLoginSwitch().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(registerPage.getBtnLoginSwitch(), Colours.RED, screenshotsPath);
                    break;
                case ("Login with facebook button"):
                    assertThat(registerPage.getBtnFacebookLogin().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(registerPage.getBtnFacebookLogin(), Colours.RED, screenshotsPath);
                    break;
                case ("Recieve newletter checkbox"):
                    assertThat(registerPage.getCbSubscrubing().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    ScrollingPixels.scrollingPixels(driver, 0, 250);
                    click(registerPage.getCbSubscrubing(), screenshotsPath);
                    assertThat(registerPage.getMsgcbSubscribing().isDisplayed(), is(true));
                    BorderScreen.safeBorderScreen(registerPage.getMsgcbSubscribing(), Colours.RED, screenshotsPath);
                    BorderScreen.safeBorderScreen(registerPage.getCbSubscrubing(), Colours.RED, screenshotsPath);
                    logger.info("Checkbox is displayed");
                    break;
            }

        }
    }

    public void checkinUILogin(DataTable elements) throws IOException {
        List<String> list = elements.asList();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getTtlLogin()));
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case ("Login title"):
                    assertThat(loginPage.getTtlLogin().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(loginPage.getTtlLogin(), Colours.GREEN, screenshotsPath);
                    break;
                case ("Email field"):
                    assertThat(loginPage.getTxtEmail().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(loginPage.getTxtEmail(), Colours.BLUE, screenshotsPath);
                    break;
                case ("Password field"):
                    assertThat(loginPage.getTxtPassword().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(loginPage.getTxtPassword(), Colours.BLUE, screenshotsPath);
                    break;
                case ("Register button"):
                    assertThat(loginPage.getBtnRegisterswitch().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(loginPage.getBtnRegisterswitch(), Colours.RED, screenshotsPath);
                    break;
                case ("Login button"):
                    assertThat(loginPage.getBtnLogin().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(loginPage.getBtnLogin(), Colours.RED, screenshotsPath);
                    break;
                case ("Login with facebook button"):
                    assertThat(loginPage.getBtnFacebookLogin().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(loginPage.getBtnFacebookLogin(), Colours.RED, screenshotsPath);
                    break;
                case ("Forgot password link"):
                    assertThat(loginPage.getLnkForgot().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    BorderScreen.safeBorderScreen(loginPage.getLnkForgot(), Colours.RED, screenshotsPath);
                    break;
            }
        }
    }

    public void getLoginRegisterPage() {
        driver.get(loginRegisterPage.getLink());
        logger.info("Login-register page is displayed ");
    }

    public void checkingUILoginRegisterPage(DataTable elements) throws IOException {
        List<String> list = elements.asList();
        wait.until(ExpectedConditions.visibilityOf(loginRegisterPage.getBtnLogin()));
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case ("Login title"):
                    assertThat(loginRegisterPage.getTtlLogin().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getTtlLogin());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getTtlLogin(), Colours.GREEN, screenshotsPath);
                    break;
                case ("Register title"):
                    assertThat(loginRegisterPage.getTtlRegister().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getTtlRegister());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getTtlRegister(), Colours.GREEN, screenshotsPath);
                    break;
                case ("LoginRegister title"):
                    assertThat(loginRegisterPage.getTtlLoginRegister().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getTtlLoginRegister());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getTtlLoginRegister(), Colours.GREEN, screenshotsPath);
                    break;
                case ("Email register field"):
                    assertThat(loginRegisterPage.getTxtRegisterEmail().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getTxtRegisterEmail());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getTxtRegisterEmail(), Colours.BLUE, screenshotsPath);
                    break;
                case ("Email login field"):
                    assertThat(loginRegisterPage.getTxtLoginEmail().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getTxtLoginEmail());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getTxtLoginEmail(), Colours.BLUE, screenshotsPath);
                    break;
                case ("Password register field"):
                    assertThat(loginRegisterPage.getTxtRegisterPassword().isDisplayed(), is(true));
                    Scrolling.scrollingUntilElement(loginRegisterPage.getTxtRegisterPassword());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getTxtRegisterPassword(), Colours.BLUE, screenshotsPath);
                    break;
                case ("Password login field"):
                    assertThat(loginRegisterPage.getTxtLoginPassword().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getTxtLoginPassword());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getTxtLoginPassword(), Colours.BLUE, screenshotsPath);
                    break;
                case ("Confirm password field"):
                    assertThat(loginRegisterPage.getTxtRegisterConfirmPassword().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getTxtRegisterConfirmPassword());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getTxtRegisterConfirmPassword(), Colours.BLUE, screenshotsPath);
                    break;
                case ("Forgot Password Link"):
                    assertThat(loginRegisterPage.getLinkForgotPassword().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getLinkForgotPassword());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getLinkForgotPassword(), Colours.RED, screenshotsPath);
                    break;
                case ("Facebook login register button"):
                    assertThat(loginRegisterPage.getBtnFacebookLoginRegister().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getBtnFacebookLoginRegister());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getBtnFacebookLoginRegister(), Colours.RED, screenshotsPath);
                    break;
                case ("Recieve newletter checkbox"):
                    assertThat(loginRegisterPage.getCbSubscribeNewsletter().isDisplayed(), is(true));
                    assertThat(loginRegisterPage.getTtlCbSubscribe().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getTtlCbSubscribe());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getCbSubscribeNewsletter(), Colours.RED, screenshotsPath);
                    break;
                case ("Register button"):
                    assertThat(loginRegisterPage.getBtnRegister().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getBtnRegister());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getBtnRegister(), Colours.RED, screenshotsPath);
                    break;
                case ("Login button"):
                    assertThat(loginRegisterPage.getBtnLogin().isDisplayed(), is(true));
                    logger.info(list.get(i) + "is displayed ");
                    Scrolling.scrollingUntilElement(loginRegisterPage.getBtnLogin());
                    BorderScreen.safeBorderScreen(loginRegisterPage.getBtnLogin(), Colours.RED, screenshotsPath);
                    break;
            }
        }
    }
}
