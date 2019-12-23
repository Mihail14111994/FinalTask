package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageObject{

    @FindBy(xpath = "//button[@id='btn-delete-account']")
    private WebElement btnDeleteAccount;

    @FindBy(xpath = "//button[@id='btn-edit-personaldata']")
    private WebElement btnEditPersonalData;

    @FindBy(xpath = "//a[@class='btn btn-generic btn-tiny']")
    private WebElement linkModifyPassword;

    @FindBy(xpath = "//div[contains(@class, 'float-right')]//div[@class='bar-item inlined username']")
    private WebElement ddUser;

    @FindBy(xpath = "//*[@id='header']/div[2]/div[1]/ul/li[2]/a" )
    private WebElement btnOpenMyAccountPage;

    @FindBy(xpath = "//*[@id='header']/div[2]/div[1]/ul/li[4]/a" )
    private WebElement btnLogout;

    public WebElement getBtnDeleteAccount() {
        return btnDeleteAccount;
    }

    public WebElement getBtnEditPersonalData() {
        return btnEditPersonalData;
    }

    public WebElement getLinkModifyPassword() {
        return linkModifyPassword;
    }

    public WebElement getDdUser() {
        return ddUser;
    }

    public WebElement getBtnOpenMyAccountPage() {
        return btnOpenMyAccountPage;
    }

    public WebElement getBtnLogout() {
        return btnLogout;
    }
}
