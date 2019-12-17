package actionMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Borders {

    public void drawBorder(WebElement element, WebDriver driver, Colours color) {
        String colorString;
        switch (color)
        {
            case RED:
            {
                colorString="red'";
                break;
            }
            case BLUE:
            {
                colorString="blue'";
                break;
            }
            case GREEN:
            {
                colorString="green'";
                break;
            }
            default:
                colorString="red'";
                break;
        }
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid "+colorString, element);
    }
    public void undrawBorder(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='0px'", element);
    }
}
