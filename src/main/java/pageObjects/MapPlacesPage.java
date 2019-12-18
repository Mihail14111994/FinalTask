package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MapPlacesPage extends PageObject{

    @FindBy(css = ".list-wrap label")
    List<WebElement> mapFromPlacesPageCheckboxes;

    public List<WebElement> getMapFromPlacesPageCheckboxes() {
        return mapFromPlacesPageCheckboxes;
    }
}
