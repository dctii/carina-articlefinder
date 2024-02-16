package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.helppage.HelpFooter;
import com.solvd.carina.articlefinder.web.components.helppage.HelpHeader;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HelpPageContainer extends AbstractPage {

    @FindBy(xpath = "//head/link[@rel='canonical']/preceding-sibling::title")
    BoringElement pageTitle;
    @FindBy(xpath = "//header[@class='header']")
    HelpHeader masterHeader;
    @FindBy(xpath = "//footer[@class='footer']")
    HelpFooter footer;

    public HelpPageContainer(WebDriver driver) {
        super(driver);
    }

    /*
        pageTitle
     */

    public BoringElement getPageTitle() {
        return pageTitle;
    }

    public boolean isPageTitlePresent(long timeout) {
        return pageTitle.isPresent(timeout);
    }

    public boolean isPageTitlePresent() {
        return isPageTitlePresent(1);
    }


    public String getPageTitleText() {
        return pageTitle.getText();
    }

    /*
        pageTitle
     */

    public HelpHeader getMasterHeader() {
        return masterHeader;
    }

    public boolean isMasterHeaderPresent(long timeout) {
        return masterHeader.isPresent(timeout);
    }

    public boolean isMasterHeaderPresent() {
        return isMasterHeaderPresent(1);
    }

    /*
        pageTitle
     */

    public HelpFooter getFooter() {
        return footer;
    }

    public boolean isFooterPresent(long timeout) {
        return footer.isPresent(timeout);
    }

    public boolean isFooterPresent() {
        return isFooterPresent(1);
    }
}
