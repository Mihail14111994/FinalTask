package stepImplementation;

import com.google.common.base.Predicate;
import driverFactory.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.EventPage;
import pageObjects.HomePage;
import pageObjects.TicketsPage;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TicketsSteps {
    TicketsPage ticketsPage = new TicketsPage();
    EventPage eventPage = new EventPage();
    HomePage homePage = new HomePage();
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),30);
    int totalPrice=0;
    String nameOfBookedEvent;

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
            randomLink.click();

            //wait.until(ExpectedConditions.visibilityOf(eventPage.getPriceOfTicket()));
            if(eventPage.getBoxOfTickets().isDisplayed()){
             nameOfBookedEvent = eventPage.getNameOfEvent().getText();
             eventWithOutTickets=false;
        }
            else {
                eventWithOutTickets=true;
                homePage.getTicketsMenu().click();
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
        wait.until(ExpectedConditions.visibilityOf(eventPage.getBtndetails()));
        eventPage.getBoxOfTickets().click();
        eventPage.getTicketsNr().get(nrOfTickets).click();
    }
    public int submitTicketsNr(){
        int price = Integer.parseInt(eventPage.getPriceOfTicket().getText().replaceAll("[^0-9]", ""));
        eventPage.getSubmitNrOfTickets().click();
        return price;
    }

    public void assertAmmountOfPayment(int nr, int price){
//        totalPrice=0;
        totalPrice = nr*price;
        String displayedTotalPrice = eventPage.getAmountToBePaid().getText().replaceAll("[^0-9]", "");
//        System.out.println(displayedTotalPrice + "ddddddddd");
        assertThat("Amount to be paid is not correct displayed", displayedTotalPrice.equals(String.valueOf(totalPrice)));
    }

    public void populateBookingFields (String firstName, String lastName, String phoneNr)  {

        eventPage.getRadioBtnTerminal().click();
        WebElement fName = eventPage.getFldFirstName();
        fName.click();
        fName.clear();
        fName.sendKeys(firstName);
        WebElement lName = eventPage.getFldLastName();
        lName.click();
        lName.clear();
        lName.sendKeys(lastName);
        WebElement phone = eventPage.getFldPhoneNr();
        phone.click();
        phone.clear();
        phone.sendKeys(phoneNr);
//        eventPage.getBtnContinue().click();
////        wait.until(ExpectedConditions.visibilityOf(eventPage.getBtnSubmitConfirm()));
////        String displayedTotalPrice = eventPage.getTotalPriceConfirm().getText().replaceAll("[^0-9]", "");
//////      assertThat("Total price of tickets in Confirm Booking is not correct", displayedTotalPrice.equals(String.valueOf(totalPrice)));
////        assertThat("Total price of tickets in Confirm Booking is not correct", displayedTotalPrice, is(String.valueOf(totalPrice)));
////        eventPage.getBtnSubmitConfirm().click();
    }

    public void doina(){

    }

    public void submitBookingFields() {
        eventPage.getBtnContinue().click();
    }

        public void submitConfirmBooking(){
        wait.until(ExpectedConditions.visibilityOf(eventPage.getBtnSubmitConfirm()));
        String displayedTotalPrice = eventPage.getTotalPriceConfirm().getText().replaceAll("[^0-9]", "");
//      assertThat("Total price of tickets in Confirm Booking is not correct", displayedTotalPrice.equals(String.valueOf(totalPrice)));
        assertThat("Total price of tickets in Confirm Booking is not correct", displayedTotalPrice, is(String.valueOf(totalPrice)));
        eventPage.getBtnSubmitConfirm().click();
    }

        public void verifyBooking() {
        wait.until(ExpectedConditions.visibilityOf(ticketsPage.getAdBanner()));
        eventPage.getBtnMyBookings().click();
        wait.until(ExpectedConditions.visibilityOf(eventPage.getBtnBookingDetails()));
//        assertThat("Name of displayed event is not the same as booked", eventPage.getNameOfBookingEvent().equals(nameOfBookedEvent));
        assertThat("Name of displayed event is not the same as booked",eventPage.getNameOfBookingEvent().getText(), is(nameOfBookedEvent));
    }
    public void verifyWarningMessages (String warnMessage){
        List <WebElement> warnMessages = eventPage.getLblError();
        for (WebElement message: warnMessages) {
            assertThat("Actual warning message is not the same as required", message.getText(), containsString(warnMessage) );
        }

    }
    }



