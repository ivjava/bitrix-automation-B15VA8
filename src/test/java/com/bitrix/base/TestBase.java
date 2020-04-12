package com.bitrix.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.bitrix.pages.*;

import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


public abstract class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected LoginPage loginPage;

    protected PollTabPage pollTabPage;
    protected PortalPage portalPage;
    protected TaskTabPage taskPage;

    protected MessageTabPage messageTabPage;

    static protected ExtentReports report;
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;
    protected EventPage eventPage;

    @BeforeSuite
    public void setUpSuite() {
        report = new ExtentReports();
        String path = System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setReportName("Bitrix B15VA8 Automated Tests");

        report.attachReporter(htmlReporter);
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));

    }

    @AfterSuite
    public void tearDownSuite()
    {
        report.flush();
    }

    @BeforeMethod()
    public void setUpMethod(@Optional String url) {
        //System.out.println("url = " + url);
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        softAssert = new SoftAssert();

        if (url == null) {
            driver.get(ConfigurationReader.getProperty("url"));
        } else {
            driver.get(ConfigurationReader.getProperty(url));
        }
        loginPage = new LoginPage();
        portalPage = new PortalPage();
        messageTabPage = new MessageTabPage();

        loginPage = new LoginPage();
        pollTabPage = new PollTabPage();
        portalPage = new PortalPage();

        loginPage = new LoginPage();
        pollTabPage = new PollTabPage();
        portalPage = new PortalPage();
        taskPage=new TaskTabPage();
        eventPage = new EventPage();

    }

    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult) throws Exception {

        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            test.fail(iTestResult.getName());
            String screenshot = BrowserUtils.getScreenshot(iTestResult.getName());
            test.addScreenCaptureFromPath(screenshot);
        }

        Driver.closeDriver();
        softAssert.assertAll();
    }
}
