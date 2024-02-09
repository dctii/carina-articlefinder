package com.solvd.carina.articlefinder;

import com.solvd.carina.articlefinder.testutil.WebTestUtils;
import com.solvd.carina.articlefinder.util.ConfigConstants;
import com.solvd.carina.articlefinder.util.StringConstants;
import com.solvd.carina.articlefinder.web.HomePage;
import com.solvd.carina.articlefinder.web.components.homepage.HomeMasterHeader;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageWebTest extends AbstractTest {
    private static final Logger LOGGER = LogManager.getLogger(HomePageWebTest.class);

    @Test(description = "Check if master header elements all exist")
    public void validateHomeMasterHeaderElementsPresent() {
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);

        page.open();

        WebTestUtils.checkHomePageUrlAndTitle(page);

        HomeMasterHeader homeMasterHeader = page.getMasterHeader();

        Assert.assertTrue(
                homeMasterHeader.getHeaderLogo().isPresent(),
                "Header logo is not present."
        );

        Assert.assertTrue(
                homeMasterHeader.getSearchButton().isPresent(),
                "Search button is not present."
        );

        Assert.assertTrue(
                homeMasterHeader.getDesktopSectionsButton().isPresent(),
                "Desktop sections button is not present."
        );

        Assert.assertTrue(
                homeMasterHeader.getTodayDateDisplay().isPresent(),
                "Today date display is not present."
        );

        Assert.assertTrue(
                homeMasterHeader.getTodayPaperLink().isPresent(),
                "Today paper link button is present."
        );

        Assert.assertTrue(
                homeMasterHeader.getSubscribeButton().isPresent(),
                "Subscribe button is not present."
        );

        Assert.assertTrue(
                homeMasterHeader.getLogInButton().isPresent(),
                "Log In button is not present."
        );
    }

    @Test(description = "Check if today's date is today's date per New York time")
    public void validateTodayDatePerNewYork() {
        WebDriver driver = getDriver();
        HomePage page = new HomePage(driver);

        page.open();

        WebTestUtils.checkHomePageUrlAndTitle(page);

        HomeMasterHeader homeMasterHeader = page.getMasterHeader();

        Assert.assertTrue(
                homeMasterHeader.isTodayDateDisplayMatchingNewYorkLocalDate(),
                "Header logo is not present."
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
        ExtendedWebElement headerLogo = homeMasterHeader.getHeaderLogo();

        // NOTE: need to see if we can open the new tab without JS, but with CMD+CLICK or CTRL+CLICK
        String link = headerLogo.getAttribute("href"); // Assuming 'href' attribute is present
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0]);", link);

        // validate that two tabs have been opened
        Assert.assertEquals(driver.getWindowHandles().size(), numberOfTabsOpen + 1);

        // get the new tb handle and switch to it
        String newTab = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(originalTab))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("New tab not found"));
        driver.switchTo().window(newTab);

        // validate the url of new tab is home url
        Assert.assertEquals(
                driver.getCurrentUrl(),
                Configuration.getRequired(ConfigConstants.NYT_HOME_URL_KEY) + StringConstants.SOLIDUS,
                "URL does not match expected");

        // close tab and go back to original window
        driver.close();
        driver.switchTo().window(originalTab);

        Assert.assertEquals(driver.getWindowHandles().size(), numberOfTabsOpen);
    }

}
