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

    @FindBy(xpath = ".")
    private ExtendedWebElement self;

    @FindBy(xpath = ".//input[@data-testid='search-reset' and @type='reset']")
    private ExtendedWebElement searchInputReset;

    public HeaderSearchInputForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSelf() {
        return self;
    }

    public ExtendedWebElement getSearchInputReset() {
        return searchInputReset;
    }

    public void clickSearchInputReset() {
        searchInputReset.clickIfPresent(10);
    }

    public void resetSearchInput() {
        // reset search input box
        clickSearchInputReset();
    }
}
