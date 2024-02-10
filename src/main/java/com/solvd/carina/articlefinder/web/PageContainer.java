package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.generalpage.Footer;
import com.solvd.carina.articlefinder.web.components.generalpage.SiteIndex;
import com.solvd.carina.articlefinder.web.components.generalpage.UserModalDrawer;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

// special content pages that don't follow this: The Athletic, Wirecutter, Cooking
public abstract class PageContainer extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(PageContainer.class);

    // TODO
    @FindBy(xpath = "//nav[@id='site-index']")
    private SiteIndex siteIndex; // above the footer

    // TODO
    @FindBy(xpath = "//footer/nav[@data-testid='footer']")
    private Footer footer;

    @FindBy(xpath = "//div[@id='user-modal-drawer']")
    private UserModalDrawer userModalDrawer;

    public PageContainer(WebDriver driver) {
        super(driver);
    }

    /*
        siteIndex
    */

    public SiteIndex getSiteIndex() {
        return siteIndex;
    }

    public boolean isSiteIndexPresent(long timeout) {
        return siteIndex.isPresent(timeout);
    }

    public boolean isSiteIndexPresent() {
        return this.isSiteIndexPresent(1);
    }

    /*
        footer
    */

    public Footer getFooter() {
        return footer;
    }

    public boolean isFooterPresent(long timeout) {
        return footer.isPresent(timeout);
    }

    public boolean isFooterPresent() {
        return this.isFooterPresent(1);
    }

    /*
        userModalDrawer
    */

    public UserModalDrawer getUserModalDrawer() {
        return userModalDrawer;
    }

    public boolean isUserModalDrawerPresent(long timeout) {
        return userModalDrawer.isPresent(timeout);
    }

    public boolean isUserModalDrawerPresent() {
        return this.isUserModalDrawerPresent(1);
    }
}
