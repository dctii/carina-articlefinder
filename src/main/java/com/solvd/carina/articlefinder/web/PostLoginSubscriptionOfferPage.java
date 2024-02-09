package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.generic.Anchor;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PostLoginSubscriptionOfferPage extends AbstractPage {

    @FindBy(xpath = "//h1")
    private ExtendedWebElement headerOneText;

    @FindBy(xpath = "//a[contains(text(), 'Continue without subscribing')]")
    private Anchor continueWithoutSubscribingLink;

    public PostLoginSubscriptionOfferPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getHeaderOneText() {
        return headerOneText;
    }

    public String getHeadOneText() {
        return headerOneText.getText();
    }

    public Anchor getContinueWithoutSubscribingLink() {
        return continueWithoutSubscribingLink;
    }

    public HomePage clickContinueWithoutSubscribingLink() {
        continueWithoutSubscribingLink.click();

        return new HomePage(getDriver());
    }
}
