package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkflowPage extends TestBase {

   public WorkflowPage() {
       PageFactory.initElements(Driver.getDriver(), this);
  }

   @FindBy(id = "feed-add-post-form-link-text")
    public WebElement dropdown;

    @FindBy(xpath = "//*[@id='popup-window-content-menu-popup-feed-add-post-form-popup']/div/div/span[4]")
    public WebElement workflow;




    }
