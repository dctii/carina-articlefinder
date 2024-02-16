package com.solvd.carina.articlefinder.web.components.searchpage;

import com.solvd.carina.articlefinder.util.NumberUtils;
import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPageSearchStatus extends AbstractGlobalUIObject {
    private static final Logger LOGGER = LogManager.getLogger(SearchPageSearchStatus.class);

    //    @FindBy(xpath = ".//p[@data-testid='SearchForm-status']")
    @FindBy(xpath = ".//span[@data-testid='search-status-screenreader']")
    private BoringElement resultsText;

    @FindBy(xpath = ".//span[@data-testid='search-status-screenreader']/following-sibling::span[1]")
    private BoringElement searchQueryText; // the value that was used to make the search results

    public SearchPageSearchStatus(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        resultsText
    */

    public ExtendedWebElement getResultsText() {
        return resultsText;
    }

    public boolean isResultsTextPresent(long timeout) {
        return resultsText.isPresent(timeout);
    }

    public boolean isResultsTextPresent() {
        return this.isResultsTextPresent(1);
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

    /*
        searchQueryText
    */

    public ExtendedWebElement getSearchQueryText() {
        return searchQueryText;
    }

    public boolean isSearchQueryTextPresent(long timeout) {
        return searchQueryText.isPresent(timeout);
    }

    public boolean isSearchQueryTextPresent() {
        return this.isSearchQueryTextPresent(1);
    }

    public String getSearchQueryTextString() {
        return searchQueryText.getText();
    }


}
