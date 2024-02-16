package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.generalpage.GeneralMasterHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class GeneralPage extends PageContainer {
    private static final Logger LOGGER = LogManager.getLogger(GeneralPage.class);

    @FindBy(xpath = "//div[@data-testid='masthead-container']/header")
    private GeneralMasterHeader masterHeader;


    public GeneralPage(WebDriver driver) {
        super(driver);
    }

    /*
        masterHeader
    */
    public GeneralMasterHeader getMasterHeader() {
        return masterHeader;
    }

    public boolean isMasterHeaderPresent(long timeout) {
        return masterHeader.isPresent(timeout);
    }

    public boolean isMasterHeaderPresent() {
        return this.isMasterHeaderPresent(1);
    }
}
