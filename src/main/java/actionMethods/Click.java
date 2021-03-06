package actionMethods;

import driverFactory.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static actionMethods.Screenshot.takeScreenshot;
import static enums.Colours.RED;
import static java.time.Duration.ofMillis;

public class Click {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
    private static final Logger logger = Logger.getLogger(Click.class);
    private static final Wait<WebDriver> wait = new FluentWait<>(DriverFactory.getDriver())
            .withTimeout(ofMillis(2000))
            .pollingEvery(ofMillis(2000))
            .ignoring(NoSuchElementException.class)
            .ignoring(StaleElementReferenceException.class);

    public static void click(WebElement element, String path) throws IOException {

        wait.until(ExpectedConditions.elementToBeClickable(element));
        Scrolling.scrollingUntilElement(element);
        Borders.drawBorder(element, DriverFactory.getDriver(), RED);
        takeScreenshot();
        if(element.getText().length() > 0){
        logger.info("Clicked " + element.getText());}
        element.click();
    }
}
