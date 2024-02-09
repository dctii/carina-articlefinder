package com.solvd.carina.articlefinder.web;

import com.solvd.carina.articlefinder.web.components.searchpage.SearchPageSearchForm;
import com.solvd.carina.articlefinder.web.components.searchpage.SearchResultItem;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// General Search Results Page
public class SearchResultsPage extends GeneralPage {
    @FindBy(xpath = ".//div[@data-testid='search-form']")
    private SearchPageSearchForm searchForm;

    @FindBy(xpath = "//ol[@data-testid='search-results']/li[@data-testid='search-bodega-result']")
    private List<SearchResultItem> searchResultItems;

    @FindBy(xpath = ".//button[@data-testid='search-show-more-button']")
    private ExtendedWebElement showMoreButton;

    /* TODO:
        SearchPageResultsFilterMenu
    */

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchPageSearchForm getSearchForm() {
        return searchForm;
    }

    public List<SearchResultItem> getSearchResultItems() {
        return searchResultItems;
    }

    public SearchResultItem getSearchResultItemByIndex(int index) {
        return searchResultItems.get(index);
    }

    public List<LocalDate> getSearchResultItemPubDates() {
        return searchResultItems.stream()
                .map(SearchResultItem::getPubDateAsLocalDate)
                .collect(Collectors.toList());
    }

    public boolean areResultsSortedByNewest() {
        List<LocalDate> dates = getSearchResultItemPubDates();

        return IntStream.range(0, dates.size() - 1)
                .noneMatch(i -> dates.get(i).isBefore(dates.get(i + 1)));
    }

    public boolean areResultsSortedByOldest() {
        List<LocalDate> dates = getSearchResultItemPubDates();

        return IntStream.range(0, dates.size() - 1)
                .noneMatch(i -> dates.get(i).isAfter(dates.get(i + 1)));
    }

    public ExtendedWebElement getShowMoreButton() {
        return showMoreButton;
    }

    public void clickShowMore() {
        if (
                showMoreButton.isPresent()
                        && showMoreButton.isVisible()
        ) {
            showMoreButton.click();
        }
    }
}
