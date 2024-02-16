package com.solvd.carina.articlefinder.web.components.helppage;

import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.web.HomePage;
import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.solvd.carina.articlefinder.web.elements.helppage.HelpHomeButton;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HelpHeader extends AbstractGlobalUIObject {

    @FindBy(xpath = ".//div[@class='super-t-logo']/a[contains(., 'HOME')]")
    private HelpHomeButton homeButton;
    @FindBy(xpath = ".//div[@class='header-links']/a")
    private List<Anchor> headerLinks;

    private final String HEADER_LINK_HELP = "Help";
    private final String HEADER_LINK_ACCOUNT = "Account";
    private final String HEADER_LINK_CONTACT = "Contact";

    public HelpHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        homeButton
     */

    public HelpHomeButton getHomeButton() {
        return homeButton;
    }

    public boolean isHomeButtonPresent(long timeout) {
        return homeButton.isPresent(timeout);
    }

    public boolean isHomeButtonPresent() {
        return this.isHomeButtonPresent(1);
    }

    public HomePage clickHomeButton() {
        homeButton.click();
        return new HomePage(getDriver());
    }

    /*
        headerLinks
     */

    public List<Anchor> getHeaderLinks() {
        return headerLinks;
    }

    public boolean isHeaderLinkPresent(String headerLinkText) {
        return ElementUtils.isListElementWithTextPresent(
                headerLinks,
                headerLinkText
        );
    }

    public boolean isHelpLinkPresent() {
        return isHeaderLinkPresent(HEADER_LINK_HELP);
    }

    public boolean isAccountLinkPresent() {
        return isHeaderLinkPresent(HEADER_LINK_ACCOUNT);
    }

    public boolean isContactLinkPresent() {
        return isHeaderLinkPresent(HEADER_LINK_CONTACT);
    }

    public void clickHeaderLinkByText(String headerLinkText) {
        ElementUtils.clickListElementWithText(
                headerLinks,
                headerLinkText
        );
    }

    public void clickHelpLink() {
        clickHeaderLinkByText(HEADER_LINK_HELP);
    }

    public void clickAccountLink() {
        clickHeaderLinkByText(HEADER_LINK_ACCOUNT);
    }

    public void clickContactLink() {
        clickHeaderLinkByText(HEADER_LINK_CONTACT);
    }

}
