package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.generalpage.Footer;
import com.solvd.carina.articlefinder.web.components.generalpage.SiteIndex;
import com.solvd.carina.articlefinder.web.components.generalpage.UserModalDrawer;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

// special content pages that don't follow this: The Athletic, Wirecutter, Cooking
public abstract class PageContainer extends AbstractPage {

    // TODO
    @FindBy(xpath = "//nav[@id='site-index']")
    SiteIndex siteIndex; // above the footer

    // TODO
    @FindBy(xpath = "//footer/nav[@data-testid='footer']")
    Footer footer;

    @FindBy(xpath = "//div[@id='user-modal-drawer']")
    UserModalDrawer userModalDrawer;

    public PageContainer(WebDriver driver) {
        super(driver);
    }

    public SiteIndex getSiteIndex() {
        return siteIndex;
    }

    public Footer getFooter() {
        return footer;
    }

    public UserModalDrawer getUserModalDrawer() {
        return userModalDrawer;
    }
}
