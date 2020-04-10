package com.bitrix.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BrowserUtils {

    public static WebDriver getDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {  //can do switch -> binary/discrete  options
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            return null;
        }
    }

    /**
     * A utility that takes a String title,
     * changes to tab with given title,
     * if such title is not found, go back to original window
     *
     * @param title
     * @param driver
     */

    public static void findTabByTitle(WebDriver driver, String title) {
        Set<String> windowHandles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals(title)) {
                break;
            } else {
                driver.switchTo().window(currentHandle);
            }
        }

    }

    /**
     * A utility that takes a String url,
     * changes to tab with given url,
     * if such url is not found, go back to original window;
     *
     * @param driver
     * @param url
     */
    public static void findTabByURL(WebDriver driver, String url) {
        Set<String> windowHandles = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().equals(url)) {
                break;
            } else {
                driver.switchTo().window(currentHandle);
            }
        }
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void highlight(WebElement element) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        Thread.sleep(200);
        jse.executeScript("arguments[0].removeAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        Thread.sleep(200);

    }

    public static void scrollDown(int pixels) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("window.scrollBy(0," + pixels + ")");
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     *
     * @param element
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /*
     * takes screenshot - lighter version than above
     * @param name
     * take a name of a test and returns a path to screenshot takes
     */
    public static String getScreenshot(String name) throws IOException {
        // name the screenshot with the current date time to avoid duplicate name
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    /*
takes list of web elements
returns list of strings
 */
    public static List<String> getElementsText(List<WebElement> listEl)
    {
        //given list of webelements, return list of string
        List<String> listSt = new ArrayList<>();

        for (WebElement element : listEl) {
            listSt.add(element.getText());
        }
        return listSt;
    }


}
