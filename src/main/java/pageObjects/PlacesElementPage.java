package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlacesElementPage extends PageObject {

    @FindBy(xpath="//*[@class = 'btn btn-tiny btn-generic btn-fixed']")
    private List <WebElement> btnDetailsOfAPlacesElement;

    @FindBy(xpath = "//div[@class = 'term-data']//div")
    private List<WebElement>  txtPlacePrice;

    @FindBy(xpath = "//*[@class = 'oneline ellipsis']")
    private List<WebElement> placesElementType;


    public List<WebElement> getBtnDetailsOfAPlacesElement() {
        return btnDetailsOfAPlacesElement;
    }

    public List<WebElement> getTxtPlacePrice() {
        return txtPlacePrice;
    }

    public List<WebElement> getPlacesElementType() {
        return placesElementType;
    }}
