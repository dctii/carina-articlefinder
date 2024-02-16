package com.solvd.carina.articlefinder.web.elements.helppage;

import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.solvd.carina.articlefinder.web.elements.Img;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HelpHomeButton extends Anchor {

    @FindBy(xpath = ".//img[@alt = 'Logo'")
    private Img homeLogo;

    public HelpHomeButton(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Img getHomeLogo() {
        return homeLogo;
    }

    public boolean homeLogoIsPresent(long timeout) {
        return homeLogo.isPresent(timeout);
    }

    public boolean homeLogoIsPresent() {
        return homeLogo.isPresent(1);
    }
}
