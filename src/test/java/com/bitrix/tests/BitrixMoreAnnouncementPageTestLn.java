package com.bitrix.tests;

import com.bitrix.base.TestBase;
import com.bitrix.pages.AnnouncementPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BitrixMoreAnnouncementPageTestLn extends TestBase {

    //.US7 As a user, I should be able to send annoucement from Annoucement
    // subheadding from "More" under Activity Stream.

    @Test
    public void verifyAnnouncement() throws InterruptedException {
        test = report.createTest("MORE - Announcement (marketing_user)");

        test.info("Login as a user from marketing department");
        loginPage.login("marketing_user");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        test.info("Navigate to tab MORE");
        portalPage.getFeedOption("More").click();

        test.info("Get the dropdown menu under tab MORE");
        WebElement dropdown = driver.findElement(By.xpath("//div[@class=\"menu-popup-items\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();


        test.info("select Announcement under tab MORE");
        WebElement announcement = driver.findElement(By.xpath("//span[.='Announcement']"));
        wait.until(ExpectedConditions.elementToBeClickable(announcement)).click();


        test.info("Verify that Announcement page has text - show announcement: ");
        WebElement text = driver.findElement(By.xpath("//span[.='show announcement:']"));

        test.info("Text sucessfully verified");
        Assert.assertTrue(text.isDisplayed());


    }
}