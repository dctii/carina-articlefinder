package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.util.ConfigConstants;
import com.solvd.carina.articlefinder.web.components.homepage.HomeMasterHeader;
import com.zebrunner.carina.utils.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

// NY Times Home Page
public class HomePage extends PageContainer {
    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    @FindBy(xpath = "//div[@data-testid='masthead-container']/header")
    private HomeMasterHeader masterHeader;

    /* TODO:
        // HomeNavigationMenu
        // site-content
    */

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        openURL(
                Configuration.getRequired(ConfigConstants.NYT_HOME_URL_KEY)
        );
    }

    /*
        masterHeader
    */
    public HomeMasterHeader getMasterHeader() {
        return masterHeader;
    }

    public boolean isMasterHeaderPresent(long timeout) {
        return masterHeader.isPresent(timeout);
    }

    public boolean isMasterHeaderPresent() {
        return this.isMasterHeaderPresent(1);
    }
}


