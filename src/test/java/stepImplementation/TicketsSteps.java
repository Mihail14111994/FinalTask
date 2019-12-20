package stepImplementation;

import driverFactory.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.List;

import static actionMethods.Click.click;
import static actionMethods.Random.randomLink;
import static actionMethods.Wait.waitFor;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TicketsSteps {
    TicketsPage ticketsPage = new TicketsPage();
    TicketSectionsPage ticketSectionsPage = new TicketSectionsPage();
    HomePage homePage = new HomePage();
    BookingPage bookingPage = new BookingPage();
    EventsPage eventsPage = new EventsPage();
    LoginRegistrationPage loginRegistrationPage = new LoginRegistrationPage();
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),30);
    Logger logger = Logger.getLogger(TicketsSteps.class);


    String info = "INFORMAȚII";
    String LOGIN = "whiteangel@outlook.com";
    String PASSWORD = "147369";
    String TICKETS = "Bilete";
    String EVENTS = "Evenimente";
    int totalPrice=0;
    String nameOfBookedEvent;

    public void eventTicketsPageIsDisplayed (String pageName) throws InterruptedException {
        waitFor(ticketsPage.getAdBanner());
//        wait.until(ExpectedConditions.visibilityOf(ticketsPage.getAdBanner()));
        Thread.sleep(2000);
        if (pageName.equals("Tickets")) {
            click(homePage.getTicketsMenu());
//            homePage.getTicketsMenu().click();
            assertThat("Ticket Page is not displayed",ticketsPage.getPageName().getText(),is(TICKETS));
        }
        else if (pageName.equals("Events")) {
            click(homePage.getEventsMenu());
//            homePage.getEventsMenu().click();
            assertThat("Ticket Page is not displayed",ticketsPage.getPageName().getText(),is(EVENTS));
        }
    }

    public void userIsLoggedIn(){
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.fest.md/ro/login-register");
        logger.info("Fest.md login-register page is displayed");
//        wait.until(ExpectedConditions.visibilityOf(loginRegistrationPage.getEmailLogin()));
//        loginRegistrationPage.getEmailLogin().click();
        click(loginRegistrationPage.getEmailLogin());
        loginRegistrationPage.getEmailLogin().sendKeys(LOGIN);
//        loginRegistrationPage.getPasswordLogin().click();
        click(loginRegistrationPage.getPasswordLogin());
        loginRegistrationPage.getPasswordLogin().sendKeys(PASSWORD);
//        loginRegistrationPage.getBtnLogin().click();
        click(loginRegistrationPage.getBtnLogin());
    }

    public void sectionIsSelected(String section){
        waitFor(ticketsPage.getAdBanner());
//        wait.until(ExpectedConditions.visibilityOf(ticketsPage.getAdBanner()));
        List<WebElement> listOfSectionNames = ticketsPage.getSectionNames();
        for (WebElement e:listOfSectionNames) {
            if (e.getText().equals(section)) {
//                e.click();
                click(e);
            }
        }
    }

    public void selectOnRandomEvent(String section) {
        boolean eventWithOutTickets = false;

        do{
            WebElement randomLink = null;
            if (section.equals("Concerte")) {
                 randomLink = randomLink(ticketsPage.getListOfConcerts());
            }
            else if (section.equals("Conferințe"))
            {
                randomLink = randomLink(ticketsPage.getListOfConferences());
            }
            else if (section.equals("Party"))
            {
                randomLink = randomLink(ticketsPage.getListOfParties());
            }
            randomLink.click();
//            click(randomLink);

            if(ticketSectionsPage.getBoxOfTickets().size()>0){
             nameOfBookedEvent = ticketSectionsPage.getNameOfEvent().getText();
             eventWithOutTickets=false;
                logger.info(nameOfBookedEvent+" event is chosen");

        }
            else {
                logger.warn("Chosen event has no tickets, a new event is going to be chosen...");
                eventWithOutTickets=true;
                click(homePage.getTicketsMenu());
//                homePage.getTicketsMenu().click();
                waitFor(ticketsPage.getPageName());
//                wait.until(ExpectedConditions.visibilityOf(ticketsPage.getPageName()));
                assertThat("Ticket Page is not displayed",ticketsPage.getPageName().getText(),is(TICKETS));
                waitFor(ticketsPage.getAdBanner());
//                wait.until(ExpectedConditions.visibilityOf(ticketsPage.getAdBanner()));
                List<WebElement> listOfSectionNames = ticketsPage.getSectionNames();
                for (WebElement element:listOfSectionNames) {
                    if (element.getText().equals(section)) {
//                        element.click();
                        click(element);
                    }
                }
            }
        }
        while(eventWithOutTickets);
    }
    public void selectNrOTickets(int nrOfTickets) throws InterruptedException {
        waitFor(ticketSectionsPage.getBtndetails());
//        wait.until(ExpectedConditions.visibilityOf(ticketSectionsPage.getBtndetails()));
//        click(ticketSectionsPage.getBoxOfTickets().get(0));
        logger.info("Clicked Tickets DropDown");
        ticketSectionsPage.getBoxOfTickets().get(0).click();
        click(ticketSectionsPage.getTicketsNr().get(nrOfTickets));
//        ticketSectionsPage.getTicketsNr().get(nrOfTickets).click();
    }
    public int submitTicketsNr(){
        waitFor(ticketSectionsPage.getPriceOfTicket());
        int price = Integer.parseInt(ticketSectionsPage.getPriceOfTicket().getText().replaceAll("[^0-9]", ""));
//        click(ticketSectionsPage.getBtnSubmitNrOfTickets());
        ticketSectionsPage.getBtnSubmitNrOfTickets().click();
        return price;
    }

    public void assertAmmountOfPayment(int nr, int price){
        totalPrice = nr*price;
        waitFor(bookingPage.getAmountToBePaid());
//        wait.until(ExpectedConditions.visibilityOf(bookingPage.getAmountToBePaid()));
        String displayedTotalPrice = bookingPage.getAmountToBePaid().getText().replaceAll("[^0-9]", "");
        assertThat("Amount to be paid is not correct displayed", displayedTotalPrice.equals(String.valueOf(totalPrice)));
    }

    public void populateBookingFields (String firstName, String lastName, String phoneNr)  {
        click(bookingPage.getRadioBtnTerminal());
//        bookingPage.getRadioBtnTerminal().click();
        WebElement fName = bookingPage.getFldFirstName();
        click(fName);
//        fName.click();
        fName.clear();
        fName.sendKeys(firstName);
        WebElement lName = bookingPage.getFldLastName();
        click(lName);
//        lName.click();
        lName.clear();
        lName.sendKeys(lastName);
        WebElement phone = bookingPage.getFldPhoneNr();
        click(phone);
//        phone.click();
        phone.clear();
        phone.sendKeys(phoneNr);
        logger.info("Booking Fields are populated");
    }

    public void setSubmitButtonAvailability(String available){
        if (available.equals("enabled"))
        {
            assertThat("Submit button is disabled instead of enabled",ticketSectionsPage.getBtnSubmitNrOfTickets().isDisplayed());
            logger.info("Submit button is enabled");
        }
        else if (available.equals("disabled"))
        {
            boolean a = ticketSectionsPage.getBtnSubmitNrOfTicketsDisabled().isDisplayed();
            assertThat("Submit button is enabled instead of disabled",ticketSectionsPage.getBtnSubmitNrOfTicketsDisabled().isDisplayed());
            logger.info("Submit button is disabled");
        }
    }

    public void submitBookingFields() {
//        click(bookingPage.getBtnContinue());
        bookingPage.getBtnContinue().click();
        logger.info("Clicked Continue");
    }

        public void submitConfirmBooking(){
        waitFor(bookingPage.getBtnSubmitConfirm());
//        wait.until(ExpectedConditions.visibilityOf(bookingPage.getBtnSubmitConfirm()));
        String displayedTotalPrice = bookingPage.getTotalPriceConfirm().getText().replaceAll("[^0-9]", "");
        assertThat("Total price of tickets in Confirm Booking is not correct", displayedTotalPrice, is(String.valueOf(totalPrice)));
        logger.info("Total price of tickets in Confirm Booking is correct");
        click(bookingPage.getBtnSubmitConfirm());
//        bookingPage.getBtnSubmitConfirm().click();
    }

        public void verifyBooking() {
        waitFor(ticketsPage.getAdBanner());
//        wait.until(ExpectedConditions.visibilityOf(ticketsPage.getAdBanner()));
            click(homePage.getBtnMyBookings());
//        homePage.getBtnMyBookings().click();
            waitFor(bookingPage.getBtnBookingDetails());
//        wait.until(ExpectedConditions.visibilityOf(bookingPage.getBtnBookingDetails()));
        assertThat("Name of displayed event is not the same as booked", ticketSectionsPage.getNameOfBookingEvent().getText(), is(nameOfBookedEvent));
        logger.info("Booking is successfully accepted");
    }
    public void verifyWarningMessages (String warnMessage){
        List <WebElement> warnMessages = bookingPage.getLblError();
        for (WebElement message: warnMessages) {
            assertThat("Actual warning message is not the same as required", message.getText(), containsString(warnMessage) );
        }
        logger.info("Warning messages under fields are correct");
    }

    public void verifyDetailsBtn(String section){
        if (section.equals("Sport"))
            assertThat("Not all Sport events have Details button", eventsPage.getListSports().size(), is(eventsPage.getListBtnDetailsSport().size()));
        else if (section.equals("Expoziții")){
            assertThat("Not all exhibitions have Details button", eventsPage.getListExhibitions().size(), is(eventsPage.getListBtnDetailsExhibitions().size()));}
        logger.info("All events have Details button");
    }

    public void clickBtnDetailsRandomEvent(String section){
        if (section.equals("Sport")){
            WebElement event = randomLink(eventsPage.getListBtnDetailsSport());
            click(event);
        }
        else if (section.equals("Expoziții")){
            WebElement event = randomLink(eventsPage.getListBtnDetailsExhibitions());
            click(event);
        }
    }

    public void verifyDetailsOfEvent(){
        assertThat("Information section of event is not present", eventsPage.getHdrInfo().getText(), is(info));
        logger.info("Information section of event is present");
    }

    public void setAlert(String option){
        click(eventsPage.getBtnAlarm());
//        eventsPage.getBtnAlarm().click();
        click(eventsPage.getDdAlarmReminder());
//        eventsPage.getDdAlarmReminder().click();
        List <WebElement> listDdAlarm = eventsPage.getListDdAlarmReminder();
        for (WebElement element:listDdAlarm)
        { if (element.getText().equals(option))
//            element.click();
        click(element);
        }
        click(eventsPage.getBtnSubmitReminder());
//        eventsPage.getBtnSubmitReminder().click();
        logger.info("Alarm is set");
    }

    public void verifyAlertIsSet(){
//        wait.until(ExpectedConditions.elementToBeClickable(homePage.getDdUserInformation()));
//        homePage.getDdUserInformation().click();
        click(homePage.getDdUserInformation());
        click(homePage.getBtnMyAccount());
//        homePage.getBtnMyAccount().click();
        assertThat("Reminder is not displayed", eventsPage.getBtnDeleteReminder().size()> 0);
        logger.info("Reminder is displayed");
    }

    public void deleteAlert(){
//        wait.until(ExpectedConditions.elementToBeClickable(eventsPage.getBtnSaveLanguage()));
        click(eventsPage.getBtnDeleteReminder().get(0));
//        eventsPage.getBtnDeleteReminder().get(0).click();
        assertThat("Reminder is not deleted",eventsPage.getBtnDeleteReminder().size() < 1 );
        logger.info("Reminder is deleted");
    }
}
