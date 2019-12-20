package stepImplementation;

import actionMethods.*;
import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static actionMethods.Click.click;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterSteps {
    private HomePage homePage = new HomePage();
    private RegisterPageObject registerPage = new RegisterPageObject();
    private WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30);
    private MyAccountPage myAccountPage = new MyAccountPage();
    private LoginPageObject loginPage = new LoginPageObject();
    private DeleteAccountWindowObject deleteAccount = new DeleteAccountWindowObject();
    private LoginRegisterPageObject loginRegisterPage = new LoginRegisterPageObject();
    //    private Borders borders = new Borders();
    private Screenshot screenshot = new Screenshot();
    private String screenshotsPath = "target\\screenshots\\registration\\"; //change to your folder
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
    private BorderScreen borderScreen = new BorderScreen();
    private ScrollingPixels scrolling = new ScrollingPixels();
    private Scrolling scrollingToElement = new Scrolling();
    Logger logger = Logger.getLogger(RegisterSteps.class);
    private String workingEmail;
    private String workingPassword;


    public void openRegisterWindow() throws IOException {
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
//        homePage.getBtnOpenRegistration().click();
        click(homePage.getBtnOpenRegistration(), screenshotsPath);
        logger.info("Registration window was opened");
        wait.until(ExpectedConditions.visibilityOf(registerPage.getTxtEmail()));
//        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");


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
                screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
                break;
            }
            case "PassWithAnotherConfirm": {
                registerPage.getTxtEmail().sendKeys(email);
                logger.info("In email field was filled " + email);
                registerPage.getTxtPassword().sendKeys("password");
                logger.info("In password field was filled " + password);
                registerPage.getTxtConfirmPassword().sendKeys("anotherPassword");
                logger.info("In password field was filled another password");
                screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
                break;
            }
            default: {
                if (email.equals("null")) {
                    registerPage.getTxtPassword().sendKeys(password);
                    logger.info("In password field was filled " + password);
                    registerPage.getTxtConfirmPassword().sendKeys(password);
                    logger.info("In confirm password field was filled " + password);
                    screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
                    break;
                } else {
                    registerPage.getTxtEmail().sendKeys(email);
                    logger.info("In email field was filled " + email);
                    registerPage.getTxtPassword().sendKeys(password);
                    logger.info("In password field was filled " + password);
                    registerPage.getTxtConfirmPassword().sendKeys(password);
                    logger.info("In confirm password field was filled " + password);
                    screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
                    break;
                }
            }
        }
    }

    public void clickRegisterButton() throws IOException {
        ScrollingPixels scrollingPixels = new ScrollingPixels();
        scrollingPixels.scrollingPixels(driver, 0, 250);
//        registerPage.getBtnRegistration().click();
        click(registerPage.getBtnRegistration(), screenshotsPath);
        logger.info("Register button was clicked ");
//                screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
    }

    public void checkThatHomePageIsDisplayed() throws IOException {
        if (!driver.getCurrentUrl().equals("fest.md")) {
            driver.get(homePage.getLinkHomePage());
        }
        wait.until(ExpectedConditions.visibilityOf(homePage.getTtlCalendar()));
//        System.out.println(homePage.getTtlCalendar().isDisplayed());
        logger.info("Home page is displayed ");
        assertThat(homePage.getTtlCalendar().isDisplayed(), is(true));
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
    }

    public void makeLogout() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getDdUser()));
//        click(myAccountPage.getDdUser());
        myAccountPage.getDdUser().click();
        logger.info("User drop-down was opened ");
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
//        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
//        myAccountPage.getBtnOpenMyAccountPage().click();
        click(myAccountPage.getBtnOpenMyAccountPage(), screenshotsPath);
        logger.info("My account button was clicked ");
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        click(myAccountPage.getBtnOpenMyAccountPage(), screenshotsPath);
//        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        assertThat(driver.getPageSource().contains(workingEmail), is(true));
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        logger.info("My account page was opened ");
//        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
//        myAccountPage.getDdUser().click();
        click(myAccountPage.getDdUser(), screenshotsPath);
        logger.info("User drop-down was opened ");
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        click(myAccountPage.getDdUser(), screenshotsPath);
//        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
//        myAccountPage.getBtnLogout().click();
        click(myAccountPage.getBtnLogout(), screenshotsPath);
        logger.info("Logout button was clicked ");
        click(myAccountPage.getBtnLogout(), screenshotsPath);
        wait.until(ExpectedConditions.visibilityOf(homePage.getBtnOpenLogin()));
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
    }

    public void checkFailingRegisterWithTheSameCredentials() {
        wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgError()));
        assertThat(registerPage.getMsgError().isDisplayed(), is(true));
        logger.warn("Error message is displayed ");
        logger.warn("REGISTRATION WITH SAME CREDENTIALS IMPOSSIBLE ");
        logger.warn("Account registered in DB system ");
    }

    public void openLoginWindow() throws IOException {
//        homePage.getBtnOpenLogin().click();
        click(homePage.getBtnOpenLogin(), screenshotsPath);
        wait.until(ExpectedConditions.visibilityOf(loginPage.getTxtEmail()));
        logger.info("Login window is displayed ");
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
    }

    public void fillDataInEmailPasswordFieldsLogin(String email, String password) throws IOException {
        workingEmail = email;
        workingPassword = password;
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
        loginPage.getTxtEmail().sendKeys(email);
        logger.info("In email field was filled "+email);
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
        loginPage.getTxtPassword().sendKeys(password);
        logger.info("In password field was filled "+password);
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
    }

    public void clickLoginButton() throws IOException {
        ScrollingPixels scrollingPixels = new ScrollingPixels();
        scrollingPixels.scrollingPixels(driver, 0, 250);
//        loginPage.getBtnLogin().click();
        logger.info("Login button was clicked ");
        logger.info("Login successful ");
        click(loginPage.getBtnLogin(), screenshotsPath);
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");

    }

    public void getMyAccountPage() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getDdUser()));
//        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
//        myAccountPage.getDdUser().click();
        click(myAccountPage.getDdUser(), screenshotsPath);
        logger.info("User drop-down was opened ");
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        click(myAccountPage.getDdUser(), screenshotsPath);
//        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
//        myAccountPage.getBtnOpenMyAccountPage().click();
        click(myAccountPage.getBtnOpenMyAccountPage(), screenshotsPath);
        logger.info("My account button was clicked ");
        click(myAccountPage.getBtnOpenMyAccountPage(), screenshotsPath);
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getBtnDeleteAccount()));
        assertThat(driver.getPageSource().contains(workingEmail), is(true));
        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
        logger.info("My account page was opened ");
    }

    public void deleteAccount() throws IOException {
//        screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
//        myAccountPage.getBtnDeleteAccount().click();
        click(myAccountPage.getBtnDeleteAccount(), screenshotsPath);
        logger.info("Delete button was clicked ");
        logger.info("Delete window was opened ");
        click(myAccountPage.getBtnDeleteAccount(), screenshotsPath);
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
        deleteAccount.getTxtCurrentPassword().sendKeys(workingPassword);
        logger.info("In current password field filled "+workingPassword);
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
        ScrollingPixels scrollingPixels = new ScrollingPixels();
        scrollingPixels.scrollingPixels(driver, 0, 250);
//        deleteAccount.getBtnDeleteAccountSubmit().click();
        click(deleteAccount.getBtnDeleteAccountSubmit(), screenshotsPath);
        logger.info("Deleting was confirmed ");
        logger.info("Account was deleted");
        click(deleteAccount.getBtnDeleteAccountSubmit(), screenshotsPath);
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
    }

    public void checkThatAccWasDeleted() throws IOException {
        wait.until(ExpectedConditions.visibilityOf(loginPage.getMsgErrorEmail()));
        assertThat(loginPage.getMsgErrorEmail().isDisplayed(), is(true));
        logger.warn("Error message is displayed ");
        logger.warn("Login WITH SAME CREDENTIALS IMPOSSIBLE ");
        logger.warn("Account deleted from DB system ");
        screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
    }

    public void checkingErrorMessages(String errorMessage) throws IOException {

        if (workingEmail.equals("null")) {
            wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorEmail()));
            assertThat(driver.getPageSource().contains(errorMessage), is(true));
            assertThat(errorMessage.equals("Acest câmp nu poate fi gol."), is(true));
            logger.warn("Error message is displayed ");
            logger.warn("Login WITH this data IMPOSSIBLE ");
            screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
        } else {
            if (!workingEmail.contains("@")) {
                wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorEmail()));
                assertThat(driver.getPageSource().contains(errorMessage), is(true));
                assertThat(errorMessage.equals("Adresa de email introdusă nu este validă."), is(true));
                logger.warn("Error message is displayed ");
                logger.warn("Login WITH this data IMPOSSIBLE ");
                screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
            }
        }
        if (workingPassword.equals("null")) {
            wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorPassword()));
            assertThat(driver.getPageSource().contains(errorMessage), is(true));
            assertThat(errorMessage.equals("Acest câmp nu poate fi gol."), is(true));
            logger.warn("Error message is displayed ");
            logger.warn("Login WITH this data IMPOSSIBLE ");
            screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
        } else {
            if (workingPassword.equals("PassWithAnotherConfirm")) {
                wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorConfirmPassword()));
                assertThat(driver.getPageSource().contains(errorMessage), is(true));
                assertThat(errorMessage.equals("Parolele introduse nu coincid."), is(true));
                logger.warn("Error message is displayed ");
                logger.warn("Login WITH this data IMPOSSIBLE ");
                screenshot.takeScreenshot(driver, screenshotsPath + LocalDateTime.now().format(formatter) + ".jpg");
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
                    borderScreen.safeBorderScreen(registerPage.getTtlRegister(), Colours.GREEN, screenshotsPath);
                    logger.info(list.get(i)+"is displayed ");
//                    borders.drawBorder(registerPage.getTtlRegister(), driver, Colours.BLUE);
//                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
//                    borders.undrawBorder(registerPage.getTtlRegister(), driver);
                    break;
                case ("Email field"):
                    assertThat(registerPage.getTxtEmail().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
//                    borders.drawBorder(registerPage.getTxtEmail(), driver, Colours.RED);
//                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
//                    borders.undrawBorder(registerPage.getTxtEmail(), driver);
                    borderScreen.safeBorderScreen(registerPage.getTxtEmail(), Colours.BLUE, screenshotsPath);
                    break;
                case ("Password field"):
                    assertThat(registerPage.getTxtPassword().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(registerPage.getTxtPassword(), Colours.BLUE, screenshotsPath);
//                    borders.drawBorder(registerPage.getTxtPassword(), driver, Colours.GREEN);
//                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                case ("Confirm password field"):
                    assertThat(registerPage.getTxtConfirmPassword().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(registerPage.getTxtConfirmPassword(), Colours.BLUE, screenshotsPath);
//                    borders.drawBorder(registerPage.getTxtConfirmPassword(), driver, Colours.RED);
//                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                case ("Register button"):
                    assertThat(registerPage.getBtnRegistration().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(registerPage.getBtnRegistration(), Colours.RED, screenshotsPath);
//                    borders.drawBorder(registerPage.getBtnRegistration(), driver, Colours.RED);
//                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                case ("Login button"):
                    assertThat(registerPage.getBtnLoginSwitch().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(registerPage.getBtnLoginSwitch(), Colours.RED, screenshotsPath);
//                    borders.drawBorder(registerPage.getBtnLoginSwitch(), driver, Colours.RED);
//                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                case ("Login with facebook button"):
                    assertThat(registerPage.getBtnFacebookLogin().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(registerPage.getBtnFacebookLogin(), Colours.RED, screenshotsPath);
//                    borders.drawBorder(registerPage.getBtnFacebookLogin(), driver, Colours.RED);
//                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    break;
                case ("Recieve newletter checkbox"):
                    assertThat(registerPage.getCbSubscrubing().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
//                    JavascriptExecutor jse = (JavascriptExecutor) driver;
//                    jse.executeScript("window.scrollBy(0,250)", "");
                    scrolling.scrollingPixels(driver, 0, 250);
//                    registerPage.getCbSubscrubing().click();
                    click(registerPage.getCbSubscrubing(), screenshotsPath);
//                    borders.drawBorder(registerPage.getCbSubscrubing(), driver, Colours.BLUE);
                    assertThat(registerPage.getMsgcbSubscribing().isDisplayed(), is(true));
//                    borders.drawBorder(registerPage.getMsgcbSubscribing(), driver, Colours.RED);
//                    screenshot.takeScreenshot(driver,screenshotsPath+LocalDateTime.now().format(formatter)+".jpg");
                    borderScreen.safeBorderScreen(registerPage.getMsgcbSubscribing(), Colours.RED, screenshotsPath);
                    borderScreen.safeBorderScreen(registerPage.getCbSubscrubing(), Colours.RED, screenshotsPath);
                    logger.info("Checkbox is displayed");
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

    public void checkinUILogin(DataTable elements) throws IOException {
        List<String> list = elements.asList();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getTtlLogin()));
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)) {
                case ("Login title"):
                    assertThat(loginPage.getTtlLogin().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(loginPage.getTtlLogin(), Colours.GREEN, screenshotsPath);

//                    borders.drawBorder(loginPage.getTtlLogin(), driver, Colours.GREEN);
                    break;
                case ("Email field"):
                    assertThat(loginPage.getTxtEmail().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(loginPage.getTxtEmail(), Colours.BLUE, screenshotsPath);
//                    borders.drawBorder(loginPage.getTxtEmail(), driver, Colours.RED);
                    break;
                case ("Password field"):
                    assertThat(loginPage.getTxtPassword().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(loginPage.getTxtPassword(), Colours.BLUE, screenshotsPath);
//                    borders.drawBorder(loginPage.getTxtPassword(), driver, Colours.BLUE);
                    break;
                case ("Register button"):
                    assertThat(loginPage.getBtnRegisterswitch().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(loginPage.getBtnRegisterswitch(), Colours.RED, screenshotsPath);
//                    borders.drawBorder(loginPage.getBtnRegisterswitch(), driver, Colours.RED);
                    break;
                case ("Login button"):
                    assertThat(loginPage.getBtnLogin().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(loginPage.getBtnLogin(), Colours.RED, screenshotsPath);
//                    borders.drawBorder(loginPage.getBtnLogin(), driver, Colours.RED);
                    break;
                case ("Login with facebook button"):
                    assertThat(loginPage.getBtnFacebookLogin().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(loginPage.getBtnFacebookLogin(), Colours.RED, screenshotsPath);
//                    borders.drawBorder(loginPage.getBtnFacebookLogin(), driver, Colours.RED);
                    break;
                case ("Forgot password link"):
                    assertThat(loginPage.getLnkForgot().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    borderScreen.safeBorderScreen(loginPage.getLnkForgot(), Colours.RED, screenshotsPath);
//                    borders.drawBorder(loginPage.getLnkForgot(), driver, Colours.BLUE);
                    break;
            }
//        System.out.println(i);
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
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getTtlLogin());
                    borderScreen.safeBorderScreen(loginRegisterPage.getTtlLogin(), Colours.GREEN, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getTtlLogin(), driver, Colours.GREEN);
                    break;
                case ("Register title"):
                    assertThat(loginRegisterPage.getTtlRegister().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getTtlRegister());
                    borderScreen.safeBorderScreen(loginRegisterPage.getTtlRegister(), Colours.GREEN, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getTtlRegister(), driver, Colours.GREEN);
                    break;
                case ("LoginRegister title"):
                    assertThat(loginRegisterPage.getTtlLoginRegister().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getTtlLoginRegister());
                    borderScreen.safeBorderScreen(loginRegisterPage.getTtlLoginRegister(), Colours.GREEN, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getTtlLoginRegister(), driver, Colours.GREEN);
                    break;
                case ("Email register field"):
                    assertThat(loginRegisterPage.getTxtRegisterEmail().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getTxtRegisterEmail());
                    borderScreen.safeBorderScreen(loginRegisterPage.getTxtRegisterEmail(), Colours.BLUE, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getTxtRegisterEmail(), driver, Colours.RED);
                    break;
                case ("Email login field"):
                    assertThat(loginRegisterPage.getTxtLoginEmail().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getTxtLoginEmail());
                    borderScreen.safeBorderScreen(loginRegisterPage.getTxtLoginEmail(), Colours.BLUE, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getTxtLoginEmail(), driver, Colours.RED);
                    break;
                case ("Password register field"):
                    assertThat(loginRegisterPage.getTxtRegisterPassword().isDisplayed(), is(true));
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getTxtRegisterPassword());
                    borderScreen.safeBorderScreen(loginRegisterPage.getTxtRegisterPassword(), Colours.BLUE, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getTxtRegisterPassword(), driver, Colours.RED);
                    break;
                case ("Password login field"):
                    assertThat(loginRegisterPage.getTxtLoginPassword().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getTxtLoginPassword());
                    borderScreen.safeBorderScreen(loginRegisterPage.getTxtLoginPassword(), Colours.BLUE, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getTxtLoginPassword(), driver, Colours.RED);
                    break;
                case ("Confirm password field"):
                    assertThat(loginRegisterPage.getTxtRegisterConfirmPassword().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getTxtRegisterConfirmPassword());
                    borderScreen.safeBorderScreen(loginRegisterPage.getTxtRegisterConfirmPassword(), Colours.BLUE, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getTxtRegisterConfirmPassword(), driver, Colours.RED);
                    break;
                case ("Forgot Password Link"):
                    assertThat(loginRegisterPage.getLinkForgotPassword().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getLinkForgotPassword());
                    borderScreen.safeBorderScreen(loginRegisterPage.getLinkForgotPassword(), Colours.RED, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getLinkForgotPassword(), driver, Colours.BLUE);
                    break;
                case ("Facebook login register button"):
                    assertThat(loginRegisterPage.getBtnFacebookLoginRegister().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getBtnFacebookLoginRegister());
                    borderScreen.safeBorderScreen(loginRegisterPage.getBtnFacebookLoginRegister(), Colours.RED, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getBtnFacebookLoginRegister(), driver, Colours.RED);
                    break;
                case ("Recieve newletter checkbox"):
                    assertThat(loginRegisterPage.getCbSubscribeNewsletter().isDisplayed(), is(true));
                    assertThat(loginRegisterPage.getTtlCbSubscribe().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getTtlCbSubscribe());
//                    borders.drawBorder(loginRegisterPage.getCbSubscribeNewsletter(), driver, Colours.RED);
//                    borders.drawBorder(loginRegisterPage.getTtlCbSubscribe(), driver, Colours.RED);
                    borderScreen.safeBorderScreen(loginRegisterPage.getCbSubscribeNewsletter(), Colours.RED, screenshotsPath);
                    borderScreen.safeBorderScreen(loginRegisterPage.getTtlCbSubscribe(), Colours.RED, screenshotsPath);
                    break;
                case ("Register button"):
                    assertThat(loginRegisterPage.getBtnRegister().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getBtnRegister());
                    borderScreen.safeBorderScreen(loginRegisterPage.getBtnRegister(), Colours.RED, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getBtnRegister(), driver, Colours.RED);
                    break;
                case ("Login button"):
                    assertThat(loginRegisterPage.getBtnLogin().isDisplayed(), is(true));
                    logger.info(list.get(i)+"is displayed ");
                    scrollingToElement.scrollingUntilElement(loginRegisterPage.getBtnLogin());
                    borderScreen.safeBorderScreen(loginRegisterPage.getBtnLogin(), Colours.RED, screenshotsPath);
//                    borders.drawBorder(loginRegisterPage.getBtnLogin(), driver, Colours.RED);
                    break;


            }
        }
    }
}
