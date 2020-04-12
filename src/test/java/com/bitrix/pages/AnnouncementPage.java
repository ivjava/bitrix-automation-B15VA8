package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnnouncementPage extends TestBase {
    public AnnouncementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class=\"menu-popup-items\"]")
    public WebElement dropdown;

    @FindBy(xpath = "//span[.='Announcement']")
    public WebElement announcement;

    @FindBy(xpath = "//span[.='show announcement:']")
    public WebElement text;


    public WebElement findIcon(String title) {
        WebElement icon = Driver.getDriver().findElement(By.xpath("//span[@title ='"+title+"']"));
        return icon;
    }




}
