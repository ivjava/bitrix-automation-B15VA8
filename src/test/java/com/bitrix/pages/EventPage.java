package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.Driver;
import org.jsoup.select.Evaluator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EventPage extends TestBase {

    public EventPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "feed-cal-event-namecal_3Jcl")
    public WebElement eventName;


    @FindBy (className = "feed-event-date-label")
    public WebElement eventStartTime;

    @FindBy (id = "event-remind_typecal_3Jcl")
    public WebElement reminderTimeUnit;

    @FindBy (id = "event-remind_countcal_3Jcl")
    public WebElement setReminder;

    @FindBy (id = "event-locationcal_3Jcl")
    public WebElement location;

    @FindBy (className = "Central Meeting Room")
    public WebElement centralRoom;

    @FindBy (id = "feed-event-dest-add-link")
    public WebElement members;

    @FindBy (id = "calnAJEM3_last_UA")
    public WebElement allEmployee;

    @FindBy (xpath = "//span[@class='popup-window-close-icon']")
    public WebElement closeMemberButton;

    @FindBy (id = "blog-submit-button-save")
    public WebElement sendButton;





}
