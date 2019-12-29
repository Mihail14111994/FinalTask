package stepImplementation;

import driverFactory.DriverFactory;
import io.cucumber.core.api.Scenario;
import org.apache.log4j.Logger;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import stepDefinition.CommonDefinitions;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import static org.hamcrest.CoreMatchers.is;

public class CommonSteps {
    private final static Logger logger = Logger.getLogger(CommonDefinitions.class);
    HomePage homePage = new HomePage();
    RegisterPageModal registerPage = new RegisterPageModal();
    RegisterSteps registerSteps = new RegisterSteps();
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    MyAccountPage myAccountPage = new MyAccountPage();
    LoginPage loginPage = new LoginPage();
    DeleteAccountWindow deleteAccount = new DeleteAccountWindow();
    LoginRegisterPage loginRegisterPage = new LoginRegisterPage();
    SearchPage searchPage = new SearchPage();
    PlacesPage placesPage = new PlacesPage();
    PlacesDetailsPage placesDetailsPage = new PlacesDetailsPage();
    MapPlacesPage mapPlacesPage = new MapPlacesPage();
    OptionsPlacesPage optionsPage = new OptionsPlacesPage();
    TicketsPage ticketsPage = new TicketsPage();
    TicketDetailsPage ticketDetailsPage = new TicketDetailsPage();
    BookingPage bookingPage = new BookingPage();
    EventsPage eventsPage = new EventsPage();
    RegistrationPage registrationPage = new RegistrationPage();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
    Actions actions = new Actions(driver);
    String INFO = "INFORMAȚII";
    String LOGIN = "doina123456@gmail.com";
    String PASSWORD = "147369";
    String TICKETS = "Bilete";
    String EVENTS = "Evenimente";
    int totalPrice = 0;
    String nameOfBookedEvent;
    String categoryName;
    String subcategoryName;
    String randomLegendElementText;
    String workingEmail;
    String workingPassword;
    public String scenario;


    public void beforeScenario(Scenario scenario) {
        logger.info("Scenario: " + scenario.getName());
        this.scenario = scenario.getName();
    }

    public void dataFillInTarget(String data, String target) throws IOException {
        switch (target) {
            case ("Email field in register window"):
//                if(data.contains("@")&& data.substring(data.indexOf("@")).contains("."))
                registerPage.getTxtEmail().sendKeys(data);
                logger.info("In " + target + " was filled " + data);
                MatcherAssert.assertThat(registerPage.getTxtEmail().getText().equals(data), is(true));
                break;
            case ("Password field in register window"):
                if(!data.equals("PassWithAnotherConfirm")){
                registerPage.getTxtPassword().sendKeys(data);
                logger.info("In " + target + " was filled " + data);
                    MatcherAssert.assertThat(registerPage.getTxtPassword().getText().equals(data), is(true));
                }
                else
                {
                    registerPage.getTxtPassword().sendKeys("123123");
                    MatcherAssert.assertThat(registerPage.getTxtPassword().getText().equals("123123"), is(true));
                    logger.info("In " + target + " was filled 123123" );
                }
                break;
            case ("Confirm password field in register window"):
                if(!data.equals("PassWithAnotherConfirm")){
                    registerPage.getTxtConfirmPassword().sendKeys(data);
                    logger.info("In " + target + " was filled " + data);
                    MatcherAssert.assertThat(registerPage.getTxtPassword().getText().equals(data), is(true));
                }
                else
                {
                    registerPage.getTxtConfirmPassword().sendKeys("12312313");
                    logger.info("In " + target + " was filled 123123123" );
                    MatcherAssert.assertThat(registerPage.getTxtPassword().getText().equals("123123123"), is(true));
                }
                break;
            case ("Current password field in delete window"):
                registerSteps.deleteAccount(data);
            default:
                logger.error("Not found Target place");
                break;
        }
    }
    public void clickTarget(String target) throws IOException {
        switch (target) {
            case ("Register button"):
                registerSteps.clickRegisterButton();
                break;
            case ("Login button"):
                registerSteps.clickLoginButton();
                registerSteps.checkThatHomePageIsDisplayed();
                break;
            case ("User drop-down"):
                registerSteps.clickUserDD();
                break;
            case ("My account button"):
                registerSteps.getMyAccountPage();
                break;
            case ("Delete link"):
                registerSteps.clickDeleteAccLink();
                break;
            case ("Delete button"):
                registerSteps.clickDeleteBtn();
                break;
            default:
                logger.error("Not found where click");
                break;
        }
    }
}
