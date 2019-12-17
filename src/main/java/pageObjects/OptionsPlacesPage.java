package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OptionsPlacesPage extends PageObject{

    @FindBy(xpath = "//*[@class = 'btn btn-secondary btn-large btn-search']")
    WebElement btnOptionsSearch;

    @FindBy(xpath = "//*[@id='form-filter-places']/div[1]/div[1]/div[3]/div[1]/button/span[1]")
    WebElement ddlTheme;

    @FindBy(xpath = "//*[@id='pricesLevel-2']")
    WebElement chkPriceLevel2;

    @FindBy(xpath = "//*[@id='pricesLevel-3']")
    WebElement chkPriceLevel3;

    @FindBy(xpath = "//*[@id='pricesLevel-4']")
    WebElement chkPriceLevel4;

    @FindBy(xpath="//*[@id='form-filter-places']/div[1]/div[1]/div[3]/div[1]/ul/li/a")
    List<WebElement> dblThemes;

    @FindBy(xpath="//*[@id='facilities-fieldset']/div/div/label")
    List<WebElement> dblFacilities;

    public WebElement getBtnOptionsSearch() {
        return btnOptionsSearch;
    }

    public WebElement getDdlTheme() {
        return ddlTheme;
    }

    public WebElement getChkPriceLevel2() {
        return chkPriceLevel2;
    }

    public WebElement getChkPriceLevel3() {
        return chkPriceLevel3;
    }

    public WebElement getChkPriceLevel4() {
        return chkPriceLevel4;
    }

    public List<WebElement> getDblThemes() {
        return dblThemes;
    }

    public List<WebElement> getDblFacilities() {
        return dblFacilities;
    }
}
