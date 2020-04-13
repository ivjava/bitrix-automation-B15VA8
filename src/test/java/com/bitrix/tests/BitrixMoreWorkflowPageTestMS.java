package com.bitrix.tests;

import com.bitrix.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BitrixMoreWorkflowPageTestMS extends TestBase {

    @Test
    public void verifyWorkflow() throws InterruptedException {
        test = report.createTest("MORE - Workflow (HR_user)");

        test.info("Login as hr_user");
        loginPage.login("hr_user");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        test.info("Navigating to MORE Tab");
        portalPage.getFeedOption("More").click();

        test.info("Open the dropdown menu under tab MORE");
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(workflowPage.dropdown)).click();

        test.info("select Workflow under tab MORE");
        wait.until(ExpectedConditions.elementToBeClickable(workflowPage.workflow)).click();


    }
}
