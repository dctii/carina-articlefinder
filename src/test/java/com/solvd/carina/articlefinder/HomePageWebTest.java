package com.solvd.carina.articlefinder;

import com.solvd.carina.articlefinder.exception.WindowTabNotFoundException;
import com.solvd.carina.articlefinder.testutil.TestClassConstants;
import com.solvd.carina.articlefinder.testutil.WebTestConstants;
import com.solvd.carina.articlefinder.testutil.WebTestUtils;
import com.solvd.carina.articlefinder.util.ConfigConstants;
import com.solvd.carina.articlefinder.util.StringConstants;
import com.solvd.carina.articlefinder.web.HomePage;
import com.solvd.carina.articlefinder.web.components.homepage.HomeMasterHeader;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageWebTest extends AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(TestClassConstants.HOME_PAGE_WEB_TEST);

    private static final String EXPECTED_HOME_URL =
            Configuration.getRequired(ConfigConstants.NYT_HOME_URL_KEY)
                    + StringConstants.SOLIDUS;

    @Test(description = "Check if master header elements all exist")
    public void validateHomeMasterHeaderElementsPresent() {
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);

        page.open();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                EXPECTED_HOME_URL,
                "Actual url does not match expected."
        );

        Assert.assertEquals(
                driver.getTitle(),
                WebTestConstants.EXPECTED_HOME_PAGE_TITLE,
                "Actual title does not match expected."
        );

        HomeMasterHeader homeMasterHeader = page.getMasterHeader();

        Assert.assertTrue(
                homeMasterHeader.isHeaderLogoPresent(),
                "Header logo is not present."
        );

        Assert.assertTrue(
                homeMasterHeader.isSearchButtonButtonPresent(),
                "Search button is not present."
        );

        Assert.assertTrue(
                homeMasterHeader.isDesktopSectionsButtonPresent(),
                "Desktop sections button is not present."
        );

        Assert.assertTrue(
                homeMasterHeader.isTodayDateDisplayPresent(),
                "Today date display is not present."
        );

        Assert.assertTrue(
                homeMasterHeader.isTodayPaperLinkPresent(),
                "Today paper link button is present."
        );

        Assert.assertTrue(
                homeMasterHeader.isSubscribeButtonPresent(),
                "Subscribe button is not present."
        );

        Assert.assertTrue(
                homeMasterHeader.isLogInButtonPresent(),
                "Log In button is not present."
        );
    }

    @Test(description = "Check if today's date is today's date per New York time")
    public void validateTodayDatePerNewYork() {
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);

        page.open();

        HomeMasterHeader homeMasterHeader = page.getMasterHeader();

        Assert.assertTrue(
                WebTestUtils.isMatchingCurrentNewYorkDate(
                        homeMasterHeader.getTodayDateDisplayTextString()
                ),
                "Today date not matching current New York Date"
        );
    }

    @Test(description = "Validate opening and closing the home page in a new tab")
    public void validateNewHomePageTab() {
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);
        page.open();

        // get originalTab
        String originalTab = driver.getWindowHandle();
        int numberOfTabsOpen = driver.getWindowHandles().size();

        HomeMasterHeader homeMasterHeader = page.getMasterHeader();

        // NOTE: need to see if we can open the new tab without JS, but with CMD+CLICK or CTRL+CLICK
        ((JavascriptExecutor) driver).executeScript(
                "window.open(arguments[0]);",
                homeMasterHeader.getHeaderLogoHref()
        );

        // validate that two tabs have been opened
        Assert.assertEquals(driver.getWindowHandles().size(), numberOfTabsOpen + 1);

        // get the new tab handle and switch to it
        String newTab = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(originalTab))
                .findFirst()
                .orElseThrow(() -> new WindowTabNotFoundException("New tab not found"));
        driver.switchTo().window(newTab);

        // validate the url of new tab is home url
        Assert.assertEquals(
                driver.getCurrentUrl(),
                EXPECTED_HOME_URL,
                "URL does not match expected");

        // close tab and go back to original window
        driver.close();
        driver.switchTo().window(originalTab);

        Assert.assertEquals(driver.getWindowHandles().size(), numberOfTabsOpen);
    }

}
