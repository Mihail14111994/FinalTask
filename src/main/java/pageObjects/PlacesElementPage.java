package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlacesElementPage extends PageObject {
    @FindBy(xpath = "//div[@class = 'display-tr oneline buttons']")
    List<WebElement> btnDetailsOfAPlacesElement;

    @FindBy(xpath="//*[@id='form-filter-places']/div[1]/div[1]/div[3]/div[1]/ul/li/a")
    List<WebElement> dblThemes;

    public List<WebElement> getBtnDetailsOfAPlacesElement() {
        return btnDetailsOfAPlacesElement;
    }
}
