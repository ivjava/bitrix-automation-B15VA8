package com.bitrix.tests;

import com.bitrix.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void logInTest()
    {
        test = report.createTest("Login Method Test (hr_user)");
        test.info("logging in as hr_user");
        loginPage.login("hr_user");
        test.info("Verifying Page Title");
        Assert.assertTrue(driver.getTitle().contains("Portal"), "Expected: Portal");
        test.pass("Log in successful");

    }


}
