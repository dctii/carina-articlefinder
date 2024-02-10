package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PostLoginSubscriptionOfferPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(PostLoginSubscriptionOfferPage.class);

    @FindBy(xpath = "//h1")
    private ExtendedWebElement headerOneText;

    @FindBy(xpath = "//a[contains(text(), 'Continue without subscribing')]")
    private Anchor continueWithoutSubscribingLink;

    public PostLoginSubscriptionOfferPage(WebDriver driver) {
        super(driver);
    }

    /*
        headerOneText
    */

    public ExtendedWebElement getHeaderOneText() {
        return headerOneText;
    }

    public boolean isHeaderOneTextPresent(long timeout) {
        return headerOneText.isPresent(timeout);
    }

    public boolean isHeaderOneTextPresent() {
        return this.isHeaderOneTextPresent(1);
    }

    public String getHeaderOneTextString() {
        return headerOneText.getText();
    }

    /*
        continueWithoutSubscribingLink
    */

    public Anchor getContinueWithoutSubscribingLink() {
        return continueWithoutSubscribingLink;
    }

    public boolean isContinueWithoutSubscribingLinkPresent(long timeout) {
        return continueWithoutSubscribingLink.isPresent(timeout);
    }

    public boolean isContinueWithoutSubscribingLinkPresent() {
        return this.isContinueWithoutSubscribingLinkPresent(1);
    }

    public HomePage clickContinueWithoutSubscribingLink() {
        continueWithoutSubscribingLink.click();
        return new HomePage(getDriver());
    }
}
