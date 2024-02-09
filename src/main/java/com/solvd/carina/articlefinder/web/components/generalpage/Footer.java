package com.solvd.carina.articlefinder.web.components.generalpage;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Footer extends AbstractUIObject {

    /* TODO: links by text
        // ul/li copyright copyrightLink
        // ul/li legalese, collaboration & contact not(contains(@class, 'mobileOnly'))
        // ul/li privacy & california notices
    */
    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
