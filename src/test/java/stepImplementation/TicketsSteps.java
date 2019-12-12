package stepImplementation;

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
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TicketsSteps {
    TicketsPage ticketsPage = new TicketsPage();
    EventPage eventPage = new EventPage();
    HomePage homePage = new HomePage();
    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),30);

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
                randomLink = randomLink(ticketsPage.getListOfEvents());
            }
            randomLink.click();
            wait.until(ExpectedConditions.visibilityOf(eventPage.getBtndetails()));
            if(eventPage.getTicketsNrBox().size()<1){
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
            else eventWithOutTickets=false;
        }
        while(eventWithOutTickets);
    }
    public void selectNrOTickets(int nrOfTickets) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(eventPage.getBtndetails()));
        eventPage.getTicketsNrBox().get(0).click();
        eventPage.getTicketsNr().get(nrOfTickets).click();
        System.out.println(eventPage.getPriceOfTicket().getText());
    }
    public int submitTicketsNr(){
        int price = Integer.parseInt(eventPage.getPriceOfTicket().getText().replaceAll("[^0-9]", ""));
      //  int priceOfTickets=Integer.parseInt(eventPage.getPriceOfTicket().getText());
        System.out.println(eventPage.getPriceOfTicket().getText());
        eventPage.getSubmitNrOfTickets().click();
        return price;
    }


}


