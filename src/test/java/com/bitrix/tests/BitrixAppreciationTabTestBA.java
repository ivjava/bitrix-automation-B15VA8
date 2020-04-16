package com.bitrix.tests;

import com.bitrix.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

public class BitrixAppreciationTabTestBA extends TestBase {

    @Test
    public void topicTest(){
        test = report.createTest("Testing Appreciation Topic Functionality");

        test.info("Login as Marketing");
        loginPage.login("marketing_user");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        test.info("Navigating to MORE and click on dropdown button");
        wait.until(ExpectedConditions.elementToBeClickable(portalPage.getFeedOption("More")));
        portalPage.getFeedOption("More").click();

        test.info("click the Appreciation menu under MORE dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(appreciationPage.appreciation)).click();

        test.info("Click on Topic icon");
        if(appreciationPage.topicText.isDisplayed()) {

        }else {
            wait.until(ExpectedConditions.elementToBeClickable(appreciationPage.topicIcon)).click();
        }

        test.info("Verify Topic text is visible");
        assertTrue(appreciationPage.topicText.isDisplayed());

    }

    @Test
    public void insertVideoTabTest(){
        test = report.createTest("Testing Insert Video tab");

        test.info("Login as Marketing");
        loginPage.login("marketing_user");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        test.info("Navigating to MORE and click on dropdown button");
        wait.until(ExpectedConditions.elementToBeClickable(portalPage.getFeedOption("More")));
        portalPage.getFeedOption("More").click();

        test.info("click the Appreciation menu under MORE dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(appreciationPage.appreciation)).click();

        test.info("Click on Insert Video icon");
        wait.until(ExpectedConditions.elementToBeClickable(appreciationPage.insertVideoIcon)).click();

        test.info("Video pop-up asks for - YouTube or Vimeo video URL");
        assertTrue(appreciationPage.videoURL.isDisplayed());
    }

    @Test
    public void tagIconTest(){
        test = report.createTest("Testing Tag Icon");

        test.info("Login as Marketing");
        loginPage.login("marketing_user");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        test.info("Navigating to MORE and click on dropdown button");
        wait.until(ExpectedConditions.elementToBeClickable(portalPage.getFeedOption("More")));
        portalPage.getFeedOption("More").click();

        test.info("click the Appreciation menu under MORE dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(appreciationPage.appreciation)).click();

        test.info("Clicking on # icon");
        wait.until(ExpectedConditions.elementToBeClickable(appreciationPage.tagIcon)).click();

        test.info("Writing \"Hello everyone!\" in the field");
        wait.until(ExpectedConditions.visibilityOf(appreciationPage.tagField)).sendKeys("Hello everyone!");

        test.info("Clicking on ADD button");
        wait.until(ExpectedConditions.elementToBeClickable(appreciationPage.addButton)).click();

        test.info("Verifying tag is created");
        assertTrue(appreciationPage.text.isDisplayed());
    }

    @Test
    public void emojiTest(){
        test = report.createTest("Testing emoji");

        test.info("Login as Marketing");
        loginPage.login("marketing_user");
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();

        test.info("Navigating to MORE and click on dropdown button");
        wait.until(ExpectedConditions.elementToBeClickable(portalPage.getFeedOption("More")));
        portalPage.getFeedOption("More").click();

        test.info("click the Appreciation menu under MORE dropdown");
        wait.until(ExpectedConditions.elementToBeClickable(appreciationPage.appreciation)).click();

        test.info("click on the Visual editor icon");
        wait.until(ExpectedConditions.elementToBeClickable(appreciationPage.visualEditor)).click();

        test.info("clicking on emoji icon");
        wait.until(ExpectedConditions.elementToBeClickable(appreciationPage.smileIcon)).click();

        test.info("Verifying emojis");
        assertTrue(appreciationPage.emojis.isDisplayed());
    }
}
