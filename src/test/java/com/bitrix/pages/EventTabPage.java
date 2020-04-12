package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.Driver;
import org.jsoup.select.Evaluator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EventTabPage extends TestBase {

    public EventTabPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (className = "feed-event-date-label")
    public WebElement eventStartTime;

    @FindBy (id = "event-remind_typecal_3Jcl")
    public WebElement reminderTimeUnit;

    @FindBy (id = "event-remind_countcal_3Jcl")
    public WebElement setReminder;



}
