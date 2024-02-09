package com.solvd.carina.articlefinder.web.components.searchpage;

import com.solvd.carina.articlefinder.web.components.generic.AbstractSearchForm;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPageSearchForm extends AbstractSearchForm {

    @FindBy(xpath = ".//p[@data-testid='SearchForm-status']")
    SearchPageSearchStatus searchResultsStatus;

    @FindBy(xpath = ".//select[@data-testid='SearchForm-sortBy']")
    ExtendedWebElement sortByDropdown;

    /* TODO:
        @FindBy(xpath = ".//div[@role='form' and @aria-label='Date Range']/parent::div/parent::div/parent::div")
        SearchPageResultsFilterMenu filterMenu;
    */


    public SearchPageSearchForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchPageSearchStatus getSearchResultsStatus() {
        return searchResultsStatus;
    }

    public ExtendedWebElement getSortByDropdown() {
        return sortByDropdown;
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
