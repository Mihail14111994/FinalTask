package stepImplementation;

import driverFactory.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.*;

import java.io.IOException;
import java.util.List;

import static actionMethods.Click.click;
import static actionMethods.RandomLink.randomLink;
import static actionMethods.Wait.waitFor;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TicketsSteps {
    private TicketsPage ticketsPage = new TicketsPage();
    private TicketDetailsPage ticketDetailsPage = new TicketDetailsPage();
    private HomePage homePage = new HomePage();
    private BookingPage bookingPage = new BookingPage();
    private EventsPage eventsPage = new EventsPage();
    private RegistrationPage registrationPage = new RegistrationPage();
    private static final Logger logger = Logger.getLogger(TicketsSteps.class);

    private final String INFO = "INFORMAȚII";
    private final String LOGIN = "doina123456@gmail.com";
    private final String PASSWORD = "147369";
    private final String TICKETS = "Bilete";
    private final String EVENTS = "Evenimente";
    private int totalPrice = 0;
    private String nameOfBookedEvent;
    private String path = "target\\screenshots\\tickets\\";

    public void eventTicketsPageIsDisplayed(String pageName) throws InterruptedException, IOException {
        waitFor(ticketsPage.getAdBanner());
        Thread.sleep(2000);
        if (pageName.equals("Tickets")) {
            click(homePage.getTicketsMenu(), path);
            assertThat("Ticket Page is not displayed", ticketsPage.getPageName().getText(), is(TICKETS));
        } else if (pageName.equals("Events")) {
            click(homePage.getEventsMenu(), path);
            assertThat("Ticket Page is not displayed", ticketsPage.getPageName().getText(), is(EVENTS));
        }
    }

    public void userIsLoggedIn() throws IOException {
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.fest.md/ro/login-register");
        logger.info("Fest.md login-register page is displayed");
        click(registrationPage.getEmailLogin(), path);
        registrationPage.getEmailLogin().sendKeys(LOGIN);
        click(registrationPage.getPasswordLogin(), path);
        registrationPage.getPasswordLogin().sendKeys(PASSWORD);
        click(registrationPage.getBtnLogin(), path);
        logger.info("User is logged in with valid credentials");
    }

    public void sectionIsSelected(String section) throws IOException {
        waitFor(ticketsPage.getAdBanner());
        List<WebElement> listOfSectionNames = ticketsPage.getSectionNames();
        for (WebElement e : listOfSectionNames) {
            if (e.getText().equals(section)) {
                click(e, path);
            }
        }
        logger.info(section + " is selected");
    }

    public void selectOnRandomEvent(String section) throws IOException {
        boolean eventWithOutTickets;

        do {
            WebElement randomLink = null;
            switch (section) {
                case "Concerte":
                    randomLink = randomLink(ticketsPage.getListOfConcerts());
                    break;
                case "Conferințe":
                    randomLink = randomLink(ticketsPage.getListOfConferences());
                    break;
                case "Party":
                    randomLink = randomLink(ticketsPage.getListOfParties());
                    break;
            }
            click(randomLink, path);

            if (ticketDetailsPage.getBoxOfTickets().size() > 0) {
                nameOfBookedEvent = ticketDetailsPage.getNameOfEvent().getText();
                eventWithOutTickets = false;
                logger.info(nameOfBookedEvent + " event is chosen");

            } else {
                logger.warn("Chosen event has no tickets, a new event is going to be chosen...");
                eventWithOutTickets = true;
                click(homePage.getTicketsMenu(), path);
                waitFor(ticketsPage.getPageName());
                assertThat("Ticket Page is not displayed", ticketsPage.getPageName().getText(), is(TICKETS));
                waitFor(ticketsPage.getAdBanner());
                List<WebElement> listOfSectionNames = ticketsPage.getSectionNames();
                for (WebElement element : listOfSectionNames) {
                    if (element.getText().equals(section)) {
                        click(element, path);
                    }
                }
            }
        }
        while (eventWithOutTickets);
    }

    public void selectNrOTickets(int nrOfTickets) throws IOException {
        waitFor(ticketDetailsPage.getBtndetails());
        logger.info("Clicked Tickets DropDown");
        ticketDetailsPage.getBoxOfTickets().get(0).click();
        click(ticketDetailsPage.getTicketsNr().get(nrOfTickets), path);
        logger.info(nrOfTickets + " Tickets are selected");
    }

    public int submitTicketsNr() throws IOException {
        waitFor(ticketDetailsPage.getPriceOfTicket());
        int price = Integer.parseInt(ticketDetailsPage.getPriceOfTicket().getText().replaceAll("[^0-9]", ""));
        click(ticketDetailsPage.getBtnSubmitNrOfTickets(), path);
        logger.info("Tickets are submited");
        return price;
    }

    public void assertAmmountOfPayment(int nr, int price) {
        totalPrice = nr * price;
        waitFor(bookingPage.getAmountToBePaid());
        String displayedTotalPrice = bookingPage.getAmountToBePaid().getText().replaceAll("[^0-9]", "");
        assertThat("Amount to be paid is not correct displayed", displayedTotalPrice.equals(String.valueOf(totalPrice)));
        logger.info("The total price of tickets is displayed correct for" + nr + " tickets");
    }

    public void populateBookingFields(String firstName, String lastName, String phoneNr) throws IOException {
        click(bookingPage.getRadioBtnTerminal(), path);
        WebElement fName = bookingPage.getFldFirstName();
        click(fName, path);
        fName.clear();
        fName.sendKeys(firstName);
        WebElement lName = bookingPage.getFldLastName();
        click(lName, path);
        lName.clear();
        lName.sendKeys(lastName);
        WebElement phone = bookingPage.getFldPhoneNr();
        click(phone, path);
        phone.clear();
        phone.sendKeys(phoneNr);
        logger.info("Booking Fields are populated");
    }

    public void setSubmitButtonAvailability(String available) {
        if (available.equals("enabled")) {
            assertThat("Submit button is disabled instead of enabled", ticketDetailsPage.getBtnSubmitNrOfTickets().isDisplayed());
            logger.info("Submit button is enabled");
        } else if (available.equals("disabled")) {
            assertThat("Submit button is enabled instead of disabled", ticketDetailsPage.getBtnSubmitNrOfTicketsDisabled().isDisplayed());
            logger.info("Submit button is disabled");
        }
    }

    public void submitBookingFields() throws IOException {
        click(bookingPage.getBtnContinue(), path);
    }

    public void submitConfirmBooking() throws IOException {
        waitFor(bookingPage.getBtnSubmitConfirm());
        String displayedTotalPrice = bookingPage.getTotalPriceConfirm().getText().replaceAll("[^0-9]", "");
        assertThat("Total price of tickets in Confirm Booking is not correct", displayedTotalPrice, is(String.valueOf(totalPrice)));
        logger.info("Total price of tickets in Confirm Booking is correct");
        click(bookingPage.getBtnSubmitConfirm(), path);
    }

    public void verifyBooking() throws IOException {
        waitFor(ticketsPage.getAdBanner());
        click(homePage.getBtnMyBookings(), path);
        waitFor(bookingPage.getBtnBookingDetails());
        assertThat("Name of displayed event is not the same as booked", ticketDetailsPage.getNameOfBookingEvent().getText(), is(nameOfBookedEvent));
        logger.info("Booking is successfully accepted");
    }

    public void verifyWarningMessages(String warnMessage) {
        List<WebElement> warnMessages = bookingPage.getLblError();
        for (WebElement message : warnMessages) {
            assertThat("Actual warning message is not the same as required", message.getText(), containsString(warnMessage));
        }
        logger.info("Warning messages under fields are correct");
    }

    public void verifyDetailsBtn(String section) {
        if (section.equals("Sport"))
            assertThat("Not all Sport events have Details button", eventsPage.getListSports().size(), is(eventsPage.getListBtnDetailsSport().size()));
        else if (section.equals("Expoziții")) {
            assertThat("Not all exhibitions have Details button", eventsPage.getListExhibitions().size(), is(eventsPage.getListBtnDetailsExhibitions().size()));
        }
        logger.info("All events have Details button");
    }

    public void clickBtnDetailsRandomEvent(String section) throws IOException {
        if (section.equals("Sport")) {
            WebElement event = randomLink(eventsPage.getListBtnDetailsSport());
            click(event, path);
        } else if (section.equals("Expoziții")) {
            WebElement event = randomLink(eventsPage.getListBtnDetailsExhibitions());
            click(event, path);
        }
    }

    public void verifyDetailsOfEvent() {
        assertThat("Information section of event is not present", eventsPage.getHdrInfo().getText(), is(INFO));
        logger.info("Information section of event is present");
    }

    public void setAlert(String option) throws IOException {
        click(eventsPage.getBtnAlarm(), path);
        click(eventsPage.getDdAlarmReminder(), path);
        List<WebElement> listDdAlarm = eventsPage.getListDdAlarmReminder();
        for (WebElement element : listDdAlarm) {
            if (element.getText().equals(option))
                click(element, path);
        }
        eventsPage.getBtnSubmitReminder().click();
        logger.info("Alarm is set");
    }

    public void verifyAlertIsSet() throws IOException {
        click(homePage.getDdUserInformation(), path);
        click(homePage.getBtnMyAccount(), path);
        assertThat("Reminder is not displayed", eventsPage.getBtnDeleteReminder().size() > 0);
        logger.info("Reminder is displayed");
    }

    public void deleteAlert() throws IOException {
        click(eventsPage.getBtnDeleteReminder().get(0), path);
        assertThat("Reminder is not deleted", eventsPage.getBtnDeleteReminder().size() < 1);
        logger.info("Reminder is deleted");
    }
}
