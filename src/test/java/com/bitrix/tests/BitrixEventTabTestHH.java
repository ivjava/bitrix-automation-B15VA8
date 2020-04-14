package com.bitrix.tests;

import com.bitrix.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BitrixEventTabTestHH extends TestBase {
    @Test
    public void settingEventTest() {
        test = report.createTest("Testing Event tab main Functionality");

        test.info("Log in as Hr user");
        loginPage.login("hr_user");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        test.info("Navigating to Event Tab");
        portalPage.getFeedOption("Event").click();

        test.info("providing the name for event");
        String eventTitle = "test for event- ts= g8-11";
        eventTabPage.eventName.sendKeys(eventTitle);

        test.info("submitting the event");

        eventTabPage.sendButton.click();


        wait.until(ExpectedConditions.elementToBeClickable(eventTabPage.submittedEvenTitle));
        test.info("verifying that event created and title is correct");
        Assert.assertEquals(eventTabPage.submittedEvenTitle.getText(), eventTitle);
        test.pass("event created successfully");


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
        eventTabPage.eventName.sendKeys("Test Case no : 1-12");


        eventTabPage.setReminder.clear();
        test.info("setting event reminder time");
        eventTabPage.setReminder.sendKeys("1");

        Select remiderSelect = new Select(eventTabPage.reminderTimeUnit);
        test.info("setting time uniy for reminder");
        remiderSelect.selectByValue("hour");

        test.info("submitting the event");
        eventTabPage.sendButton.click();
        test.pass("reminder is created");

    }

    @Test
    public void eventMembersTest() {
        test = report.createTest("Testing Event member Functionality");

        test.info("Log in as Hr user");
        loginPage.login("hr_user");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);


        test.info("Navigating to Event Tab");
        portalPage.getFeedOption("Event").click();

        eventTabPage.eventName.sendKeys("Test Case no : 1-13");

        test.info("clicking on member tab");
        eventTabPage.members.click();
        test.info("selecting all employee");
        eventTabPage.allEmployee.click();
        test.info("closing the meember tab");

        eventTabPage.closeMemberButton.click();
        test.info("submitting the event");

        eventTabPage.setReminder.click();
        test.pass("member added to event successfully");

    }


    }

