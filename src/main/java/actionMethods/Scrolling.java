package actionMethods;

import driverFactory.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Scrolling {
    public void scrollingUntilElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", element);
    }
}
