package actionMethods;

import driverFactory.DriverFactory;
import enums.Colours;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class BorderScreen {

    private BorderScreen(){
        throw new IllegalStateException("Utility class");
    }

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");

    public static void safeBorderScreen(WebElement element, Colours color, String path) throws IOException {
        Borders.drawBorder(element, DriverFactory.getDriver(), color);
        Screenshot.takeScreenshot();
        Borders.undrawBorder(element, DriverFactory.getDriver());
    }
}
