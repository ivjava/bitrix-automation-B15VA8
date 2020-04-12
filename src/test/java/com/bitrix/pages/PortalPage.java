package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PortalPage extends TestBase {
    public PortalPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Poll']")
    public WebElement feedOptionPoll;


    @FindBy(xpath = "//span[.='Message']")
    public WebElement feedOptionMsg;

    @FindBy(xpath = "//span[.='Event']")
    public WebElement feedOptionEvent;


    public WebElement getFeedOption(String tab) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//span[.='" + tab + "']"));
        return element;
    }

}

