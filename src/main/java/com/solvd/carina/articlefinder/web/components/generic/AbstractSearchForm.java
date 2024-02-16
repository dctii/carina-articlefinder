package com.solvd.carina.articlefinder.web.components.generic;

import com.solvd.carina.articlefinder.web.SearchResultsPage;
import com.solvd.carina.articlefinder.web.elements.Button;
import com.solvd.carina.articlefinder.web.elements.Input;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractSearchForm extends AbstractGlobalUIObject {
    private static final Logger LOGGER = LogManager.getLogger(AbstractSearchForm.class);
    @FindBy(xpath = ".//button[@type='submit' and (@data-testid='search-submit' or @data-testid='search-page-submit')]")
    private Button searchSubmitButton;

    @FindBy(xpath = ".//input[@type='text' and (@data-testid='search-input' or @data-testid='search-page-text-field')]")
    private Input searchInputField;

    public AbstractSearchForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        searchInputField
    */
    public ExtendedWebElement getSearchInputField() {
        return searchInputField;
    }

    public boolean isSearchInputFieldPresent(long timeout) {
        return searchInputField.isPresent(timeout);
    }

    public boolean isSearchInputFieldPresent() {
        return this.isSearchInputFieldPresent(1);
    }

    public void typeSearchInputValue(String searchValue) {
        // type something into the search input box
        searchInputField.type(searchValue);
    }

    public void clearSearchInputValue() {
        // type something into the search input box
        searchInputField.clear();
    }

    public String getSearchInputValueAttrString() {
        // get the search input value
        return searchInputField.getValueAttrValueString();
    }

    /*
        searchSubmitButton
    */


    public ExtendedWebElement getSearchSubmitButton() {
        return searchSubmitButton;
    }

    public boolean isSearchSubmitButtonPresent(long timeout) {
        return searchSubmitButton.isPresent(timeout);
    }

    public boolean isSearchSubmitButtonPresent() {
        return this.isSearchSubmitButtonPresent(1);
    }

    public SearchResultsPage clickSearchSubmitButton() {
        searchSubmitButton.click();
        return new SearchResultsPage(getDriver());
    }
}
