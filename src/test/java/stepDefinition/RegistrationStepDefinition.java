package stepDefinition;

import actionMethods.Borders;
import actionMethods.Colours;
import driverFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class RegistrationStepDefinition {
    DriverFactory driverFactory = new DriverFactory();
//    private WebDriver driver = driverFactory.newDriver();
    private WebDriver driver = DriverFactory.getDriver();
    MyAccountPage myAccountPage= new MyAccountPage();
    HomePage homePage= new HomePage();
    RegisterPageObject registerPage = new RegisterPageObject();
    LoginPageObject loginPage= new LoginPageObject();
    DeleteAccountWindowObject deleteAccount = new DeleteAccountWindowObject();
    Borders borders = new Borders();
    public String workingEmail;
    public String workingPassword;
    WebDriverWait wait = new WebDriverWait(driver,30);

    @Given("Fest.md page is displayed")
    public void festMdPageIsDisplayed() {
        driver.get(homePage.getLinkHomePage());
        driver.manage().window().maximize();
    }

    @When("Register page is displayed")
    public void registerPageIsDisplayed() throws InterruptedException {
        homePage.getBtnOpenRegistration().click();
    }


    @When("Submit (.*), (.*) and confirm password in registration form")
    public void submitEmailPasswordAndConfirmPasswordInRegistrationForm(String email, String password) throws InterruptedException {
        workingEmail=email;
        workingPassword=password;
        Thread.sleep(1000);
        switch (password){
            case "null":
            {
                registerPage.getTxtEmail().sendKeys(email);
                registerPage.getTxtConfirmPassword().sendKeys("OneTwoThree");
                break;
            }
            case "PassWithAnotherConfirm":
            {
                registerPage.getTxtEmail().sendKeys(email);
                registerPage.getTxtPassword().sendKeys("password");
                registerPage.getTxtConfirmPassword().sendKeys("anotherPassword");
                break;
            }
            default:
            {
                if(workingEmail.equals("null"))
                {
                    registerPage.getTxtPassword().sendKeys(password);
                    registerPage.getTxtConfirmPassword().sendKeys(password);
                    break;
                }
                else {
                    registerPage.getTxtEmail().sendKeys(email);
                    registerPage.getTxtPassword().sendKeys(password);
                    registerPage.getTxtConfirmPassword().sendKeys(password);
                    break;
                }
            }
        }
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        registerPage.getBtnRegistration().click();
    }

    @Then("Home page is displayed")
    public void homePageIsDisplayed() {
        driver.get(homePage.getLinkHomePage());
        wait.until(ExpectedConditions.visibilityOf(homePage.getTtlCalendar()));
        System.out.println(homePage.getTtlCalendar().isDisplayed());
        MatcherAssert.assertThat(homePage.getTtlCalendar().isDisplayed(), is(true));
    }

    @And("Register is successful")
    public void registerIsSuccessful() {
//        driver.get("https://www.fest.md/ro/user/account");
        myAccountPage.getDdUser().click();
        myAccountPage.getBtnOpenMyAccountPage().click();
        MatcherAssert.assertThat(driver.getPageSource().contains(workingEmail), is(true));
        myAccountPage.getDdUser().click();
        myAccountPage.getBtnLogout().click();
        wait.until(ExpectedConditions.visibilityOf(homePage.getBtnOpenLogin()));
        homePage.getBtnOpenRegistration().click();
        wait.until(ExpectedConditions.visibilityOf(registerPage.getTxtEmail()));
        registerPage.getTxtEmail().sendKeys(workingEmail);
        registerPage.getTxtPassword().sendKeys(workingPassword);
        registerPage.getTxtConfirmPassword().sendKeys(workingPassword);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        registerPage.getBtnRegistration().click();
        wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgError()));
        System.out.println(registerPage.getMsgError().isDisplayed());
        MatcherAssert.assertThat(registerPage.getMsgError().isDisplayed(), is(true));
    }

    @When("Account with (.*) and (.*) was deleted")
    public void accountWasDeleted(String email, String password) {
        workingEmail=email;
        workingPassword=password;
//        System.out.println(workingEmail);
//        System.out.println(workingPassword);
        homePage.getBtnOpenLogin().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getTxtEmail()));
        loginPage.getTxtEmail().sendKeys(workingEmail);
        loginPage.getTxtPassword().sendKeys(workingPassword);
        driver.getPageSource();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        loginPage.getBtnLogin().click();
        wait.until(ExpectedConditions.visibilityOf(myAccountPage.getDdUser()));
        myAccountPage.getDdUser().click();
        myAccountPage.getBtnOpenMyAccountPage().click();
        MatcherAssert.assertThat(driver.getPageSource().contains(workingEmail), is(true));
        myAccountPage.getBtnDeleteAccount().click();
        deleteAccount.getTxtCurrentPassword().sendKeys(workingPassword);
        jse.executeScript("window.scrollBy(0,250)", "");
        deleteAccount.getBtnDeleteAccountSubmit().click();
    }

    @And("Checked that account was deleted")
    public void checkedThatAccountWasDeleted() {
        homePage.getBtnOpenLogin().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getTxtEmail()));
        loginPage.getTxtEmail().sendKeys(workingEmail);
        loginPage.getTxtPassword().sendKeys(workingPassword);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        loginPage.getBtnLogin().click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getMsgErrorEmail()));
        MatcherAssert.assertThat(loginPage.getMsgErrorEmail().isDisplayed(), is(true));
    }

    @Then("Registration fails with (.*) message")
    public void registrationFailsWithErrorMessage(String errorMessage) {

        if(workingEmail.equals("null"))
        {
            wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorEmail()));
            MatcherAssert.assertThat(driver.getPageSource().contains(errorMessage), is(true));
            MatcherAssert.assertThat(errorMessage.equals("Acest câmp nu poate fi gol."),is(true));
        }
        else
        {
            if(!workingEmail.contains("@"))
            {
                wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorEmail()));
                MatcherAssert.assertThat(driver.getPageSource().contains(errorMessage), is(true));
                MatcherAssert.assertThat(errorMessage.equals("Adresa de email introdusă nu este validă."),is(true));
            }
        }
        if(workingPassword.equals("null"))
        {
            wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorPassword()));
            MatcherAssert.assertThat(driver.getPageSource().contains(errorMessage), is(true));
            MatcherAssert.assertThat(errorMessage.equals("Acest câmp nu poate fi gol."),is(true));
        }
        else
        {
            if (workingPassword.equals("PassWithAnotherConfirm"))
            {
                wait.until(ExpectedConditions.visibilityOf(registerPage.getMsgErrorConfirmPassword()));
                MatcherAssert.assertThat(driver.getPageSource().contains(errorMessage), is(true));
                MatcherAssert.assertThat(errorMessage.equals("Parolele introduse nu coincid."),is(true));
            }
        }
    }
    @Then("the following elements are visible on Register page")
    public void theFollowingElementsAreVisible(DataTable element) {
        List<String> list = element.asList();
        wait.until(ExpectedConditions.visibilityOf(registerPage.getTtlRegister()));
        for(int i=0; i< list.size();i++) {
            switch (list.get(i)) {
                case ("Register title"):
                    MatcherAssert.assertThat(registerPage.getTtlRegister().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTtlRegister(),driver, Colours.BLUE);
                    break;
                case ("Email field"):
                    MatcherAssert.assertThat(registerPage.getTxtEmail().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTxtEmail(),driver, Colours.RED);
                    break;
                case ("Password field"):
                    MatcherAssert.assertThat(registerPage.getTxtPassword().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTxtPassword(),driver, Colours.GREEN);
                    break;
                case ("Confirm password field"):
                    MatcherAssert.assertThat(registerPage.getTxtConfirmPassword().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getTxtConfirmPassword(),driver, Colours.RED);
                    break;
                case ("Register button"):
                    MatcherAssert.assertThat(registerPage.getBtnRegistration().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getBtnRegistration(),driver, Colours.RED);
                    break;
                case ("Login button"):
                    MatcherAssert.assertThat(registerPage.getBtnLoginSwitch().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getBtnLoginSwitch(),driver, Colours.RED);
                    break;
                case ("Login with facebook button"):
                    MatcherAssert.assertThat(registerPage.getBtnFacebookLogin().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getBtnFacebookLogin(),driver, Colours.RED);
                    break;
                case ("Recieve newletter checkbox"):
                    MatcherAssert.assertThat(registerPage.getCbSubscrubing().isDisplayed(), is(true));
                    JavascriptExecutor jse = (JavascriptExecutor)driver;
                    jse.executeScript("window.scrollBy(0,250)", "");
                    registerPage.getCbSubscrubing().click();
                    borders.drawBorder(registerPage.getCbSubscrubing(),driver, Colours.BLUE);
                    MatcherAssert.assertThat(registerPage.getMsgcbSubscribing().isDisplayed(), is(true));
                    borders.drawBorder(registerPage.getMsgcbSubscribing(),driver, Colours.RED);
                    break;
            }
            System.out.println(i);
        }
    }

    @When("Login page is displayed")
    public void loginPageIsDisplayed() {
        homePage.getBtnOpenLogin().click();
    }

    @Then("the following elements are visible on Login page")
    public void theFollowingElementsAreVisibleOnLoginPage(DataTable elements) {
        List<String> list = elements.asList();
        wait.until(ExpectedConditions.visibilityOf(loginPage.getTtlLogin()));
        for(int i=0; i< list.size();i++) {
            switch (list.get(i)) {
                case ("Login title"):
                    MatcherAssert.assertThat(loginPage.getTtlLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getTtlLogin(),driver, Colours.GREEN);
                    break;
                case ("Email field"):
                    MatcherAssert.assertThat(loginPage.getTxtEmail().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getTxtEmail(),driver, Colours.RED);
                    break;
                case ("Password field"):
                    MatcherAssert.assertThat(loginPage.getTxtPassword().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getTxtPassword(),driver, Colours.BLUE);
                    break;
                case ("Register button"):
                    MatcherAssert.assertThat(loginPage.getBtnRegisterswitch().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getBtnRegisterswitch(),driver, Colours.RED);
                    break;
                case ("Login button"):
                    MatcherAssert.assertThat(loginPage.getBtnLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getBtnLogin(),driver, Colours.RED);
                    break;
                case ("Login with facebook button"):
                    MatcherAssert.assertThat(loginPage.getBtnFacebookLogin().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getBtnFacebookLogin(),driver, Colours.RED);
                    break;
                case ("Forgot password link"):
                    MatcherAssert.assertThat(loginPage.getLnkForgot().isDisplayed(), is(true));
                    borders.drawBorder(loginPage.getLnkForgot(),driver, Colours.BLUE);
                    break;
            }
            System.out.println(i);
        }
    }
    @After
    public void teardown() {
        driver.quit();
    }

}