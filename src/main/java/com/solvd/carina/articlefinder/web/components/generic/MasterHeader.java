package com.solvd.carina.articlefinder.web.components.generic;

import com.solvd.carina.articlefinder.util.AttributeUtils;
import com.solvd.carina.articlefinder.web.UserAccessPage;
import com.solvd.carina.articlefinder.web.components.generalpage.HeaderSearchInputForm;
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

    public ExtendedWebElement getDesktopSectionsButton() {
        return desktopSectionsButton;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean getSearchButtonAriaExpandedBoolean() {
        return AttributeUtils.getAriaExpandedBoolean(searchButton);
    }

    public HeaderSearchInputForm getSearchInputForm() {
        return searchInputForm;
    }

    public void expandSearchInputBox() {
        if (AttributeUtils.isAriaNotExpanded(searchButton)) {
            clickSearchButton();
        } else {
            LOGGER.warn(
                    "Cannot expand search input box. It may already be expanded since " +
                            "'aria-expanded=true' for search button."
            );
        }
    }

    public void collapseSearchInputBox() {
        if (AttributeUtils.isAriaExpanded(searchButton)) {
            clickSearchButton();
        } else {
            LOGGER.warn(
                    "Cannot collapse search input box. It may already be expanded since " +
                            "'aria-expanded=false' for search button."
            );
        }
    }

    public Anchor getSubscribeButton() {
        return subscribeButton;
    }

    public void clickSubscribeButton() {
        subscribeButton.click();
    }

    public String getSubscribeButtonTextString() {
        return subscribeButton.getText();
    }

    public Anchor getLogInButton() {
        return logInButton;
    }


    public String getLogInButtonTextString() {
        String logInButtonText = "";
        if (logInButton.isPresent()) {
            logInButtonText = logInButton.getText();
        } else {
            LOGGER.warn("Log in button in master header of home page is not present.");
        }
        return logInButtonText;
    }

    public UserAccessPage clickLogInButton() {
        if (logInButton.isPresent()) {
            logInButton.click();
        }

        return new UserAccessPage(getDriver());
    }

    public ExtendedWebElement getUserSettingsButton() {
        return userSettingsButton;
    }

    public void clickUserSettingsButton() {
        if (userSettingsButton.isPresent()) {
            userSettingsButton.click();
        }
    }

    public void openUserSettingsDrawer() {
        clickUserSettingsButton();
    }
}
