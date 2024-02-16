package com.solvd.carina.articlefinder.web.components.generalpage;

import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractGlobalUIObject {
    private static final Logger LOGGER = LogManager.getLogger(Footer.class);

    // non-mobile footer links
    @FindBy(
            xpath = ".//li[not(contains(@class, 'mobileOnly'))]"
                    + "/a[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = '%s']"
    )
    Anchor footerLink;

    private static final String CALIFORNIA_NOTICES_LINK_TEXT = "California Notices";

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        footer link
     */

    public Anchor getFooterLink() {
        return footerLink;
    }

    public Anchor getFooterLink(String text) {
        return (Anchor) footerLink.format(text.toLowerCase());
    }

    public boolean isFooterLinkPresent(String text, long timeout) {
        return getFooterLink(text).isPresent(timeout);
    }

    public boolean isFooterLinkPresent(String text) {
        return getFooterLink(text).isPresent(1);
    }

    public String getFooterLinkHrefVal(String text) {
        return getFooterLink(text).getHref();
    }

    public void clickFooterLink(String text) {
        getFooterLink(text).click();
    }
}
