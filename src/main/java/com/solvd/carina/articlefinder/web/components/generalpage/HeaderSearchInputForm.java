package com.solvd.carina.articlefinder.web.components.generalpage;

import com.solvd.carina.articlefinder.web.components.generic.AbstractSearchForm;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderSearchInputForm extends AbstractSearchForm {
    private static final Logger LOGGER = LogManager.getLogger(HeaderSearchInputForm.class);

    @FindBy(xpath = ".//input[@data-testid='search-reset' and @type='reset']")
    private ExtendedWebElement searchInputReset;

    public HeaderSearchInputForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        searchInputReset
     */

    public ExtendedWebElement getSearchInputReset() {
        return searchInputReset;
    }

    public boolean isSearchInputResetIsPresent(long timeout) {
        return searchInputReset.isPresent();
    }

    public boolean isSearchInputResetIsPresent() {
        return isSearchInputResetIsPresent(1);
    }

    public void clickSearchInputReset() {
        searchInputReset.click();
    }

    public void clickSearchInputResetIfPresent(long timeout) {
        // not present if not expanded
        searchInputReset.clickIfPresent(timeout);
    }

    public void clickSearchInputResetIfPresent() {
        // not present if not expanded
        clickSearchInputResetIfPresent(1);
    }
}
