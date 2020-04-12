package com.bitrix.tests;

import com.bitrix.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BitrixPollTabPageTestsIV extends TestBase {


    @Test
    public void addQuestionTest()
    {
        test = report.createTest("Poll Page - Add question Test (hr_user)");
        test.info("Login as hr_user");
        loginPage.login("hr_user");
        test.info("Navigating to Poll Menu");
        wait.until(ExpectedConditions.elementToBeClickable(portalPage.feedOptionPoll));
        portalPage.getFeedOption("Poll").click();
        wait.until(ExpectedConditions.elementToBeClickable(pollTabPage.addQuestion));
        test.info("Clicking Add Question Button");
        pollTabPage.addQuestion.click();
        WebElement questionBox1 = pollTabPage.findQbox("1");
        test.info("Validate New Question Box Generated");
        Assert.assertTrue(questionBox1.isDisplayed());
        test.pass("PASS: Second Question Box added successfully");

    }

}
