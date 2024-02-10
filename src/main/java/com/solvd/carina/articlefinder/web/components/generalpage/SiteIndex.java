package com.solvd.carina.articlefinder.web.components.generalpage;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class SiteIndex extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(SiteIndex.class);
    /* TODO:
        // a site-index-header
        // a go-to-homepage
        // div site-index-sections
            // List<SiteIndexSection>
            // site-index-section-label-{n}
                // h3 site-index-section-label-{n}
                // ul site-index-section-list
                    // li not(contains(@class, 'smartphone'))
                // special: subscribe section - div site-index-subscribe-label
    */
    public SiteIndex(WebDriver driver, SearchContext searchContext) {
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
