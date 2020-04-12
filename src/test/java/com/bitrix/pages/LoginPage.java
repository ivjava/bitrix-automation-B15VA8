package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class LoginPage extends TestBase {
    public LoginPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement username;

    @FindBy(name = "USER_PASSWORD")
    public WebElement password;

    @FindBy(css = ".login-btn")
    public WebElement logIn;

    @FindBy(xpath = "//span[@class='menu-popup-item-text']")
    public WebElement menuPopUp;

    @FindBy(css = "#user-block")
    public WebElement userBlock;



    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.logIn.click();
    }
    public void login(String user) {
        String username;
        String password;
        switch (user) {
            case "hr_user":
                username = ConfigurationReader.getProperty("hr_user");
                password = ConfigurationReader.getProperty("password");
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                this.logIn.click();
                break;
            case "marketing_user":
                username = ConfigurationReader.getProperty("marketing_user");
                password = ConfigurationReader.getProperty("password");
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                this.logIn.click();
                break;
            case "helpdesk_user":
                username = ConfigurationReader.getProperty("helpdesk_user");
                password = ConfigurationReader.getProperty("password");
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                this.logIn.click();
                break;
            default:
                System.out.println("ERROR: Invalid user type provided!");

        }
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
        Driver.getDriver().findElement(By.cssSelector("#user-block")).click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //Driver.getDriver().manage().window().fullscreen();
        wait.until(ExpectedConditions.elementToBeClickable(menuPopUp));
        Driver.getDriver().findElement(By.xpath("(//span[@class='menu-popup-item-text'])["+itemNumber+"]")).click();
    }
}


