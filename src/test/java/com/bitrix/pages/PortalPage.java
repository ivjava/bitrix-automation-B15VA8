package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortalPage extends TestBase {
    public PortalPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Poll']")
    public WebElement feedOptionPoll;


    @FindBy(xpath = "//span[.='Message']")
    public WebElement feedOptionMsg;


    @FindBy(xpath = "//span[@class='menu-popup-item-text']")
    public WebElement menuPopUp;

    @FindBy(css = "#user-block")
    public WebElement userBlock;

    @FindBy(xpath = "//span[.='Event']")
    public WebElement feedOptionEvent;

    public WebElement getFeedOption(String tab) {
        return Driver.getDriver().findElement(By.xpath("//span[.='" + tab + "']"));
    }

    /***
     * Method navigates to pop up menu item by number ->
     * 1 - My profile
     * 2 - Edit profile
     * 3 - themes
     * 4 - Configure
     * 5 - Log out
     * @param itemNumber - select from 1-5
     */
    public void selectPopMenu(String itemNumber)
    {
        userBlock.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(menuPopUp));
        Driver.getDriver().findElement(By.xpath("(//span[@class='menu-popup-item-text'])["+itemNumber+"]")).click();
    }

    /***
     * Method logs out of the application
     */

    public void logOut() {
        userBlock.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(menuPopUp));
        Driver.getDriver().findElement(By.xpath("(//span[@class='menu-popup-item-text'])[5]")).click();
    }
}

