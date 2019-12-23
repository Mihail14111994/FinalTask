package pageObjects;

import driverFactory.DriverFactory;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
    PageObject() {PageFactory.initElements(DriverFactory.getDriver(), this);}
}
