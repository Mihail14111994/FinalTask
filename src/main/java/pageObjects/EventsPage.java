package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventsPage extends PageObject{
    @FindBy(xpath = "//*[@id='events-exhibition']/div/div[2]/div/div[2]/div/div[1]/a")
    List<WebElement> listExhibitions;
//#events-party div.display-tr.oneline.buttons > a.btn.btn-tiny.btn-generic.btn-fixed
    @FindBy(xpath = "//*[@id='events-party']/div/div[2]/div/div[2]/div/div[1]/a")
    List<WebElement> listParties;

    @FindBy(xpath = "//*[@id='events-sports']/div/div/div/div[2]/div/div[1]/a")
    List<WebElement> listSports;

    @FindBy(xpath = "//div[@id='content']/div//div/h2")
    List <WebElement> listSections;

    @FindBy(css="#events-sports div.display-tr.oneline.buttons > a")
    List <WebElement> listBtnDetailsSport;

    @FindBy(css="#events-exhibition div.display-tr.oneline.buttons > a")
    List <WebElement> listBtnDetailsExhibitions;

    @FindBy(css = "div.context-wrap div:nth-child(5) > h2")
    WebElement hdrInfo;

    @FindBy(css="#toggle-event-reminder-panel")
    WebElement btnAlarm;

    @FindBy(css = "div.selectbox.dropdown.short.select > button")
    WebElement ddAlarmReminder;

    @FindBy(css="div.selectbox.dropdown.short.select.open > ul >li > a")
    List<WebElement> listDdAlarmReminder;

    @FindBy (css = "#formReminder_btn-submit")
    WebElement btnSubmitReminder;

    @FindBy (css= "#section-reminders > div.list > div > button")
    List <WebElement> btnDeleteReminder;

    public List<WebElement> getBtnDeleteReminder() {
        return btnDeleteReminder;
    }

    public WebElement getBtnSubmitReminder() {
        return btnSubmitReminder;
    }

    public WebElement getBtnAlarm() {
        return btnAlarm;
    }

    public WebElement getHdrInfo() {
        return hdrInfo;
    }

    public List<WebElement> getListExhibitions() {
        return listExhibitions;
    }

    public List<WebElement> getListParties() {
        return listParties;
    }

    public List<WebElement> getListSports() {
        return listSports;
    }

    public List<WebElement> getListBtnDetailsSport() {
        return listBtnDetailsSport;
    }

    public List<WebElement> getListBtnDetailsExhibitions() {
        return listBtnDetailsExhibitions;
    }

    public List<WebElement> getListSections() {
        return listSections;
    }

    public WebElement getDdAlarmReminder() {
        return ddAlarmReminder;
    }

    public List<WebElement> getListDdAlarmReminder() {
        return listDdAlarmReminder;
    }
}
