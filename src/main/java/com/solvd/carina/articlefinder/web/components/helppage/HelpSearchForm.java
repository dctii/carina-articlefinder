package com.solvd.carina.articlefinder.web.components.helppage;

import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.Input;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HelpSearchForm extends AbstractGlobalUIObject {
    @FindBy(xpath = ".//input[@id='query' and @type='search']")
    private Input searchInputField;

    public HelpSearchForm(WebDriver driver, SearchContext searchContext) {
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

    public void clickSearchInputField() {
        searchInputField.click();
    }

    public void typeSearchInputValue(String searchValue) {
        // type something into the search input box
        searchInputField.type(searchValue);
    }

    public void clearSearchInputValue() {
        searchInputField.clear();
    }

    public String getSearchInputViewportText() {
        return searchInputField
                .getShadowRoot()
                .findElement(By.xpath("//div[@id='editing-view-port']/div"))
                .getText();
    }

    public void submitSearchWithEnter() {
        clickSearchInputField();
        searchInputField.sendKeys(Keys.ENTER);

    }
}
