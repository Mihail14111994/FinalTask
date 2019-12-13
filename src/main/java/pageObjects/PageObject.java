package pageObjects;

import driverFactory.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    PageObject() {PageFactory.initElements(DriverFactory.getDriver(), this);}
}
