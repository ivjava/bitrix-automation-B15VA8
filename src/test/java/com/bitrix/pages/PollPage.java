package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PollPage extends TestBase {
    public PollPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#question_0")
    public WebElement questionBox;
    // input[id^='question_']

    @FindBy(linkText = "Add question")
    public WebElement addQuestion;




    public WebElement findQbox(String number)
    {
        WebElement questionBoxN = Driver.getDriver().findElement(By.cssSelector("#question_" + number + ""));
        return questionBoxN;
    }


}
