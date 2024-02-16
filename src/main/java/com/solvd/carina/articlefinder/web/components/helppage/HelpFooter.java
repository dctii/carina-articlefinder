package com.solvd.carina.articlefinder.web.components.helppage;

import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HelpFooter extends AbstractGlobalUIObject {
    @FindBy(xpath = "//nav/ul[@class='copyright']//a[@class='footerLink'] | //nav/ul[@class='footerNav']/li/a")
    private List<Anchor> footerLinks;

    private final String FOOTER_LINK_COPYRIGHT = "© 2024 The New York Times Company";
    private final String FOOTER_LINK_CONTACT_US = "Contact Us";
    private final String FOOTER_LINK_WORK_WITH_US = "Work with us";
    private final String FOOTER_LINK_ADVERTISE = "Advertise";
    private final String FOOTER_LINK_YOUR_AD_CHOICES = "Your Ad Choices";
    private final String FOOTER_LINK_PRIVACY = "Privacy";
    private final String FOOTER_LINK_TERMS_OF_SERVICE = "Terms of Service";
    private final String FOOTER_LINK_TERMS_OF_SALE = "Terms of Sale";
    private final String FOOTER_LINK_SITEMAP = "Sitemap";
    private final String FOOTER_LINK_HELP = "Help";
    private final String FOOTER_LINK_SUBSCRIPTIONS = "Subscriptions";

    public HelpFooter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        footerLinks
     */

    public List<Anchor> getFooterLinks() {
        return footerLinks;
    }

    public boolean isFooterLinkPresent(String footerLinkText) {
        return ElementUtils.isListElementWithTextPresent(
                footerLinks,
                footerLinkText
        );
    }

    public boolean isCopyrightLinkPresent() {
        return isFooterLinkPresent(FOOTER_LINK_COPYRIGHT);
    }

    public boolean isContactUsLinkPresent() {
        return isFooterLinkPresent(FOOTER_LINK_CONTACT_US);
    }

    public boolean isWorkWithUsLinkPresent() {
        return isFooterLinkPresent(FOOTER_LINK_WORK_WITH_US);
    }

    public boolean isAdvertiseLinkPresent() {
        return isFooterLinkPresent(FOOTER_LINK_ADVERTISE);
    }

    public boolean isAdChoicesLinkPresent() {
        return isFooterLinkPresent(FOOTER_LINK_YOUR_AD_CHOICES);
    }

    public boolean isPrivacyLinkPresent() {
        return isFooterLinkPresent(FOOTER_LINK_PRIVACY);
    }

    public boolean isTermsOfServiceLinkPresent() {
        return isFooterLinkPresent(FOOTER_LINK_TERMS_OF_SERVICE);
    }

    public boolean isTermsOfSaleLinkPresent() {
        return isFooterLinkPresent(FOOTER_LINK_TERMS_OF_SALE);
    }

    public boolean isSitemapLinkPresent() {
        return isFooterLinkPresent(FOOTER_LINK_SITEMAP);
    }

    public boolean isHelpLinkPresent() {
        return isFooterLinkPresent(FOOTER_LINK_HELP);
    }

    public boolean isSubscriptionsLinkPresent() {
        return isFooterLinkPresent(FOOTER_LINK_SUBSCRIPTIONS);
    }


    public void clickFooterLinkByText(String footerLinkText) {
        ElementUtils.clickListElementWithText(
                footerLinks,
                footerLinkText
        );
    }

    public void clickCopyrightLink() {
        clickFooterLinkByText(FOOTER_LINK_COPYRIGHT);
    }

    public void clickContactUsLink() {
        clickFooterLinkByText(FOOTER_LINK_CONTACT_US);
    }

    public void clickWorkWithUsLink() {
        clickFooterLinkByText(FOOTER_LINK_WORK_WITH_US);
    }

    public void clickAdvertiseLink() {
        clickFooterLinkByText(FOOTER_LINK_ADVERTISE);
    }

    public void clickAdChoicesLink() {
        clickFooterLinkByText(FOOTER_LINK_YOUR_AD_CHOICES);
    }

    public void clickPrivacyLink() {
        clickFooterLinkByText(FOOTER_LINK_PRIVACY);
    }

    public void clickTermsOfServiceLink() {
        clickFooterLinkByText(FOOTER_LINK_TERMS_OF_SERVICE);
    }

    public void clickTermsOfSaleLink() {
        clickFooterLinkByText(FOOTER_LINK_TERMS_OF_SALE);
    }

    public void clickSitemapLink() {
        clickFooterLinkByText(FOOTER_LINK_SITEMAP);
    }

    public void clickHelpLink() {
        clickFooterLinkByText(FOOTER_LINK_HELP);
    }

    public void clickSubscriptionsLink() {
        clickFooterLinkByText(FOOTER_LINK_SUBSCRIPTIONS);
    }
}
