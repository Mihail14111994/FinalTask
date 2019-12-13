package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlacesPage {
    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    WebElement btn;
}
