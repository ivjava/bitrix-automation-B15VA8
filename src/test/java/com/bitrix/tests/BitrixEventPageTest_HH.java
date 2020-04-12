package com.bitrix.tests;

import com.bitrix.base.TestBase;
import com.bitrix.pages.EventPage;
import com.bitrix.pages.LoginPage;
import com.bitrix.pages.PortalPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BitrixEventPageTest_HH extends TestBase {

    @Test
    public void reminderTest (){
        test = report.createTest("Testing Event Reminder Functionality");

        test.info("Log in as Hr user");
        loginPage.login("hr_user");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        test.info("Navigating to Event Tab");
        portalPage.getFeedOption("Event").click();

        eventPage.setReminder.clear();
        eventPage.setReminder.sendKeys("30");











    }
}
