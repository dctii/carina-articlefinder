package com.solvd.carina.articlefinder.web.components.generalpage;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Footer extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(Footer.class);

    /* TODO: links by text
        // ul/li copyright copyrightLink
        // ul/li legalese, collaboration & contact not(contains(@class, 'mobileOnly'))
        // ul/li privacy & california notices
    */
    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        self
     */

    public ExtendedWebElement getSelf() {
        return this.getRootExtendedElement();
    }

    public boolean isPresent(long timeout) {
        return this.getSelf().isPresent(timeout);
    }

    public boolean isPresent() {
        return this.isPresent(1);
    }


}
