package com.solvd.carina.articlefinder.testutil;

import com.solvd.carina.articlefinder.util.ActionUtils;
import com.solvd.carina.articlefinder.util.AnsiCodes;
import com.solvd.carina.articlefinder.util.ExceptionUtils;
import com.solvd.carina.articlefinder.util.OperatingSystem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

public class DriverUtils {
    private static final Logger LOGGER = LogManager.getLogger(TestClassConstants.DRIVER_UTILS);

    private DriverUtils() {
        ExceptionUtils.preventConstantsInstantiation();
    }

    /*
        navigate() actions
    */

    public static String navTo(WebDriver driver, String url) {
        driver.navigate().to(url);
        return driver.getCurrentUrl();
    }

    public static String navBack(WebDriver driver) {
        driver.navigate().back();
        return driver.getCurrentUrl();
    }

    public static String navForward(WebDriver driver) {
        driver.navigate().forward();
        return driver.getCurrentUrl();
    }

    public static String navTo(WebDriver driver, URL url) {
        driver.navigate().to(url);
        return driver.getCurrentUrl();
    }

    public static String refreshPage(WebDriver driver) {
        driver.navigate().refresh();
        return driver.getCurrentUrl();
    }

    public static String goToUrl(WebDriver driver, String url) {
        driver.get(url);
        return driver.getCurrentUrl();
    }

    public static String goToUrl(WebDriver driver, URL url) {
        return goToUrl(driver, url.toString());
    }

    /*
        iframe
    */
    public static void switchToFrame(WebDriver driver, String frameId) {
        driver.switchTo().frame(frameId);
    }

    public static void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    public static void switchToRootFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    /*
        tabs and window selection, closing
    */

    public static String getCurrentWindowHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public static String getCurrentTabId(WebDriver driver) {
        return getCurrentWindowHandle(driver);
    }

    public static Set<String> getAllWindowHandles(WebDriver driver) {
        return driver.getWindowHandles();
    }

    public static Set<String> getAllTabIds(WebDriver driver) {
        return getAllWindowHandles(driver);
    }

    public static void switchToWindow(WebDriver driver, String windowHandle) {
        // get window handle with getCurrentWindowHandle()
        driver.switchTo().window(windowHandle);
    }

    public static void switchToAlertPrompt(WebDriver driver) {
        driver.switchTo().alert();
    }

    public static String openNewBlankTab(WebDriver driver) {
        driver.switchTo().newWindow(WindowType.TAB);
        return driver.getWindowHandle();
    }

    public static String openNewTabAndGoToUrl(WebDriver driver, String url) {
        // currWindowHandle is the current tab id
        String currentWindowHandle = openNewBlankTab(driver);
        driver.get(url);
        return currentWindowHandle;
    }

    public static String openNewBlankWindow(WebDriver driver) {
        driver.switchTo().newWindow(WindowType.WINDOW);
        return driver.getWindowHandle();
    }

    public static String clickLinkAndOpenInNewTab(WebDriver driver, WebElement element) {
        return clickLinkAndOpenInNewTab(
                driver,
                element,
                OperatingSystem.getOperatingSystem()
        );
    }

    public static String clickLinkAndOpenInNewTab(
            WebDriver driver, WebElement element,
            OperatingSystem operatingSystem
    ) {
        // get the current set of window handles
        LOGGER.info("{}Getting initialTabIds{}", AnsiCodes.RED_ON_YELLOW, AnsiCodes.RESET_ALL);
        Set<String> initialTabIdsSet = getAllWindowHandles(driver);

        // set the OS-appropriate action
        LOGGER.info("{}Setting the OS appropriate action{}", AnsiCodes.RED_ON_YELLOW, AnsiCodes.RESET_ALL);
        Action clickLinkAndOpenInNewTabAction;
        if (operatingSystem.equals(OperatingSystem.MAC)) {
            LOGGER.info("{}MAC DETECTED, doing command and click{}", AnsiCodes.RED_ON_YELLOW, AnsiCodes.RESET_ALL);
            clickLinkAndOpenInNewTabAction =
                    ActionUtils.commandAndClick(driver, element);
        } else {
            LOGGER.info("{}NON MAC DETECTED, doing control and click{}", AnsiCodes.RED_ON_YELLOW, AnsiCodes.RESET_ALL);
            clickLinkAndOpenInNewTabAction =
                    ActionUtils.controlAndClick(driver, element);
        }

        // perform the action
        LOGGER.info("{}performing action to click link and open in new tab{}", AnsiCodes.RED_ON_YELLOW, AnsiCodes.RESET_ALL);
        clickLinkAndOpenInNewTabAction.perform();


        // wait until new tab is detected
        explicitlyWait(
                driver,
                Duration.ofSeconds(10),
                Duration.ofMillis(100),
                ExpectedConditions.numberOfWindowsToBe(initialTabIdsSet.size() + 1));


        // isolate the new tab id by removing all the previous ids from a new set
        Set<String> newTabIdsSet = getAllTabIds(driver);
        newTabIdsSet.removeAll(initialTabIdsSet);

        // return the tab id String
        return newTabIdsSet.iterator().next();
    }


    public static String openNewWindowAndGoToUrl(WebDriver driver, String url) {
        String currentWindowHandle = openNewBlankWindow(driver);
        driver.get(url);
        return currentWindowHandle;
    }

    public static void switchToTab(WebDriver driver, String tabId) {
        switchToWindow(driver, tabId);
    }

    public static void closeWindow(WebDriver driver) {
        driver.close();
    }

    public static void closeTab(WebDriver driver) {
        closeWindow(driver);
    }

    /*
        window() actions
    */

    public static void setWindowSize(WebDriver driver, Dimension windowDimensions) {
        driver.manage().window().setSize(windowDimensions);

    }

    public static void setWindowSize(WebDriver driver, int width, int height) {
        Dimension windowDimensions = new Dimension(width, height);

        setWindowSize(
                driver,
                windowDimensions
        );
    }

    public static Dimension getWindowDimensions(WebDriver driver) {
        return driver.manage().window().getSize();
    }

    public static int getWindowWidth(WebDriver driver) {
        return getWindowDimensions(driver).getWidth();
    }

    public static int getWindowHeight(WebDriver driver) {
        return getWindowDimensions(driver).getHeight();
    }

    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void minimizeWindow(WebDriver driver) {
        driver.manage().window().minimize();
    }

    public static void enterFullScreenMode(WebDriver driver) {
        driver.manage().window().fullscreen();
    }

    public static void escapeFullScreenMode(WebDriver driver) {
        // can implement a context here later, and set a boolean to track
        // whether in full screen mode or not
        ActionUtils.escape(driver).perform();
    }

    public static void exitFullScreenMode(WebDriver driver) {
        maximizeWindow(driver);
    }

    public static void exitFullScreenMode(WebDriver driver, Dimension windowDimensions) {
        setWindowSize(driver, windowDimensions);
    }

    public static void exitFullScreenMode(WebDriver driver, int width, int height) {
        Dimension windowDimensions = new Dimension(width, height);

        exitFullScreenMode(driver, windowDimensions);
    }

    /*
        Cookies
    */

    public static Set<Cookie> getCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    public static Cookie getCookieByName(WebDriver driver, String cookieName) {
        return driver.manage().getCookieNamed(cookieName);
    }

    public static void addCookie(WebDriver driver, Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    public static void deleteCookie(WebDriver driver, Cookie cookie) {
        driver.manage().deleteCookie(cookie);
    }

    public static void deleteCookieByName(WebDriver driver, String cookieName) {
        driver.manage().deleteCookieNamed(cookieName);
    }

    public static void deleteAllCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    /*
        Other
    */
    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    /*
        Waits
    */

    public static void explicitlyWait(
            WebDriver driver,
            Duration timeoutDuration,
            Duration pollingIntervalDuration,
            Function<WebDriver, Boolean> condition
    ) {
        new WebDriverWait(driver, timeoutDuration)
                .pollingEvery(pollingIntervalDuration)
                // this 'until' action will be  executed every pollingIntervalMillis
                // and this wait will stop after timeoutSeconds seconds
                // will stop if the spinner disappears
                .until(condition);

        /* Example
                new WebDriverWait(driver, Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                // this action will be  executed every 100ms, and this wait will stop after 10 seconds
                // the action will disappear once the spinner element is present
                .until(d -> spinner.isElementPresent(1));

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                // this action will be  executed every 100ms, and this wait will stop after 10 seconds
                // will stop if the spinner disappears
                .until(d -> !spinner.isElementPresent(1));
        */
    }

    public static void explicitlyWait(
            WebDriver driver,
            long timeoutSeconds,
            long pollingIntervalMillis,
            Function<WebDriver, Boolean> condition
    ) {
        explicitlyWait(
                driver,
                Duration.ofSeconds(timeoutSeconds),
                Duration.ofMillis(pollingIntervalMillis),
                condition
        );
    }

    public static void implicitlyWait(WebDriver driver, long timeoutSeconds) {
        implicitlyWait(
                driver,
                Duration.ofSeconds(timeoutSeconds)
        );
    }

    public static void implicitlyWait(WebDriver driver, Duration timeoutDuration) {
        driver.manage()
                .timeouts()
                .implicitlyWait(timeoutDuration);
    }
}
