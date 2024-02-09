package com.solvd.carina.articlefinder.web.components.homepage;

import com.solvd.carina.articlefinder.util.AnsiCodes;
import com.solvd.carina.articlefinder.util.DateTimeConstants;
import com.solvd.carina.articlefinder.util.StringConstants;
import com.solvd.carina.articlefinder.web.HomePage;
import com.solvd.carina.articlefinder.web.components.generic.Anchor;
import com.solvd.carina.articlefinder.web.components.generic.MasterHeader;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HomeMasterHeader extends MasterHeader {
    private static final Logger LOGGER = LogManager.getLogger(HomeMasterHeader.class);

    @FindBy(xpath = ".//span[@data-testid='todays-date']")
    private ExtendedWebElement todayDateDisplay;

    @FindBy(xpath = ".//a[text()='Today’s Paper']")
    private Anchor todayPaperLink;
    @FindBy(xpath = ".//div[@data-testid='masthead-desktop-logo']/a")
    private Anchor headerLogo;


    /* TODO:
        @FindBy(xpath = ".//div[@data-testid='masthead-nested-nav']/nav")
        private HomeNavigationMenu navigationMenu;

        // stock widget
    */


    public HomeMasterHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getTodayDateDisplay() {
        return todayDateDisplay;
    }

    public String getTodayDateDisplayTextString() {
        return todayDateDisplay.getText();
    }


    // fails, my local date does not match the local date of the NY Times
    public boolean isTodayDateDisplayMatchingNewYorkLocalDate() {
        String dateString = getTodayDateDisplayTextString(); // e.g., "Thursday, February 8, 2024"
        DateTimeFormatter todayDateFormatter = DateTimeFormatter.ofPattern(
                StringConstants.DOTW_MONTH_D_YYYY_DATE_PATTERN,
                Locale.ENGLISH
        );
        LocalDate date = LocalDate.parse(dateString, todayDateFormatter);

        // Get current date in New York timezone
        ZonedDateTime currentDateInNewYork = ZonedDateTime.now(DateTimeConstants.AMERICA_NEW_YORK_ZID);
        LocalDate currentDate = currentDateInNewYork.toLocalDate();

        LOGGER.info("{}Today date display after converted: {}{}", AnsiCodes.RED_ON_YELLOW,
                date.toString(),
                AnsiCodes.RESET_ALL);
        LOGGER.info("{}LocalDate.now() in New York: {}{}", AnsiCodes.RED_ON_YELLOW, currentDate.toString(), AnsiCodes.RESET_ALL);

        return date.equals(currentDate);
    }

    public Anchor getTodayPaperLink() {
        return todayPaperLink;
    }


    public void clickTodayPaperLink() {
        todayPaperLink.click();

        // TODO: need to create TodayPaperPage and then `return TodayPaperPage(getDriver())
    }

    public String getTodayPaperTextString() {
        return todayPaperLink.getText();
    }

    public Anchor getHeaderLogo() {
        return headerLogo;
    }

    public HomePage clickHeaderLogo() {
        headerLogo.click();

        return new HomePage(getDriver());
    }

}
