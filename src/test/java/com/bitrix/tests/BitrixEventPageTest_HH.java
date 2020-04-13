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
    public void settingEventTest() {
        test = report.createTest("Testing Event tab main Functionality");

        test.info("Log in as Hr user");
        loginPage.login("hr_user");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        test.info("Navigating to Event Tab");
        portalPage.getFeedOption("Event").click();

        test.info("providing the name for event");
        eventPage.eventName.sendKeys("Test Case no : 1-11");

        test.info("submitting the event");

        eventPage.sendButton.click();


    }

    @Test
    public void reminderTest() {
        test = report.createTest("Testing Event reminder Functionality");

        test.info("Log in as Hr user");
        loginPage.login("hr_user");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        test.info("Navigating to Event Tab");
        portalPage.getFeedOption("Event").click();

        test.info("providing the name for the event");
        eventPage.eventName.sendKeys("Test Case no : 1-12");


        eventPage.setReminder.clear();
        test.info("setting event reminder time");
        eventPage.setReminder.sendKeys("1");

        Select remiderSelect = new Select(eventPage.reminderTimeUnit);
        test.info("setting time uniy for reminder");
        remiderSelect.selectByValue("hour");

        test.info("submitting the event");
        eventPage.sendButton.click();

    }

    @Test
    public void eventMembersTest() {
        test = report.createTest("Testing Event member Functionality");

        test.info("Log in as Hr user");
        loginPage.login("hr_user");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        test.info("Navigating to Event Tab");
        portalPage.getFeedOption("Event").click();

        eventPage.eventName.sendKeys("Test Case no : 1-13");

        test.info("clicking on member tab");
        eventPage.members.click();
        test.info("selecting all employee");
        eventPage.allEmployee.click();
        test.info("closing the meember tab");

        eventPage.closeMemberButton.click();
        test.info("submitting the event");

        eventPage.sendButton.click();

    }

}