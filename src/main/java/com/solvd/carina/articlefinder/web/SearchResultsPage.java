package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.searchpage.SearchPageSearchForm;
import com.solvd.carina.articlefinder.web.components.searchpage.SearchResultItem;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.solvd.carina.articlefinder.web.elements.Button;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// General Search Results Page
public class SearchResultsPage extends GeneralPage {
    private static final Logger LOGGER = LogManager.getLogger(SearchResultsPage.class);
    @FindBy(xpath = ".//div[@data-testid='search-form']")
    private SearchPageSearchForm searchForm;

    @FindBy(xpath = ".//ol[@id='searchSuggestions']/li[@data-testid='search-suggestion']/a[@role='link']")
    private List<Anchor> searchSuggestions;

    @FindBy(xpath = "//ol[@data-testid='search-results']/li[@data-testid='search-bodega-result']")
    private List<SearchResultItem> searchResultItems;

    @FindBy(xpath = ".//button[@data-testid='search-show-more-button']")
    private Button showMoreButton;

    /* TODO:
        SearchPageResultsFilterMenu
    */

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    /*
        searchForm
    */

    public SearchPageSearchForm getSearchForm() {
        return searchForm;
    }

    public boolean isSearchFormPresent(long timeout) {
        return searchForm.isPresent(timeout);
    }

    public boolean isSearchFormPresent() {
        return this.isSearchFormPresent(1);
    }

    /*
        searchSuggestions
    */

    public List<Anchor> getSearchSuggestions() {
        return searchSuggestions;
    }

    public Anchor getSearchSuggestionByIndex(int index) {
        return searchSuggestions.get(index);
    }

    public List<Anchor> getSearchSuggestionsWithQueryText(String queryText) {
        return searchSuggestions.stream()
                .filter(item -> item.getText().contains(queryText))
                .collect(Collectors.toList());
    }

    public boolean anySuggestionsWithQueryText(String queryText) {
        return !getSearchSuggestionsWithQueryText(queryText).isEmpty();
    }

    public boolean allSuggestionsHaveQueryText(String queryText) {
        return searchSuggestions.stream()
                .allMatch(
                        suggestion ->
                                suggestion.getText().contains(queryText)
                );
    }

    public boolean isSuggestionByIndexPresent(int index, long timeout) {
        return searchSuggestions.get(index).isPresent(timeout);
    }

    /*
        searchResultItems
    */

    public List<SearchResultItem> getSearchResultItems() {
        return searchResultItems;
    }

    public List<SearchResultItem> getResultsByTitleSubstring(String substring) {
        return searchResultItems.stream()
                .filter(item -> item.getArticleHeadlineTextString().contains(substring))
                .collect(Collectors.toList());
    }

    public List<SearchResultItem> getResultsByDescriptionSubstring(String substring) {
        return searchResultItems.stream()
                .filter(item -> item.getArticleDescriptionTextString().contains(substring))
                .collect(Collectors.toList());
    }

    public boolean anyResultsWithTitleSubstringExists(String substring) {
        return !getResultsByTitleSubstring(substring).isEmpty();
    }

    public boolean anyResultsWithDescriptionSubstringExists(String substring) {
        return !getResultsByDescriptionSubstring(substring).isEmpty();
    }

    public boolean isResultByTitlePresent(int index) {
        boolean isPresent = false;

        if (index >= 0 && index < searchResultItems.size()) {
            SearchResultItem item = searchResultItems.get(index);
            isPresent = item != null && item.isArticleHeadlinePresent();
        }

        return isPresent;
    }

    public boolean isResultByIndexPresent(int index, long timeout) {
        return this.searchResultItems.get(index).isPresent(timeout);
    }

    public boolean isResultByIndexPresent(int index) {
        return this.isResultByIndexPresent(index, 1);
    }

    /*
        pubDate
    */
    public List<LocalDate> getResultPubDates() {
        return searchResultItems.stream()
                .map(SearchResultItem::getPubDateAsLocalDate)
                .collect(Collectors.toList());
    }

    /*
        showMoreButton
    */

    public ExtendedWebElement getShowMoreButton() {
        return showMoreButton;
    }

    public boolean isShowMoreButtonPresent(long timeout) {
        return showMoreButton.isPresent(timeout);
    }

    public boolean isShowMoreButtonPresent() {
        return this.isShowMoreButtonPresent(1);
    }

    public void clickShowMore() {
        showMoreButton.click(1);
    }

    public void clickShowMoreIfPresent() {
        showMoreButton.clickIfPresent(1);
    }
}
