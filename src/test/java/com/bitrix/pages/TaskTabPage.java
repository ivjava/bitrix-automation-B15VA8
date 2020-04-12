package com.bitrix.pages;

import com.bitrix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskTabPage extends PollTabPage {
    public TaskTabPage(){
        PageFactory.initElements(Driver.getDriver(), this); }

    @FindBy(xpath = "(//input[@type='checkbox'])[13]")
    public WebElement checkBoxHighPriority;
}
