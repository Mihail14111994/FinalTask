package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepImplementation.TicketsSteps;

import java.io.IOException;

public class TicketsDefinitions {
    TicketsSteps ticketsSteps = new TicketsSteps();
    private int priceOfTicket;

    @Given("{} menu page is displayed")
    public void ticketEventPage(String pageName) throws InterruptedException, IOException {
        ticketsSteps.eventTicketsPageIsDisplayed(pageName);
    }

    @Given("User is logged in with valid credentials")
    public void userIsLoggedInWithValidCredentials() throws IOException {
        ticketsSteps.userIsLoggedIn();
    }

    @When("{} is selected")
    public void userSelectsASection(String section) throws IOException {
        ticketsSteps.sectionIsSelected(section);
    }

    @When("User {} {} tickets for an event of the {}")
    public void userSelectsAnEvent(String submit, int nr, String section) throws InterruptedException, IOException {
        if (submit.equals("submits")) {
            ticketsSteps.selectOnRandomEvent(section);
            ticketsSteps.selectNrOTickets(nr);
            priceOfTicket = ticketsSteps.submitTicketsNr();
        } else if (submit.equals("selects")) {
            ticketsSteps.selectOnRandomEvent(section);
            ticketsSteps.selectNrOTickets(nr);
        }
    }

    @And("The total price is displayed correct for {} tickets")
    public void theTotalPriceOfTicketsIsDisplayedCorrect(int ticketsNr) {
        ticketsSteps.assertAmmountOfPayment(ticketsNr, priceOfTicket);
    }

    @And("All fields of booking are submited")
    public void allFieldsOfBookingAreSubmited() throws IOException {
        ticketsSteps.submitBookingFields();
    }


    @And("^All fields of booking are filled with (.*), (.*), (.*) and submited$")
    public void allFieldsOfBookingAreFilledWithFirstnameLastnamePhoneAndSubmited(String firstName, String lastName, String phone) throws Exception {
        ticketsSteps.populateBookingFields(firstName, lastName, phone);
        ticketsSteps.submitBookingFields();
    }

    @Then("Booking is successfully accepted")
    public void bookingIsSuccessfullyAccepted() throws IOException {
        ticketsSteps.submitConfirmBooking();
        ticketsSteps.verifyBooking();
    }

    @Then("(.*) occurs under each field$")
    public void aWarningMessageOccursUnderEachField(String errorMessage) {
        ticketsSteps.verifyWarningMessages(errorMessage);
    }

    @And("User selects {} tickets for the same event")
    public void userSelectsEmptyTicketsForTheSameEvent(int nr) throws InterruptedException, IOException {
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
    public void userClicksOnButtonOfAnEvent(String section) throws IOException {
        ticketsSteps.clickBtnDetailsRandomEvent(section);
    }

    @Then("The information of the event is displayed")
    public void theInformationOfTheEventIsDisplayed() {
        ticketsSteps.verifyDetailsOfEvent();
    }

    @And("{} for alert is selected and submited")
    public void userSelectsAnOptionForAlertAndSubmit(String option) throws IOException {
        ticketsSteps.setAlert(option);
    }

    @Then("The alert is successfully set and deleted")
    public void theAlertIsSuccessfullySet() throws IOException {
        ticketsSteps.verifyAlertIsSet();
        ticketsSteps.deleteAlert();
    }
}
