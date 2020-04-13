package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageTabPage extends TestBase {
    public MessageTabPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement message;

    @FindBy(xpath = "//span[@title='Link']")
    public WebElement linkIcon;

    @FindBy(id = "linkidPostFormLHE_blogPostForm-text")
    public WebElement linkText;

    @FindBy(id = "linkidPostFormLHE_blogPostForm-href")
    public WebElement linkURL;

    @FindBy(xpath = "//input[@id='undefined']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;


    public WebElement getFeedOption(String tab) {
        return Driver.getDriver().findElement(By.xpath("//span[.='" + tab + "']"));
    }
}

