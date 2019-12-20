package actionMethods;

import driverFactory.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
    public static void waitFor (WebElement element){
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
