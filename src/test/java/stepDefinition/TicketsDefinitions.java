package stepDefinition;

import cucumber.api.java8.En;
import driverFactory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.TicketsPage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.Driver;

public class TicketsDefinitions implements En {

    DriverFactory driverFactory = new DriverFactory();
    WebDriver driver = driverFactory.newDriver();
    WebDriverWait wait = new WebDriverWait(driver,30);
    HomePage homePage=new HomePage();
    TicketsPage ticketsPage=new TicketsPage();
    @BeforeClass
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }
    @Before
    public void setup() throws InterruptedException {
        DriverFactory.getDriver().get("https://demo.opencart.com/");
        DriverFactory.getDriver().manage().window().maximize();
    }

    @After
    public void teardown() {
        DriverFactory.getDriver().quit();
    }

    @Given("^User is on Tickets page$")
    public void ticketEventPage() {
        driver.get("https://www.fest.md/");
        homePage.getTicketsMenu().click();
        assertThat("Ticket Page is not displayed",ticketsPage.getPageName().getText(),is("Bilete"));

    }

    @When("^User select a (.*) of tickets for an event$")
    public void userSelectASection(int nrOfTickets) {

    }

    @When("^User select a (.*)$")
    public void userSelectASection(String section) {

    }

    @And("^The total price of tickets is displayed correct$")
    public void theTotalPriceOfTicketsIsDisplayedCorrect() {
    }

    @And("^All fields of booking are filled with (.*), (.*), (.*) and submited$")
    public void allFieldsOfBookingAreFilledWithFirstnameLastnamePhoneAndSubmited(String firstName, String lastName, String phone) {

    }

    @Then("Booking is successfully accepted")
    public void bookingIsSuccessfullyAccepted() {
    }

    @And("Booking is not accepted")
    public void bookingIsNotAccepted() {
    }

    @Then("A (.*) occurs under each field$")
    public void aWarningMessageOccursUnderEachField() {
    }

    @And("Submit button is (.*)")
    public void submitButtonIsEnabledDisabled() {
        //case

    }

    @And("All events on the page have {string} button")
    public void allEventsOnThePageHaveButton(String detaliiButton) {
    }


    @And("User clicks on {string} button of an event")
    public void userClicksOnButtonOfAnEvent(String detaliiButton) {
    }

    @Then("The information of the event is displayed")
    public void theInformationOfTheEventIsDisplayed() {
    }




//    @When("User select a <section>")
//    public void userSelectASection() {
//    }

    @And("User select a <nr> of tickets for an event")
    public void userSelectANrOfTicketsForAnEvent() {
    }
}
