package actionMethods;

import driverFactory.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Scrolling {

    private Scrolling(){
        throw new IllegalStateException("Utility class");
    }

    public static void scrollingUntilElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'})", element);
    }
}
