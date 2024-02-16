package com.solvd.carina.articlefinder.web.components.helppage;

import com.solvd.carina.articlefinder.web.components.generic.AbstractGlobalUIObject;
import com.solvd.carina.articlefinder.web.elements.BoringElement;
import com.solvd.carina.articlefinder.web.elements.Button;
import com.solvd.carina.articlefinder.web.elements.Label;
import com.solvd.carina.articlefinder.web.elements.Textarea;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HelpArticleQuestionnaire extends AbstractGlobalUIObject {

    @FindBy(xpath = "./label[contains(text(), 'not helpful')]")
    Label whyUnhelpfulQuestion;

    @FindBy(xpath = "./label[contains(text(), 'not helpful')]/following-sibling::div/div")
    List<HelpArticleQuestionnaireChoice> whyUnhelpfulChoices;

    @FindBy(xpath = ".//label[@for='feedback-text']")
    Label howToImproveQuestion;

    @FindBy(xpath = ".//textarea[@id='feedback-text']")
    Textarea howToImproveTextArea;

    @FindBy(xpath = ".//textarea[@id='feedback-text']/following-sibling::p")
    BoringElement doNotSubmitPersonalInfoNotice;

    @FindBy(xpath = ".//textarea[@id='feedback-text']/following-sibling::button")
    Button submitFeedbackButton;

    // TODO: Add "Feedback Has Been Submitted" card that appears after

    private final String QUESTIONNAIRE_CHOICE_UNSOLVED_ISSUE_ID = "did_not_solve_my_issue";
    private final String QUESTIONNAIRE_CHOICE_CONFUSING_ID = "confusing";
    private final String QUESTIONNAIRE_CHOICE_UNADDRESSED_ISSUE_ID = "did_not_address_issue";
    private final String QUESTIONNAIRE_CHOICE_DISLIKE_ID = "dislike_feature_or_policy";
    private final String QUESTIONNAIRE_CHOICE_OTHER_ID = "other";

    public HelpArticleQuestionnaire(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    /*
        whyUnhelpfulQuestion
     */
    public Label getWhyUnhelpfulQuestion() {
        return whyUnhelpfulQuestion;
    }

    public boolean isWhyUnHelpfulQuestionPresent(long timeout) {
        return whyUnhelpfulQuestion.isPresent();
    }

    public boolean isWhyUnHelpfulQuestionPresent() {
        return isWhyUnHelpfulQuestionPresent(1);
    }

    public String getWhyUnhelpfulQuestionText() {
        return whyUnhelpfulQuestion.getText();
    }

    /*
        whyUnhelpfulChoices
     */

    public List<HelpArticleQuestionnaireChoice> getWhyUnhelpfulChoices() {
        return whyUnhelpfulChoices;
    }

    public boolean isWhyUnhelpfulChoicePresentById(String idString) {
        return whyUnhelpfulChoices.stream()
                .filter(choice ->
                        choice.getCheckbox()
                                .getIdAttrValueString()
                                .equalsIgnoreCase(idString)
                )
                .findFirst()
                .map(HelpArticleQuestionnaireChoice::isPresent)
                .orElse(false);
    }

    public boolean isUnsolvedIssueChoicePresent() {
        return isWhyUnhelpfulChoicePresentById(QUESTIONNAIRE_CHOICE_UNSOLVED_ISSUE_ID);
    }

    public boolean isConfusingChoicePresent() {
        return isWhyUnhelpfulChoicePresentById(QUESTIONNAIRE_CHOICE_CONFUSING_ID);
    }

    public boolean isUnaddressedIssueChoicePresent() {
        return isWhyUnhelpfulChoicePresentById(QUESTIONNAIRE_CHOICE_UNADDRESSED_ISSUE_ID);
    }

    public boolean isDislikedSomethingChoicePresent() {
        return isWhyUnhelpfulChoicePresentById(QUESTIONNAIRE_CHOICE_DISLIKE_ID);
    }

    public boolean isOtherChoicePresent() {
        return isWhyUnhelpfulChoicePresentById(QUESTIONNAIRE_CHOICE_OTHER_ID);
    }

    public void clickWhyUnhelpfulChoiceCheckboxById(String idString) {
        whyUnhelpfulChoices.stream()
                .filter(choice ->
                        choice.getCheckbox()
                                .getIdAttrValueString()
                                .equalsIgnoreCase(idString)
                )
                .findFirst()
                .ifPresent(HelpArticleQuestionnaireChoice::clickCheckbox);
    }

    public void clickUnsolvedIssueChoice() {
        clickWhyUnhelpfulChoiceCheckboxById(QUESTIONNAIRE_CHOICE_UNSOLVED_ISSUE_ID);
    }

    public void clickConfusingChoice() {
        clickWhyUnhelpfulChoiceCheckboxById(QUESTIONNAIRE_CHOICE_CONFUSING_ID);
    }

    public void clickUnaddressedIssueChoice() {
        clickWhyUnhelpfulChoiceCheckboxById(QUESTIONNAIRE_CHOICE_UNADDRESSED_ISSUE_ID);
    }

    public void clickDislikedSomethingChoice() {
        clickWhyUnhelpfulChoiceCheckboxById(QUESTIONNAIRE_CHOICE_DISLIKE_ID);
    }

    public void clickOtherChoice() {
        clickWhyUnhelpfulChoiceCheckboxById(QUESTIONNAIRE_CHOICE_OTHER_ID);
    }

    /*
        howToImproveQuestion
     */

    public Label getHowToImproveQuestion() {
        return howToImproveQuestion;
    }

    public boolean isHowToImproveQuestionPresent(long timeout) {
        return howToImproveQuestion.isPresent();
    }

    public boolean isHowToImproveQuestionPresent() {
        return isHowToImproveQuestionPresent(1);
    }

    public String getHowToImproveQuestionText() {
        return howToImproveQuestion.getText();
    }

    /*
        howToImproveTextArea
     */

    public Textarea getHowToImproveTextArea() {
        return howToImproveTextArea;
    }

    public boolean isHowToImproveTextAreaPresent(long timeout) {
        return howToImproveTextArea.isPresent();
    }

    public boolean isHowToImproveTextAreaPresent() {
        return isHowToImproveTextAreaPresent(1);
    }

    public void clickHowToImproveTextArea(String value) {
        howToImproveTextArea.click();
    }

    public void typeIntoHowToImproveTextArea(String value) {
        howToImproveTextArea.type(value);
    }

    /*
        doNotSubmitPersonalInfoNotice
     */

    public BoringElement getDoNotSubmitPersonalInfoNotice() {
        return doNotSubmitPersonalInfoNotice;
    }

    public boolean isDoNotSubmitPersonalInfoNoticePresent(long timeout) {
        return doNotSubmitPersonalInfoNotice.isPresent();
    }

    public boolean isDoNotSubmitPersonalInfoNoticePresent() {
        return isDoNotSubmitPersonalInfoNoticePresent(1);
    }

    public String getDoNotSubmitPersonalInfoNoticeText() {
        return doNotSubmitPersonalInfoNotice.getText();
    }

    /*
        submitFeedbackButton
     */

    public Button getSubmitFeedbackButton() {
        return submitFeedbackButton;
    }

    public boolean isSubmitFeedbackButtonPresent(long timeout) {
        return submitFeedbackButton.isPresent();
    }

    public boolean isSubmitFeedbackButtonPresent() {
        return isSubmitFeedbackButtonPresent(1);
    }

    public void clickSubmitFeedbackButton() {
        submitFeedbackButton.click();
    }
}
