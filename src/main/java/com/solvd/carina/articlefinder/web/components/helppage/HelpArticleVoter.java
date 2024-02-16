package com.solvd.carina.articlefinder.web.components.helppage;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.Anchor;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HelpArticleVoter extends AbstractGlobalUIObject {

    @FindBy(xpath = ".//span[contains(@class, 'article-votes-question')]")
    BoringElement articleVotesQuestion;

    @FindBy(xpath = ".//a[contains(@class, 'article-vote-up')]")
    Anchor voteUpButton;
    @FindBy(xpath = ".//a[contains(@class, 'article-vote-down')]")
    Anchor voteDownButton;

    @FindBy(xpath = ".//div[contains(@class, 'article-votes-controls')]/following-sibling::div/div")
    HelpArticleQuestionnaire articleFeedbackQuestionnaire;


    public HelpArticleVoter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        articleVotesQuestion
     */

    public BoringElement getArticleVotesQuestion() {
        return articleVotesQuestion;
    }

    public boolean isArticleVotesQuestionPresent(long timeout) {
        return articleVotesQuestion.isPresent(timeout);
    }

    public boolean isArticleVotesQuestionPresent() {
        return articleVotesQuestion.isPresent(1);
    }

    public String getArticleVotesQuestionText() {
        return articleVotesQuestion.getText();
    }

    /*
        voteUpButton
     */

    public Anchor getVoteUpButton() {
        return voteUpButton;
    }

    public boolean isVoteUpButtonPresent(long timeout) {
        return voteUpButton.isPresent(timeout);
    }

    public boolean isVoteUpButtonPresent() {
        return voteUpButton.isPresent(1);
    }

    public boolean isVoteUpButtonAriaSelected() {
        // if vote clicked, then aria-selected attribute should be true
        return ElementUtils.getBooleanFromAttrValueString(
                voteUpButton,
                AttributeConstants.ARIA_SELECTED
        );
    }

    public void clickVoteUpButton() {
        voteUpButton.click();
    }

    /*
        voteDownButton
     */

    public Anchor getVoteDownButton() {
        return voteDownButton;
    }

    public boolean isVoteDownButtonPresent(long timeout) {
        return voteDownButton.isPresent(timeout);
    }

    public boolean isVoteDownButtonPresent() {
        return voteDownButton.isPresent(1);
    }

    public boolean isVoteDownButtonAriaSelected() {
        // if clicked, then aria-selected attribute should be true
        return ElementUtils.getBooleanFromAttrValueString(
                voteDownButton,
                AttributeConstants.ARIA_SELECTED
        );
    }

    public void clickVoteDownButton() {
        voteDownButton.click();
    }

    /*
        articleFeedbackQuestionnaire
     */

    public HelpArticleQuestionnaire getArticleFeedbackQuestionnaire() {
        return articleFeedbackQuestionnaire;
    }

    public boolean isArticleFeedbackQuestionnairePresent(long timeout) {
        return articleFeedbackQuestionnaire.isPresent(timeout);
    }

    public boolean isArticleFeedbackQuestionnairePresent() {
        return articleFeedbackQuestionnaire.isPresent(1);
    }
}
