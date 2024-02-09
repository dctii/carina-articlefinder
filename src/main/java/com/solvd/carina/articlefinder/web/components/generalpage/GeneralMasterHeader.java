package com.solvd.carina.articlefinder.web.components.generalpage;

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

public class GeneralMasterHeader extends MasterHeader {
    private static final Logger LOGGER = LogManager.getLogger(GeneralMasterHeader.class);

    @FindBy(xpath = ".//a[@data-testid='masthead-mobile-logo']/child::*[contains(class, @viewbox)]")
    private ExtendedWebElement headerLogo; // svg logo

    @FindBy(xpath = ".//a[@data-testid='masthead-section-label']")
    private Anchor sectionLabel;

    public GeneralMasterHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getHeaderLogo() {
        return headerLogo;
    }

    public boolean isHeaderLogoPresent(long timeout) {
        return headerLogo.isPresent(timeout);
    }

    public boolean isHeaderLogoPresent() {
        return isHeaderLogoPresent(1);
    }

    public HomePage clickHeaderLogo() {
        headerLogo.click();

        return new HomePage(getDriver());
    }

    public Anchor getSectionLabel() {
        return sectionLabel;
    }

    public String getSectionLabelTextString() {
        String sectionLabelTextString = StringConstants.EMPTY_STRING;

        if (sectionLabel.isPresent()) {
            sectionLabelTextString = sectionLabel.getText();
        } else {
            LOGGER.warn(
                    "Section label of the general master header is not present. Returning an " +
                            "empty string for text()"
            );
        }

        return sectionLabelTextString;
    }

    public String getSectionLabelHrefString() {
        String sectionLabelHrefString = StringConstants.EMPTY_STRING;

        if (sectionLabel.isPresent()) {
            sectionLabelHrefString = sectionLabel.getHref();
        } else {
            LOGGER.warn(
                    "Section label of the general master header is not present. Returning an " +
                            "empty string for href"
            );
        }

        return sectionLabelHrefString;

    }
}
