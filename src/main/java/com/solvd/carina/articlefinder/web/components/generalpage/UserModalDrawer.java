package com.solvd.carina.articlefinder.web.components.generalpage;

import com.solvd.carina.articlefinder.web.HomePage;
import com.solvd.carina.articlefinder.web.components.generic.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class UserModalDrawer extends AbstractUIObject {
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

    public ExtendedWebElement getUserEmailDisplay() {
        return userEmailDisplay;
    }

    public String getDisplayEmailTextString() {
        return userEmailDisplay.getText();
    }

    public Anchor getLogOutLink() {
        return logOutLink;
    }

    public HomePage clickLogOutLink() {
        logOutLink.click();

        return new HomePage(getDriver());
    }

    public String getLogOutLinkTextString() {
        return logOutLink.getText();
    }


}
