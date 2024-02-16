package com.solvd.carina.articlefinder.web.components.generalpage;

import com.solvd.carina.articlefinder.util.PageUtils;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SiteIndex extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(SiteIndex.class);
    @FindBy(xpath = "//header/a[@data-testid='site-index-header']")
    Anchor siteIndexHeader;

    @FindBy(
            xpath = "//div[@data-testid='site-index-sections']"
                    + "//h3[contains(@id, 'site-index-') and contains(@id, '-label') "
                    + "and translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='%s']"
    )
    BoringElement sectionLabel;

    @FindBy(
            xpath = "//div[@data-testid='site-index-sections']"
                    + "//li[not(contains(@class, 'smartphone'))]"
                    + "/a[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='%s']"
    )
    Anchor sectionLink;

    public SiteIndex(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void navigate(SiteIndexOption option, long timeout) {
        PageUtils.scrollToBottom(getDriver()); // scroll to site index
        getSectionLink(option).click(timeout);
    }

    public void navigate(SiteIndexOption option) {
        navigate(option, 1);
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

    /*
        siteIndexHeader
     */

    public Anchor getSiteIndexHeader() {
        return siteIndexHeader;
    }

    public boolean isSiteIndexHeaderPresent(long timeout) {
        return siteIndexHeader.isPresent(timeout);
    }

    public boolean isSiteIndexHeaderPresent() {
        return siteIndexHeader.isPresent(1);
    }

    public String getSiteIndexHeaderHrefVal() {
        return siteIndexHeader.getHref();
    }

    public void clickSiteIndexHeader() {
        siteIndexHeader.click();
    }

    /*
        sectionLabel
     */

    public BoringElement getSectionLabel() {
        return sectionLabel;
    }

    public BoringElement getSectionLabel(String text) {
        return (BoringElement) sectionLabel.format(text);
    }

    public boolean isSectionLabelPresent(String text, long timeout) {
        return getSectionLabel(text).isPresent(timeout);
    }

    public boolean isSectionLabelPresent(String text) {
        return getSectionLabel(text).isPresent(1);
    }

    /*
        sectionLink
     */

    public Anchor getSectionLink() {
        return sectionLink;
    }

    public Anchor getSectionLink(String text) {
        return (Anchor) sectionLink.format(text);
    }

    public Anchor getSectionLink(SiteIndexOption option) {
        return (Anchor) sectionLink.format(option.getDisplayName().toLowerCase());
    }

    public boolean isSectionLinkPresent(String text, long timeout) {
        return getSectionLink(text).isPresent(timeout);
    }

    public boolean isSectionLinkPresent(String text) {
        return getSectionLink(text).isPresent(1);
    }

    public String getSectionLinkHrefVal(String text) {
        return getSectionLink(text).getHref();
    }

    public void clickSectionLink(String text) {
        getSectionLink(text).click();
    }
}
