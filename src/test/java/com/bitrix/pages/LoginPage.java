package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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




    public void login(String username, String password)
    {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.logIn.click();
    }
    public void login(String user)
    {
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
}
