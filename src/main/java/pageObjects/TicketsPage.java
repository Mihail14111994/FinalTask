package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TicketsPage extends PageObject{
    @FindBy(xpath = "//*[@id='content']/h1")
    WebElement pageName;

    public WebElement getPageName() {
        return pageName;
    }
}
