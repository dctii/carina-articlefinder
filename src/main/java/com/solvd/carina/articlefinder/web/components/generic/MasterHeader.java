package com.solvd.carina.articlefinder.web.components.generic;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.web.UserAccessPage;
import com.solvd.carina.articlefinder.web.components.generalpage.HeaderSearchInputForm;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/*
    Used for the header for most general pages and the home page spec header.
        Home Page: nytimes.com
        General Page examples:
            - https://www.nytimes.com/search?query=
            - https://www.nytimes.com/live/2024/02/08/us/trump-supreme-court-colorado-ballot
*/
public abstract class MasterHeader extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(MasterHeader.class);

    @FindBy(xpath = ".//button[@data-testid='desktop-section-button']")
    private ExtendedWebElement desktopSectionsButton;

    // check attribute `value={value}` matches what was typed in the box
    @FindBy(xpath = ".//button[@data-testid='search-button']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = ".//div[@id='search-input']/form")
    private HeaderSearchInputForm searchInputForm;
    @FindBy(xpath = ".//span[translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'log in']/parent::a")
    private Anchor logInButton;

    @FindBy(xpath = ".//a[@data-testid='subscribe-button']")
    private Anchor subscribeButton;

    @FindBy(xpath = ".//span[@data-testid='onsite-messaging-unit-barOne']/following-sibling::div[1]//button[@data-testid='user-settings-button'][1]")
    private ExtendedWebElement userSettingsButton;

    public MasterHeader(WebDriver driver, SearchContext searchContext) {
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

    /*
        desktopSectionsButton
    */

    public ExtendedWebElement getDesktopSectionsButton() {
        return desktopSectionsButton;
    }

    public boolean isDesktopSectionsButtonPresent(long timeout) {
        return desktopSectionsButton.isPresent(timeout);
    }

    public boolean isDesktopSectionsButtonPresent() {
        return this.isDesktopSectionsButtonPresent(1);
    }

    public void clickDesktopSectionsButton() {
        desktopSectionsButton.click();
    }

    /*
        searchButton
    */

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public boolean isSearchButtonButtonPresent(long timeout) {
        return searchButton.isPresent(timeout);
    }

    public boolean isSearchButtonButtonPresent() {
        return this.isSearchButtonButtonPresent(1);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean getSearchButtonAriaExpandedBoolean() {
        String ariaExpandedString =
                searchButton.getAttribute(AttributeConstants.ARIA_EXPANDED);
        return Boolean.parseBoolean(ariaExpandedString);
    }

    /*
        searchInputForm
    */

    public HeaderSearchInputForm getSearchInputForm() {
        return searchInputForm;
    }

    public boolean isSearchInputFormPresent(long timeout) {
        return searchInputForm.isPresent(timeout);
    }

    public boolean isSearchInputFormPresent() {
        return this.isSearchInputFormPresent(1);
    }

    public void expandSearchInputBox() {
        if (!getSearchButtonAriaExpandedBoolean()) {
            clickSearchButton();
        } else {
            LOGGER.warn(
                    "Cannot expand search input box. It may already be expanded since " +
                            "'aria-expanded=true' for search button."
            );
        }
    }

    public void collapseSearchInputBox() {
        if (getSearchButtonAriaExpandedBoolean()) {
            clickSearchButton();
        } else {
            LOGGER.warn(
                    "Cannot collapse search input box. It may already be collapsed since " +
                            "'aria-expanded=false' for search button."
            );
        }
    }

    /*
        subscribeButton
    */

    public Anchor getSubscribeButton() {
        return subscribeButton;
    }

    public boolean isSubscribeButtonPresent(long timeout) {
        return subscribeButton.isPresent(timeout);
    }

    public boolean isSubscribeButtonPresent() {
        return this.isSubscribeButtonPresent(1);
    }

    public void clickSubscribeButton() {
        subscribeButton.click();
    }

    public String getSubscribeButtonTextString() {
        return subscribeButton.getText();
    }

    /*
        logInButton
    */

    public Anchor getLogInButton() {
        return logInButton;
    }

    public boolean isLogInButtonPresent(long timeout) {
        return logInButton.isPresent(timeout);
    }

    public boolean isLogInButtonPresent() {
        return this.isLogInButtonPresent(1);
    }

    public String getLogInButtonTextString() {
        return logInButton.getText();
    }

    public UserAccessPage clickLogInButton() {
        logInButton.click();
        return new UserAccessPage(getDriver());
    }

    public UserAccessPage clickLogInButtonIfPresent() {
        logInButton.clickIfPresent();
        return new UserAccessPage(getDriver());
    }

    /*
        userSettingsButton
    */

    public ExtendedWebElement getUserSettingsButton() {
        return userSettingsButton;
    }

    public boolean isUserSettingsButtonPresent(long timeout) {
        return userSettingsButton.isPresent(timeout);
    }

    public boolean isUserSettingsButtonPresent() {
        return this.isUserSettingsButtonPresent(1);
    }

    public String getUserSettingsButtonText() {
        return userSettingsButton.getText();
    }

    public void clickUserSettingsButton() {
        // opens the drawer
        userSettingsButton.click();
    }

    public void clickUserSettingsButtonIfPresent() {
        userSettingsButton.clickIfPresent();
    }
}
