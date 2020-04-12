package com.bitrix.pages;

import com.bitrix.base.TestBase;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PollTabPage extends TestBase {
    public PollTabPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#question_0")
    public WebElement questionBox;
    // input[id^='question_']

    @FindBy(linkText = "Add question")
    public WebElement addQuestion;




    public WebElement findQbox(String number)
    {
       return Driver.getDriver().findElement(By.cssSelector("#question_" + number + ""));
    }


}
