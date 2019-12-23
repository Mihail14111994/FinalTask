package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageObject{

    @FindBy(xpath = "//span[@class='item last']")
    private WebElement txaSearchFor;

    public WebElement getTxaSearchFor() {
        return txaSearchFor;
    }
}
