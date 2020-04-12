package com.bitrix.tests;

import com.bitrix.base.TestBase;
import com.bitrix.pages.PortalPage;
import com.bitrix.pages.TaskPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BitRixTaskPageTestOC extends TestBase {
    @Test
    public void test() {
        loginPage.login("hr_user");
        portalPage.getFeedOption("Task").click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[13]")));
        taskPage.checkBoxHighPriority.click();
        Assert.assertTrue(taskPage.checkBoxHighPriority.isSelected());
    }
}
