package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.elements.AbstractUserAccessPage;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserAccessPage extends AbstractUserAccessPage {
    private static final Logger LOGGER = LogManager.getLogger(UserAccessPage.class);

    @FindBy(xpath = "//*[@id=\"myAccountAuth\"]/header/div[@role='banner']")
    private BoringElement headerBanner;

    public UserAccessPage(WebDriver driver) {
        super(driver);
    }

    /*
        headerBanner
    */
    public ExtendedWebElement getHeaderBanner() {
        return headerBanner;
    }

    public boolean isHeaderBannerPresent(long timeout) {
        return headerBanner.isPresent(timeout);
    }

    public boolean isHeaderBannerPresent() {
        return this.isHeaderBannerPresent(1);
    }

}
