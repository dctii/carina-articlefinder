package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.BooleanUtils;
import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.util.PageUtils;
import com.solvd.carina.articlefinder.util.RegExpConstants;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AbstractGlobalElement extends ExtendedWebElement {
    public AbstractGlobalElement(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public String getCssValue(String cssPropertyName) {
        return this.getElement().getCssValue(cssPropertyName);
    }

    @Override
    public String getTagName() {
        return this.getElement().getTagName();
    }

    public String getAccessKey() {
        return this.getAttribute(AttributeConstants.ACCESS_KEY);
    }

    public String getAutoCapitalize() {
        return this.getAttribute(AttributeConstants.AUTO_CAPITALIZE);
    }

    public boolean hasAutoFocus() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.AUTO_FOCUS
        );
    }

    public List<String> getClassValues() {
        return ElementUtils.getClassValuesAsList(this);
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
                this,
                AttributeConstants.CONTENT_EDITABLE
        );
    }

    public String getContextMenu() {
        return this.getAttribute(AttributeConstants.CONTEXT_MENU);
    }

    public String getDir() {
        return this.getAttribute(AttributeConstants.DIR);
    }

    public boolean isDraggable() {
        return ElementUtils.isAttributeTrue(
                this,
                AttributeConstants.DRAGGABLE
        );
    }

    public String getEnterKeyHint() {
        return this.getAttribute(AttributeConstants.ENTER_KEY_HINT);
    }

    public List<String> getExportPartsValues() {
        return ElementUtils.getAttributeValuesAsList(
                this,
                AttributeConstants.EXPORT_PARTS,
                RegExpConstants.COMMA_AND_MAYBE_POST_WHITESPACE

        );
    }

    public boolean isHiddenAttrPresent() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.HIDDEN
        );
    }

    public String getIdAttrValueString() {
        return this.getAttribute(AttributeConstants.ID);
    }

    public boolean isInert() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.INERT
        );
    }

    public String getInputMode() {
        return this.getAttribute(AttributeConstants.INPUT_MODE);
    }

    public String getIsAttrValueString() {
        return this.getAttribute(AttributeConstants.IS);
    }

    public String getItemIdValueString() {
        return this.getAttribute(AttributeConstants.ITEM_ID);
    }

    public String getItemProp() {
        return this.getAttribute(AttributeConstants.ITEM_PROP);
    }

    public String getItemRef() {
        return this.getAttribute(AttributeConstants.ITEM_REF);
    }

    public String getItemScope() {
        return this.getAttribute(AttributeConstants.ITEM_SCOPE);
    }

    public String getItemType() {
        return this.getAttribute(AttributeConstants.ITEM_TYPE);
    }

    public String getLang() {
        return this.getAttribute(AttributeConstants.LANG);
    }

    public String getNonce() {
        return this.getAttribute(AttributeConstants.NONCE);
    }

    public String getPartAttrValueString() {
        return this.getAttribute(AttributeConstants.PART);
    }

    public boolean isPopover() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.POPOVER
        );
    }

    public String getRole() {
        return this.getAttribute(AttributeConstants.ROLE);
    }

    public String getSlot() {
        return this.getAttribute(AttributeConstants.SLOT);
    }

    public boolean hasSpellcheck() {
        return ElementUtils.isAttributeTrueOrTrueSinceEmptyString(
                this,
                AttributeConstants.SPELLCHECK
        );
    }

    public List<String> getStyles() {
        return ElementUtils.getAttributeValuesAsList(
                this,
                AttributeConstants.STYLE,
                RegExpConstants.SEMICOLON_AND_MAYBE_POST_WHITESPACE
        );
    }

    public String getStyleAttrValueString() {
        return this.getAttribute(AttributeConstants.STYLE);
    }

    public Integer getTabIndex() {
        return ElementUtils.getIntFromAttrValueString(
                this,
                AttributeConstants.TAB_INDEX
        );
    }

    public String getTitleAttrValueString() {
        return this.getAttribute(AttributeConstants.TITLE);
    }

    public String getTranslate() {
        return this.getAttribute(AttributeConstants.TRANSLATE);
    }

    public String getVirtualKeyboardPolicy() {
        return this.getAttribute(AttributeConstants.VIRTUAL_KEYBOARD_POLICY);
    }

    @Override
    public boolean isEnabled() {
        return this.getElement().isEnabled();
    }

    @Override
    public void submit() {
        this.getElement().submit();
    }

    @Override
    public void clear() {
        this.getElement().clear();
    }

    public void scrollIntoView(WebDriver driver) {
        PageUtils.scrollIntoView(driver, this);
    }
}
