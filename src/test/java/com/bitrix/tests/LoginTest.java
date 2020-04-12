package com.bitrix.tests;

import com.bitrix.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class LoginTest extends TestBase {

    @Test
    public void logInTest()
    {
        test = report.createTest("Login Method Test (hr_user)");
        test.info("Logging in as hr_user");
        loginPage.login("hr_user");
        test.info("Verifying Page Title");
        Assert.assertTrue(driver.getTitle().contains("Portal"), "Expected: Portal");
        test.pass("PASS: Log in successful");

    }

    @Test
    public void logOutTest()
    {
        {
            test = report.createTest("LogOut Method Test (hr_user)");
            test.info("Logging in as hr_user");
            loginPage.login("hr_user");
            test.info("Verifying Portal Page Title");
            Assert.assertTrue(driver.getTitle().contains("Portal"), "Expected: Portal");
            loginPage.selectPopMenu("5");
            test.info("Verifying Authorization Page Title");
            Assert.assertEquals(driver.getTitle(), "Authorization");
            test.pass("PASS: Log Out successful");

        }
    }



}
