package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage extends PollPage {
    public TaskPage(){
        PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(xpath = "(//input[@type='checkbox'])[13]")
    public WebElement checkBoxHighPriority;
}
