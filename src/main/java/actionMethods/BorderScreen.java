package actionMethods;

import driverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BorderScreen {
    Borders borders = new Borders();
    Screenshot screenshot =new Screenshot();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
    WebDriver driver= DriverFactory.getDriver();
    public void safeBorderScreen(WebElement element, Colours color, String path) throws IOException {
        borders.drawBorder(element,driver,color);
        screenshot.takeScreenshot(driver, path+ LocalDateTime.now().format(formatter)+".jpg");
        borders.undrawBorder(element,driver);
    }
}
