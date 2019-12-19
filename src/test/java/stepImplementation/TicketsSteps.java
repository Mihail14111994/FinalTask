package stepImplementation;

import actionMethods.Borders;
import actionMethods.Scrolling;
import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.List;
import java.util.Random;

import static actionMethods.Colours.RED;
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
    Scrolling scrolling =new Scrolling();
    Borders borders = new Borders();
    WebDriver driver = DriverFactory.getDriver();
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),30);

    String info = "INFORMAȚII";
    String LOGIN = "frosea1234@gmail.com";
    String PASSWORD = "147369";
    int totalPrice=0;
    String nameOfBookedEvent;

    public void eventTicketsPageIsDisplayed (String pageName) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(ticketsPage.getAdBanner()));
        Thread.sleep(2000);
        if (pageName.equals("Tickets")) {
            homePage.getTicketsMenu().click();
            assertThat("Ticket Page is not displayed",ticketsPage.getPageName().getText(),is("Bilete"));
        }
        else if (pageName.equals("Events")) {
            homePage.getEventsMenu().click();
            assertThat("Ticket Page is not displayed",ticketsPage.getPageName().getText(),is("Evenimente"));
        }
    }

    public void userIsLoggedIn(){
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.fest.md/ro/login-register");
        wait.until(ExpectedConditions.visibilityOf(loginRegistrationPage.getEmailLogin()));
        loginRegistrationPage.getEmailLogin().click();
        loginRegistrationPage.getEmailLogin().sendKeys(LOGIN);
        loginRegistrationPage.getPasswordLogin().click();
        loginRegistrationPage.getPasswordLogin().sendKeys(PASSWORD);
        loginRegistrationPage.getBtnLogin().click();
    }

    public void sectionIsSelected(String section){
        wait.until(ExpectedConditions.visibilityOf(ticketsPage.getAdBanner()));
        List<WebElement> listOfSectionNames = ticketsPage.getSectionNames();
        for (WebElement e:listOfSectionNames) {
            if (e.getText().equals(section)) {
                e.click();}
        }
    }


    public WebElement randomLink(List<WebElement> links) {
        int listSize = links.size();
        Random r = new Random();
        int linkNo = r.nextInt(listSize);
        WebElement link = links.get(linkNo);
        return link;
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
            scrolling.scrollingUntilElement(randomLink);
            borders.drawBorder(randomLink, driver, RED);
            randomLink.click();

            if(ticketSectionsPage.getBoxOfTickets().size()>0){
             nameOfBookedEvent = ticketSectionsPage.getNameOfEvent().getText();
             eventWithOutTickets=false;
        }
            else {
                eventWithOutTickets=true;
                homePage.getTicketsMenu().click();
                wait.until(ExpectedConditions.visibilityOf(ticketsPage.getPageName()));
                assertThat("Ticket Page is not displayed",ticketsPage.getPageName().getText(),is("Bilete"));
                wait.until(ExpectedConditions.visibilityOf(ticketsPage.getAdBanner()));
                List<WebElement> listOfSectionNames = ticketsPage.getSectionNames();
                for (WebElement element:listOfSectionNames) {
                    if (element.getText().equals(section)) {
                        element.click();}
                }
            }
        }
        while(eventWithOutTickets);
    }
    public void selectNrOTickets(int nrOfTickets) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(ticketSectionsPage.getBtndetails()));
        ticketSectionsPage.getBoxOfTickets().get(0).click();
        ticketSectionsPage.getTicketsNr().get(nrOfTickets).click();
    }
    public int submitTicketsNr(){
        int price = Integer.parseInt(ticketSectionsPage.getPriceOfTicket().getText().replaceAll("[^0-9]", ""));
        ticketSectionsPage.getBtnSubmitNrOfTickets().click();
        return price;
    }

    public void assertAmmountOfPayment(int nr, int price){
        totalPrice = nr*price;
        String displayedTotalPrice = bookingPage.getAmountToBePaid().getText().replaceAll("[^0-9]", "");
        assertThat("Amount to be paid is not correct displayed", displayedTotalPrice.equals(String.valueOf(totalPrice)));
    }

    public void populateBookingFields (String firstName, String lastName, String phoneNr)  {
        bookingPage.getRadioBtnTerminal().click();
        WebElement fName = bookingPage.getFldFirstName();
        fName.click();
        fName.clear();
        fName.sendKeys(firstName);
        WebElement lName = bookingPage.getFldLastName();
        lName.click();
        lName.clear();
        lName.sendKeys(lastName);
        WebElement phone = bookingPage.getFldPhoneNr();
        phone.click();
        phone.clear();
        phone.sendKeys(phoneNr);
    }

    public void setSubmitButtonAvailability(String available){
        if (available.equals("enabled"))
        {
            assertThat("Submit button is disabled instead of enabled",ticketSectionsPage.getBtnSubmitNrOfTickets().isDisplayed());
        }
        else if (available.equals("disabled"))
        {
            boolean a = ticketSectionsPage.getBtnSubmitNrOfTicketsDisabled().isDisplayed();
            System.out.println(a);
            assertThat("Submit button is enabled instead of disabled",ticketSectionsPage.getBtnSubmitNrOfTicketsDisabled().isDisplayed());
        }
    }

    public void submitBookingFields() {
        bookingPage.getBtnContinue().click();
    }

        public void submitConfirmBooking(){
        wait.until(ExpectedConditions.visibilityOf(bookingPage.getBtnSubmitConfirm()));
        String displayedTotalPrice = bookingPage.getTotalPriceConfirm().getText().replaceAll("[^0-9]", "");
        assertThat("Total price of tickets in Confirm Booking is not correct", displayedTotalPrice, is(String.valueOf(totalPrice)));
        bookingPage.getBtnSubmitConfirm().click();
    }

        public void verifyBooking() {
        wait.until(ExpectedConditions.visibilityOf(ticketsPage.getAdBanner()));
        homePage.getBtnMyBookings().click();
        wait.until(ExpectedConditions.visibilityOf(bookingPage.getBtnBookingDetails()));
        assertThat("Name of displayed event is not the same as booked", ticketSectionsPage.getNameOfBookingEvent().getText(), is(nameOfBookedEvent));
    }
    public void verifyWarningMessages (String warnMessage){
        List <WebElement> warnMessages = bookingPage.getLblError();
        for (WebElement message: warnMessages) {
            assertThat("Actual warning message is not the same as required", message.getText(), containsString(warnMessage) );
        }
    }

    public void verifyDetailsBtn(String section){
        if (section.equals("Sport"))
            assertThat("Not all Sport events have Details button", eventsPage.getListSports().size(), is(eventsPage.getListBtnDetailsSport().size()));
        else if (section.equals("Expoziții"))
            assertThat("Not all exhibitions have Details button", eventsPage.getListExhibitions().size(), is(eventsPage.getListBtnDetailsExhibitions().size()));
    }

    public void clickBtnDetailsRandomEvent(String section){
        if (section.equals("Sport"))
            randomLink(eventsPage.getListBtnDetailsSport()).click();
        else if (section.equals("Expoziții"))
            randomLink(eventsPage.getListBtnDetailsExhibitions()).click();
    }

    public void verifyDetailsOfEvent(){
        assertThat("Information section of event is not present", eventsPage.getHdrInfo().getText(), is(info));
    }

    public void setAlert(String option){
        eventsPage.getBtnAlarm().click();
        eventsPage.getDdAlarmReminder().click();
        List <WebElement> listDdAlarm = eventsPage.getListDdAlarmReminder();
        for (WebElement element:listDdAlarm)
        { if (element.getText().equals(option))
            element.click();
        }
        eventsPage.getBtnSubmitReminder().click();
    }

    public void verifyAlertIsSet(){
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getDdUserInformation()));
        homePage.getDdUserInformation().click();
        homePage.getBtnMyAccount().click();
        assertThat("Reminder is not displayed", eventsPage.getBtnDeleteReminder().size()> 0);
    }

    public void deleteAlert(){
        wait.until(ExpectedConditions.elementToBeClickable(eventsPage.getBtnSaveLanguage()));
        eventsPage.getBtnDeleteReminder().get(0).click();
        assertThat("Reminder is not deleted",eventsPage.getBtnDeleteReminder().size() < 1 );
    }
}
