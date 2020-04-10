package com.bitrix.tests;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BitrixPollPageTestsIV extends TestBase {


    @Test
    public void logInTest()
    {
        test = report.createTest("Login Method Test (hr_user)");
        test.info("Testing Login method");
        loginPage.login("hr_user");
        Assert.assertTrue(driver.getTitle().contains("Portal"));
        test.pass("Log in successful");

    }

}
