package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppreciationPage extends TestBase {

    public AppreciationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class=\"menu-popup-items\"]")
    public WebElement dropdown;

    @FindBy(xpath = "//span[.='Appreciation']")
    public WebElement appreciation;

    @FindBy(id = "lhe_button_title_blogPostForm")
    public WebElement topicIcon;

    @FindBy(id = "POST_TITLE")
    public WebElement topicText;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-video']")
    public WebElement insertVideoIcon;

    @FindBy(id = "video_idPostFormLHE_blogPostForm-source")
    public WebElement videoURL;

    @FindBy(id = "bx-b-tag-input-blogPostForm")
    public WebElement tagIcon;

    @FindBy(xpath = "//span[@class='popup-window-button']")
    public WebElement addButton;

    @FindBy(id = "TAGS_blogPostForm67abSn")
    public WebElement tagField;

    @FindBy(xpath = "//span[@class='feed-add-post-tags']")
    public WebElement text;

    @FindBy (id = "lhe_button_editor_blogPostForm")
    public WebElement visualEditor;

    @FindBy(xpath = "//span[@class='bxhtmled-top-bar-btn bxhtmled-button-smile']")
    public WebElement smileIcon;

    @FindBy(xpath = "//img[@class='bxhtmled-smile-img']")
    public WebElement emojis;
}
