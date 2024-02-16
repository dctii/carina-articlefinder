package com.solvd.carina.articlefinder.web.components.generic;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.BooleanUtils;
import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.util.PageUtils;
import com.solvd.carina.articlefinder.util.RegExpConstants;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class AbstractGlobalUIObject extends AbstractUIObject {

    public AbstractGlobalUIObject(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getSelf() {
        return this.getRootExtendedElement();
    }

    public boolean isPresent(long timeout) {
        return this.getSelf().isPresent(timeout);
    }

    public boolean isPresent() {
        return this.isPresent(1);
    }

    public String getCssValue(String cssPropertyName) {
        return getSelf().getElement().getCssValue(cssPropertyName);
    }

    public String getTagName() {
        return getSelf().getElement().getTagName();
    }

    public String getAccessKey() {
        return getSelf().getAttribute(AttributeConstants.ACCESS_KEY);
    }

    public String getAutoCapitalize() {
        return getSelf().getAttribute(AttributeConstants.AUTO_CAPITALIZE);
    }

    public boolean hasAutoFocus() {
        return ElementUtils.isAttributePresent(
                getSelf(),
                AttributeConstants.AUTO_FOCUS
        );
    }

    public List<String> getClassValues() {
        return ElementUtils.getClassValuesAsList(getSelf());
    }

    public boolean hasClassAttrValue(String classAttrValue) {
        boolean hasValue = false;

        if (BooleanUtils.isNotEmptyOrNullCollection(getClassValues())) {
            hasValue = getClassValues().stream()
                    .anyMatch(attrValue -> attrValue.equals(classAttrValue));
        }

        return hasValue;
    }

    public boolean isContentEditable() {
        return ElementUtils.isAttributeTrueOrTrueSinceEmptyString(
                getSelf(),
                AttributeConstants.CONTENT_EDITABLE
        );
    }

    public String getContextMenu() {
        return getSelf().getAttribute(AttributeConstants.CONTEXT_MENU);
    }

    public String getDir() {
        return getSelf().getAttribute(AttributeConstants.DIR);
    }

    public boolean isDraggable() {
        return ElementUtils.isAttributeTrue(
                getSelf(),
                AttributeConstants.DRAGGABLE
        );
    }

    public String getEnterKeyHint() {
        return getSelf().getAttribute(AttributeConstants.ENTER_KEY_HINT);
    }

    public List<String> getExportPartsValues() {
        return ElementUtils.getAttributeValuesAsList(
                getSelf(),
                AttributeConstants.EXPORT_PARTS,
                RegExpConstants.COMMA_AND_MAYBE_POST_WHITESPACE

        );
    }

    public boolean isHiddenAttrPresent() {
        return ElementUtils.isAttributePresent(
                getSelf(),
                AttributeConstants.HIDDEN
        );
    }

    public String getIdAttrValueString() {
        return getSelf().getAttribute(AttributeConstants.ID);
    }

    public boolean isInert() {
        return ElementUtils.isAttributePresent(
                getSelf(),
                AttributeConstants.INERT
        );
    }

    public String getInputMode() {
        return getSelf().getAttribute(AttributeConstants.INPUT_MODE);
    }

    public String getIsAttrValueString() {
        return getSelf().getAttribute(AttributeConstants.IS);
    }

    public String getItemIdValueString() {
        return getSelf().getAttribute(AttributeConstants.ITEM_ID);
    }

    public String getItemProp() {
        return getSelf().getAttribute(AttributeConstants.ITEM_PROP);
    }

    public String getItemRef() {
        return getSelf().getAttribute(AttributeConstants.ITEM_REF);
    }

    public String getItemScope() {
        return getSelf().getAttribute(AttributeConstants.ITEM_SCOPE);
    }

    public String getItemType() {
        return getSelf().getAttribute(AttributeConstants.ITEM_TYPE);
    }

    public String getLang() {
        return getSelf().getAttribute(AttributeConstants.LANG);
    }

    public String getNonce() {
        return getSelf().getAttribute(AttributeConstants.NONCE);
    }

    public String getPartAttrValueString() {
        return getSelf().getAttribute(AttributeConstants.PART);
    }

    public boolean isPopover() {
        return ElementUtils.isAttributePresent(
                getSelf(),
                AttributeConstants.POPOVER
        );
    }

    public String getRole() {
        return getSelf().getAttribute(AttributeConstants.ROLE);
    }

    public String getSlot() {
        return getSelf().getAttribute(AttributeConstants.SLOT);
    }

    public boolean hasSpellcheck() {
        return ElementUtils.isAttributeTrueOrTrueSinceEmptyString(
                getSelf(),
                AttributeConstants.SPELLCHECK
        );
    }

    public List<String> getStyles() {
        return ElementUtils.getAttributeValuesAsList(
                getSelf(),
                AttributeConstants.STYLE,
                RegExpConstants.SEMICOLON_AND_MAYBE_POST_WHITESPACE
        );
    }

    public String getStyleAttrValueString() {
        return getSelf().getAttribute(AttributeConstants.STYLE);
    }

    public Integer getTabIndex() {
        return ElementUtils.getIntFromAttrValueString(
                getSelf(),
                AttributeConstants.TAB_INDEX
        );
    }

    public String getTitleAttrValueString() {
        return getSelf().getAttribute(AttributeConstants.TITLE);
    }

    public String getTranslate() {
        return getSelf().getAttribute(AttributeConstants.TRANSLATE);
    }

    public String getVirtualKeyboardPolicy() {
        return getSelf().getAttribute(AttributeConstants.VIRTUAL_KEYBOARD_POLICY);
    }

    public boolean isEnabled() {
        return getSelf().getElement().isEnabled();
    }

    public void submit() {
        getSelf().getElement().submit();
    }

    public void clear() {
        getSelf().getElement().clear();
    }

    public void scrollIntoView(WebDriver driver) {
        PageUtils.scrollIntoView(driver, getSelf());
    }
}
