package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MapPlacesPage extends PageObject{

    @FindBy(css = ".list-wrap label")
    private List<WebElement> chkMapCheckboxes;

    @FindBy(css = "div[class^='marker theme']")
    private List<WebElement> mapPinpoints;

    @FindBy(css="button[type='button'][class='close']")
    private WebElement  btnMapCloseLegend;

    public List<WebElement> getChkMapCheckboxes() {
        return chkMapCheckboxes;
    }

    public List<WebElement> getMapPinpoints() {
        return mapPinpoints;
    }

    public WebElement getBtnMapCloseLegend() {
        return btnMapCloseLegend;
    }
}
