package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.elements.BoringElement;
import com.solvd.carina.articlefinder.web.elements.interfaces.IHeadline;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LiveArticlePage
        extends GeneralPage
        implements IHeadline {

    @FindBy(xpath = "//article[@data-testid='live-blog-content']//h1")
    BoringElement primaryHeadline;

    @FindBy(xpath = "//div[contains(@class, 'live-blog-post-headline')]//h2")
    List<BoringElement> secondaryHeadlines;

    public LiveArticlePage(WebDriver driver) {
        super(driver);
    }

    /*
        primaryHeadline
     */

    public BoringElement getPrimaryHeadline() {
        return primaryHeadline;
    }

    public String getPrimaryHeadlineText() {
        return primaryHeadline.getText();
    }

    /*
        secondaryHeadline
     */

    public List<BoringElement> getSecondaryHeadlines() {
        return secondaryHeadlines;
    }

    public BoringElement getSecondaryHeadlineByHeadlineText(String headlineText) {
        return secondaryHeadlines.stream()
                .filter(secondaryHeadline ->
                        secondaryHeadline.getText().equals(headlineText)
                )
                .findFirst()
                .orElse(null);
    }

    public Boolean doesSecondaryHeadlineExist(String headlineText) {
        boolean doesExist = false;

        BoringElement secondaryHeadline =
                getSecondaryHeadlineByHeadlineText(headlineText);

        if (secondaryHeadline != null) {
            doesExist = true;
        }

        return doesExist;
    }

    @Override
    public Boolean doesHeadlineExistOnPage(String headlineText) {
        boolean doesExist = false;

        if (
                getPrimaryHeadlineText().equals(headlineText)
                        || doesSecondaryHeadlineExist(headlineText)
        ) {
            doesExist = true;
        }

        return doesExist;
    }

    public BoringElement getHeadline(String headlineText) {
        List<BoringElement> allHeadlines = new ArrayList<>(List.copyOf(secondaryHeadlines));
        allHeadlines.add(primaryHeadline);

        return allHeadlines.stream()
                .filter(headline ->
                        headline.getText().equals(headlineText)
                )
                .findFirst()
                .orElse(null);
    }
}
