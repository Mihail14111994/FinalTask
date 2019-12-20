package actionMethods;

import driverFactory.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import static java.time.Duration.ofMillis;

public class Click {
    public static void click(WebElement element) {
        Logger logger = Logger.getLogger(Click.class);
        org.openqa.selenium.support.ui.Wait<WebDriver> wait = new FluentWait<>(DriverFactory.getDriver())
                .withTimeout(ofMillis(2000))
                .pollingEvery(ofMillis(2000))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        if(element.getText()!=null){
        logger.info("Clicked " + element.getText());}
    }
}
