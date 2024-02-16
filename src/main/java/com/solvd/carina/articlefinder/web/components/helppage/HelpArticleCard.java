package com.solvd.carina.articlefinder.web.components.helppage;

import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HelpArticleCard extends AbstractGlobalUIObject {
    @FindBy(xpath = ".//h4[@class='UH-help-title']")
    BoringElement helpCardHeader;

    @FindBy(xpath = ".//h4[@class='UH-help-text']")
    BoringElement helpCardSuggestion;

    @FindBy(xpath = ".//h4[@class='UH-help-text']")
    Anchor contactUsButton;

    public HelpArticleCard(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        getHelpCardHeader
     */

    public BoringElement getHelpCardHeader() {
        return helpCardHeader;
    }

    public boolean isHelpCardHeaderPresent(long timeout) {
        return helpCardHeader.isPresent();
    }

    public boolean isHelpCardHeaderPresent() {
        return isHelpCardHeaderPresent(1);
    }

    public String getHelpCardHeaderText() {
        return helpCardHeader.getText();
    }

    /*
        getHelpCardHeader
     */

    public BoringElement getHelpCardSuggestion() {
        return helpCardSuggestion;
    }

    public boolean isHelpCardSuggestionPresent(long timeout) {
        return helpCardSuggestion.isPresent();
    }

    public boolean isHelpCardSuggestionPresent() {
        return isHelpCardSuggestionPresent(1);
    }

    public String getHelpCardSuggestionText() {
        return helpCardSuggestion.getText();
    }

    /*
        getHelpCardHeader
     */

    public Anchor getContactUsButton() {
        return contactUsButton;
    }

    public boolean isContactUsButtonPresent(long timeout) {
        return contactUsButton.isPresent();
    }

    public boolean isContactUsButtonPresent() {
        return isContactUsButtonPresent(1);
    }

    public String getContactUsButtonText() {
        return contactUsButton.getText();
    }

    public void clickContactUsButton() {
        // TODO: Should return Contact Us Page from help subsite
        contactUsButton.click();
    }
}
