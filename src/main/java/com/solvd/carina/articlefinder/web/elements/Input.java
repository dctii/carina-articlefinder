package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.web.elements.interfaces.IFormElement;
import com.solvd.carina.articlefinder.web.elements.interfaces.IPolytypeElement;
import com.solvd.carina.articlefinder.web.elements.interfaces.IValueElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Input
        extends AbstractInputElement
        implements IFormElement, IPolytypeElement, IValueElement {
    public Input(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getAccept() {
        return this.getAttribute(AttributeConstants.ACCEPT);
    }

    public String getAlt() {
        return this.getAttribute(AttributeConstants.ALT);
    }

    public String getCapture() {
        return this.getAttribute(AttributeConstants.CAPTURE);
    }

    public String getChecked() {
        return this.getAttribute(AttributeConstants.CHECKED);
    }

    public Integer getWidth() {
        return ElementUtils.getIntFromAttrValueString(
                this,
                AttributeConstants.WIDTH
        );
    }

    public Integer getHeight() {
        return ElementUtils.getIntFromAttrValueString(
                this,
                AttributeConstants.HEIGHT
        );
    }

    public String getList() {
        return this.getAttribute(AttributeConstants.LIST);
    }

    /* TODO: need to put these in specific input types
        look @ https://developer.mozilla.org/en-US/docs/Web/HTML/Attributes/step#syntax
        different types, some take date-time, etc.

        public Integer getMax() {
            return ElementUtils.getIntFromAttrValueString(
                    this,
                    AttributeConstants.MAX
            );
        }

        public Integer getMin() {
            return ElementUtils.getIntFromAttrValueString(
                    this,
                    AttributeConstants.MIN
            );
        }
     */

    public Boolean hasMultipleAttr() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.MULTIPLE
        );
    }

    public Boolean allowsMultipleValues() {
        return hasMultipleAttr();
    }

    public String getPattern() {
        return this.getAttribute(AttributeConstants.PATTERN);
    }


    public Integer getSizeAttrValue() {
        return ElementUtils.getIntFromAttrValueString(
                this,
                AttributeConstants.SIZE
        );
    }

    public Float getStepAttrValue() {
        return ElementUtils.getFloatFromAttrValueString(
                this,
                AttributeConstants.STEP
        );
    }

    @Override
    public String getFormAction() {
        return this.getAttribute(AttributeConstants.FORMACTION);
    }

    @Override
    public String getFormEncType() {
        return this.getAttribute(AttributeConstants.FORMENCTYPE);
    }

    @Override
    public String getFormMethod() {
        return this.getAttribute(AttributeConstants.FORMMETHOD);
    }

    @Override
    public String getFormNoValidate() {
        return this.getAttribute(AttributeConstants.FORMNOVALIDATE);
    }

    @Override
    public String getFormTarget() {
        return this.getAttribute(AttributeConstants.FORMTARGET);
    }

    @Override
    public String getPopoverTarget() {
        return this.getAttribute(AttributeConstants.POPOVERTARGET);
    }

    @Override
    public String getPopoverTargetAction() {
        return this.getAttribute(AttributeConstants.POPOVERTARGETACTION);
    }

    @Override
    public String getType() {
        return this.getAttribute(AttributeConstants.TYPE);
    }

    @Override
    public String getValueAttrValueString() {
        return this.getAttribute(AttributeConstants.VALUE);
    }

    /*
        Non-standard Attributes
     */

    public Boolean isIncremental() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.INCREMENTAL
        );
    }

    public Boolean hasWebkitDirectory() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.WEBKITDIRECTORY
        );

    }

    public Boolean allowsDirectorySelection() {
        return hasWebkitDirectory();
    }
}
