package com.solvd.carina.articlefinder.web.components.helppage;

import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.Input;
import com.solvd.carina.articlefinder.web.elements.Label;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HelpArticleQuestionnaireChoice extends AbstractGlobalUIObject {
    @FindBy(xpath = "./input[@type='checkbox']")
    Input checkbox;

    @FindBy(xpath = "./input[@type='checkbox']/following-sibling::label")
    Label checkboxLabel;

    public HelpArticleQuestionnaireChoice(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    /*
        whyUnhelpfulChoices
     */

    public Input getCheckbox() {
        return checkbox;
    }

    public boolean isCheckboxPresent(long timeout) {
        return checkbox.isPresent();
    }

    public boolean isCheckboxPresent() {
        return isCheckboxPresent(1);
    }

    public void clickCheckbox() {
        checkbox.click();
    }

    /*
        whyUnhelpfulChoices
     */

    public Label getCheckboxLabel() {
        return checkboxLabel;
    }

    public boolean isCheckboxLabelPresent(long timeout) {
        return checkboxLabel.isPresent();
    }

    public boolean isCheckboxLabelPresent() {
        return isCheckboxLabelPresent(1);
    }

    public String getCheckboxLabelTextString() {
        return checkboxLabel.getText();
    }
}
