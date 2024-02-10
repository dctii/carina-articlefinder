package com.solvd.carina.articlefinder.web.components.homepage;

import com.solvd.carina.articlefinder.web.HomePage;
import com.solvd.carina.articlefinder.web.components.generic.MasterHeader;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

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

    /*
        todayDateDisplay
    */

    public ExtendedWebElement getTodayDateDisplay() {
        return todayDateDisplay;
    }

    public boolean isTodayDisplayPresent(long timeout) {
        return todayDateDisplay.isPresent(timeout);
    }

    public boolean isTodayDisplayPresent() {
        return this.isTodayDisplayPresent(1);
    }

    public boolean isTodayDateDisplayPresent(long timeout) {
        return todayDateDisplay.isPresent(timeout);
    }

    public boolean isTodayDateDisplayPresent() {
        return isHeaderLogoPresent(1);
    }

    public String getTodayDateDisplayTextString() {
        return todayDateDisplay.getText();
    }

    /*
        todayPaperLink
    */

    public Anchor getTodayPaperLink() {
        return todayPaperLink;
    }

    public boolean isTodayPaperLinkPresent(long timeout) {
        return todayPaperLink.isPresent(timeout);
    }

    public boolean isTodayPaperLinkPresent() {
        return this.isTodayPaperLinkPresent(1);
    }


    public void clickTodayPaperLink() {
        todayPaperLink.click();

        // TODO: need to create TodayPaperPage and then `return TodayPaperPage(getDriver())
    }

    public String getTodayPaperTextString() {
        return todayPaperLink.getText();
    }

    /*
        headerLogo
    */

    public Anchor getHeaderLogo() {
        return headerLogo;
    }

    public boolean isHeaderLogoPresent(long timeout) {
        return headerLogo.isPresent(timeout);
    }

    public boolean isHeaderLogoPresent() {
        return this.isHeaderLogoPresent(1);
    }

    public String getHeaderLogoHref() {
        return headerLogo.getHref();
    }

    public HomePage clickHeaderLogo() {
        headerLogo.click();

        return new HomePage(getDriver());
    }

}
