package com.solvd.carina.articlefinder.web.components.generalpage;

import com.solvd.carina.articlefinder.web.HomePage;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserModalDrawer extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(UserModalDrawer.class);
    @FindBy(xpath = ".//div[@data-testid='identity-section']/*[@data-testid='email-address']/span")
    private ExtendedWebElement userEmailDisplay;
    private Anchor logOutLink;

        /*
        TODO:
            // greeting
            //subscribe button
            // try a different email text
            // accountSettingsNavItem
            // YourContent.savedArticlesItem
            // YourContent.newslettersItem
            // GetSupport.helpCenter
    */

    public UserModalDrawer(WebDriver driver, SearchContext searchContext) {
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
        return this.getSelf().isPresent(1);
    }

    /*
        userEmailDisplay
     */
    public ExtendedWebElement getUserEmailDisplay() {
        return userEmailDisplay;
    }

    public boolean isUserEmailDisplayPresent(long timeout) {
        return userEmailDisplay.isPresent(timeout);
    }

    public boolean isUserEmailDisplayPresent() {
        return isUserEmailDisplayPresent(1);
    }

    public String getDisplayEmailTextString() {
        return userEmailDisplay.getText();
    }

    /*
        logOutLink
     */

    public Anchor getLogOutLink() {
        return logOutLink;
    }

    public boolean isLogOutLinkPresent(long timeout) {
        return logOutLink.isPresent(timeout);
    }

    public boolean isLogOutLinkPresent() {
        return isLogOutLinkPresent(1);
    }

    public HomePage clickLogOutLink() {
        logOutLink.click();
        return new HomePage(getDriver());
    }

    public String getLogOutLinkTextString() {
        return logOutLink.getText();
    }


}
