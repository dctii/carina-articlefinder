package com.solvd.carina.articlefinder.web.components.searchpage;

import com.solvd.carina.articlefinder.web.components.generic.AbstractSearchForm;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPageSearchForm extends AbstractSearchForm {
    private static final Logger LOGGER = LogManager.getLogger(SearchPageSearchForm.class);

    @FindBy(xpath = ".//p[@data-testid='SearchForm-status']")
    private SearchPageSearchStatus searchResultsStatus;

    @FindBy(xpath = ".//select[@data-testid='SearchForm-sortBy']")
    private BoringElement sortByDropdown;

    /* TODO:
        @FindBy(xpath = ".//div[@role='form' and @aria-label='Date Range']/parent::div/parent::div/parent::div")
        SearchPageResultsFilterMenu filterMenu;
    */


    public SearchPageSearchForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        searchResultsStatus
    */

    public SearchPageSearchStatus getSearchResultsStatus() {
        return searchResultsStatus;
    }

    public boolean isSearchResultsStatusPresent(long timeout) {
        return searchResultsStatus.isPresent(timeout);
    }

    public boolean isSearchResultsStatusPresent() {
        return this.isSearchResultsStatusPresent(1);
    }

    /*
        sortByDropdown
    */

    public ExtendedWebElement getSortByDropdown() {
        return sortByDropdown;
    }

    public boolean isSortByDropdownPresent(long timeout) {
        return sortByDropdown.isPresent(timeout);
    }

    public boolean isSortByDropdownPresent() {
        return this.isSortByDropdownPresent(1);
    }


    /* TODO:

        public void selectSortByOption(String optionText) {
            // select option from the sort menu by text() in child <option> element
            final String SORT_BY_PREFIX_TEXT = "Sort by ";

        }

        public void selectSortByRelevance() {
            final String RELEVANCE = "Relevance";
            selectSortByOption(RELEVANCE);
        }

        public void selectSortByOldest() {
            final String OLDEST = "Oldest";
            selectSortByOption(OLDEST);
        }


        public void selectSortByNewest() {
            final String NEWEST = "Newest";
            selectSortByOption(NEWEST);
        }
 */
}
