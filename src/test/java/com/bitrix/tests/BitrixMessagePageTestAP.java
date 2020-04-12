package com.bitrix.tests;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bitrix.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BitrixMessagePageTestAP extends TestBase {

    @Test
    public void clickOnLinkIcon() throws InterruptedException {
        test = report.createTest("Message Tab - Clicking on link icon");

        test.info("Log in as helpdesk");
        loginPage.login("helpdesk_user");

        test.info("Navigating to Message Menu");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.elementToBeClickable(portalPage.feedOptionMsg));
        portalPage.getFeedOption("Message").click();

        test.info("Clicking on link icon");
        messageTabPage.linkIcon.click();

        test.info("Attaching the link URL");
        messageTabPage.linkURL.sendKeys(" https://www.youtube.com/watch?v=dyhHMQp5S5k");

        test.info("Clicking Save button");
        wait.until(ExpectedConditions.elementToBeClickable(messageTabPage.saveButton));
        messageTabPage.saveButton.click();

        test.info("Clicking on Send button");
        wait.until(ExpectedConditions.elementToBeClickable(messageTabPage.sendButton));
        messageTabPage.sendButton.click();
        test.pass("PASS: Link attached successfully");
    }
}