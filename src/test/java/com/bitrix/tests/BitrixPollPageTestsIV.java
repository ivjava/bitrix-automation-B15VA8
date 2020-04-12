package com.bitrix.tests;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BitrixPollPageTestsIV extends TestBase {

    @Test
    public void logInTest() {
        report.createTest("Basic Log In test");
        test.info("Testing Login Method (hr_user)");
            loginPage.login("hr_user");
        test.pass("PASS: logged in successfully");

    }
}
