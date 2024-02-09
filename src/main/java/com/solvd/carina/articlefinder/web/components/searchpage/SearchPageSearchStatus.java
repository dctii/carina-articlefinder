package com.solvd.carina.articlefinder.web.components.searchpage;

import com.solvd.carina.articlefinder.util.NumberUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPageSearchStatus extends AbstractUIObject {

    //    @FindBy(xpath = ".//p[@data-testid='SearchForm-status']")
    @FindBy(xpath = ".//span[@data-testid='search-status-screenreader']")
    private ExtendedWebElement resultsText;

    @FindBy(xpath = ".//span[@data-testid='search-status-screenreader']/following-sibling::span[1]")
    private ExtendedWebElement searchQueryText; // the value that was used to make the search results

    public SearchPageSearchStatus(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getResultsText() {
        return resultsText;
    }

    public String getResultsTextString() {
        return resultsText.getText();
    }

    public int getDisplayedResultsCount() {
        // expected string pattern from getResultsTextString():
        // "Showing {current_shown_number} out of {total_number} results for:"
        return NumberUtils.parseNestedIntSubstring(
                getResultsTextString(),
                "Showing ",
                " out of"
        );

    }

    public int getTotalResultsCount() {
        // expected string pattern from getResultsTextString():
        // "Showing {current_shown_number} out of {total_number} results for:"
        return NumberUtils.parseNestedIntSubstring(
                getResultsTextString(),
                "out of ",
                " results for"
        );
    }

    public ExtendedWebElement getSearchQueryText() {
        return searchQueryText;
    }

    public String getSearchQueryTextString() {
        return searchQueryText.getText();
    }


}
