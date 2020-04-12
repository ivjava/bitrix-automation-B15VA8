package com.bitrix.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.bitrix.pages.LoginPage;
import com.bitrix.pages.PollPage;
import com.bitrix.pages.PortalPage;
import com.bitrix.pages.TaskPage;
import com.bitrix.utilities.BrowserUtils;
import com.bitrix.utilities.ConfigurationReader;
import com.bitrix.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.io.IOException;

public abstract class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected LoginPage loginPage;
    protected PollPage pollPage;
    protected PortalPage portalPage;
    protected TaskPage taskPage;

    protected ExtentReports report; //will only it here
    private ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeSuite
    public void setUpSuite()
    {
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
//
    //@Parameters("url")
    @BeforeMethod()
    public void setUpMethod(@Optional String url) {
        System.out.println("url = " + url);
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        softAssert = new SoftAssert();

        if (url == null) {
            driver.get(ConfigurationReader.getProperty("url"));
        } else {
            driver.get(ConfigurationReader.getProperty(url));
        }

        loginPage = new LoginPage();
        pollPage = new PollPage();
        portalPage = new PortalPage();
        taskPage=new TaskPage();

    }

    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult) throws IOException {

        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            test.fail(iTestResult.getName());
            String screenshot = BrowserUtils.getScreenshot(iTestResult.getName());
            test.addScreenCaptureFromPath(screenshot);
        }

        Driver.closeDriver();
        softAssert.assertAll();
    }
}
