package stepDefinition;

import driverFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.LoginRegistrationPage;
import pageObjects.TicketsPage;
import stepImplementation.TicketsSteps;

public class TicketsDefinitions {
    private static  final Logger logger = Logger.getLogger(TicketsDefinitions.class);

    DriverFactory driverFactory = new DriverFactory();
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    HomePage homePage = new HomePage();
    TicketsPage ticketsPage = new TicketsPage();
    TicketsSteps ticketsSteps = new TicketsSteps();
    LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage();
    int priceOfTicket;

//    @After
//    public void teardown() {
//        driver.quit();
//    }
@After
public void teardown(){
    DriverFactory.getDriver().close();
    DriverFactory.getDriver().quit();
    DriverFactory.setDriver();
}

    @Given("{} menu page is displayed")
    public void ticketEventPage(String pageName) throws InterruptedException {
        ticketsSteps.eventTicketsPageIsDisplayed(pageName);
    }

    @Given("User is logged in with valid credentials")
    public void userIsLoggedInWithValidCredentials() {
        ticketsSteps.userIsLoggedIn();
        logger.info("User is logged in with valid credentials");
    }

    @When("{} is selected")
    public void userSelectsASection(String section) {
        ticketsSteps.sectionIsSelected(section);
        logger.info(section + " is selected");
    }

    @When("User {} {} tickets for an event of the {}")
    public void userSelectsAnEvent(String submit, int nr, String section) throws InterruptedException {
        if (submit.equals("submits")) {
            ticketsSteps.selectOnRandomEvent(section);
            ticketsSteps.selectNrOTickets(nr);
            logger.info(nr + " Tickets are selected");
            priceOfTicket = ticketsSteps.submitTicketsNr();
            logger.info(nr + " Tickets are submited");
        } else if (submit.equals("selects")) {
            ticketsSteps.selectOnRandomEvent(section);
            ticketsSteps.selectNrOTickets(nr);
            logger.info(nr + " Tickets are selected");
        }
    }

    @And("The total price is displayed correct for {} tickets")
    public void theTotalPriceOfTicketsIsDisplayedCorrect(int ticketsNr) {
        ticketsSteps.assertAmmountOfPayment(ticketsNr, priceOfTicket);
        logger.info("The total price of tickets is displayed correct for" + ticketsNr + " tickets");
    }

    @And("All fields of booking are submited")
    public void allFieldsOfBookingAreSubmited() {
        ticketsSteps.submitBookingFields();
    }


    @And("^All fields of booking are filled with (.*), (.*), (.*) and submited$")
    public void allFieldsOfBookingAreFilledWithFirstnameLastnamePhoneAndSubmited(String firstName, String lastName, String phone) throws Exception {
        ticketsSteps.populateBookingFields(firstName, lastName, phone);
        ticketsSteps.submitBookingFields();
    }

    @Then("Booking is successfully accepted")
    public void bookingIsSuccessfullyAccepted() {
        ticketsSteps.submitConfirmBooking();
        ticketsSteps.verifyBooking();
    }

    @Then("(.*) occurs under each field$")
    public void aWarningMessageOccursUnderEachField(String errorMessage) {
        ticketsSteps.verifyWarningMessages(errorMessage);
    }

    @And("User selects {} tickets for the same event")
    public void userSelectsEmptyTicketsForTheSameEvent(int nr) throws InterruptedException {
        nr = 0;
        ticketsSteps.selectNrOTickets(nr);
    }

    @And("Submit button is (.*)")
    public void submitButtonIsEnabledDisabled(String availability) {
        ticketsSteps.setSubmitButtonAvailability(availability);
    }

    @And("All events of {} have \"Detalii\" button")
    public void allEventsOnThePageHaveDetails(String section) {
        ticketsSteps.verifyDetailsBtn(section);
    }


    @And("User clicks on \"Detalii\" button of an event of {}")
    public void userClicksOnButtonOfAnEvent(String section) {
        ticketsSteps.clickBtnDetailsRandomEvent(section);
    }

    @Then("The information of the event is displayed")
    public void theInformationOfTheEventIsDisplayed() {
        ticketsSteps.verifyDetailsOfEvent();
    }

    @And("{} for alert is selected and submited")
    public void userSelectsAnOptionForAlertAndSubmit(String option) {
        ticketsSteps.setAlert(option);
    }

    @Then("The alert is successfully set and deleted")
    public void theAlertIsSuccessfullySet() {
        ticketsSteps.verifyAlertIsSet();
        ticketsSteps.deleteAlert();
    }
}
