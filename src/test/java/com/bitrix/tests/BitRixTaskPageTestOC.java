package com.bitrix.tests;

import com.bitrix.base.TestBase;
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

        WebElement task = driver.findElement(By.xpath("//span[.='Task']"));
        task.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[13]")));
        WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[13]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(checkbox).click().build().perform();

        Assert.assertTrue(checkbox.isDisplayed());
    }
}
