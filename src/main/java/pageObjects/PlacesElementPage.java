package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlacesElementPage extends PageObject {

    @FindBy(xpath="//div[@class = 'display-tr oneline buttons']")
    List <WebElement> btnDetailsOfAPlacesElement;

    @FindBy(xpath="//div[@class = 'facilities']")
    WebElement  txtPlaceFacilities;

    @FindBy(xpath="//div[@class = 'icon-coins']")
    WebElement  txtPlacePrice;

    @FindBy(xpath="//span[@class = 'term-data']")
    List<WebElement>  txtPlaceTheme;

    @FindBy(xpath="//*[@id='content']/div[3]/div[1]/div/div[3]/div[3]/div[1]/span[2]")
    WebElement  txtPlaceType;

    public List<WebElement> getBtnDetailsOfAPlacesElement() {
        return btnDetailsOfAPlacesElement;
    }

    public WebElement getTxtPlaceFacilities() {
        return txtPlaceFacilities;
    }

    public WebElement getTxtPlacePrice() {
        return txtPlacePrice;
    }

    public List<WebElement> getTxtPlaceTheme() {
        return txtPlaceTheme;
    }

    public WebElement getTxtPlaceType() {
        return txtPlaceType;
    }
}
