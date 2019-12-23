package actionMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollingPixels {

    private ScrollingPixels(){
        throw new IllegalStateException("Utility class");
    }

    public static void scrollingPixels(WebDriver driver, int xCoordinate, int yCoordinate){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String toScroll = "window.scrollBy("+String.valueOf(xCoordinate)+","+String.valueOf(yCoordinate)+")";
        jse.executeScript(toScroll, "");
    }
}
