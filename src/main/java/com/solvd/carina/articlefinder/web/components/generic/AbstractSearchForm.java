package com.solvd.carina.articlefinder.web.components.generic;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.web.SearchResultsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractSearchForm extends AbstractUIObject {
    private static final Logger LOGGER = LogManager.getLogger(AbstractSearchForm.class);
    @FindBy(xpath = ".//button[@type='submit' and (@data-testid='search-submit' or @data-testid='search-page-submit')]")
    private ExtendedWebElement searchSubmitButton;

    @FindBy(xpath = ".//input[@type='text' and (@data-testid='search-input' or @data-testid='search-page-text-field')]")
    private ExtendedWebElement searchInputField;

    public AbstractSearchForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        self
     */

    public ExtendedWebElement getSelf() {
        return this.getRootExtendedElement();
    }

    public boolean isPresent(long timeout) {
        return this.getSelf().isPresent(timeout);
    }

    public boolean isPresent() {
        return this.isPresent(1);
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

    public String getSearchInputValueAttrString() {
        // get the search input value
        return searchInputField.getAttribute(AttributeConstants.VALUE);
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
