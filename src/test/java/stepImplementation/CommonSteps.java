package stepImplementation;

import driverFactory.DriverFactory;
import io.cucumber.core.api.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import stepDefinition.CommonDefinitions;

import java.time.format.DateTimeFormatter;

public class CommonSteps {
    private final static Logger logger = Logger.getLogger(CommonDefinitions.class);
    HomePage homePage = new HomePage();
    RegisterPageModal registerPage = new RegisterPageModal();
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


    public void beforeScenario (Scenario scenario) {
        logger.info("Scenario: " + scenario.getName());
        this.scenario = scenario.getName();
    }
}
