package com.solvd.carina.articlefinder.web.elements;

import com.solvd.carina.articlefinder.util.AttributeConstants;
import com.solvd.carina.articlefinder.util.ElementUtils;
import com.solvd.carina.articlefinder.web.elements.interfaces.IGatekeepCorsElement;
import com.solvd.carina.articlefinder.web.elements.interfaces.IPoliceReferrerElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class Img
        extends AbstractSizeableElement
        implements IPoliceReferrerElement, IGatekeepCorsElement {
    public Img(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getAlt() {
        return this.getAttribute(AttributeConstants.ALT);
    }

    public boolean isMap() {
        return ElementUtils.isAttributePresent(
                this,
                AttributeConstants.IS_MAP
        );
    }


    public String getLoading() {
        return this.getAttribute(AttributeConstants.LOADING);
    }

    public String getLoadingMode() {
        return this.getLoading();
    }

    public String getLongDesc() {
        return this.getAttribute(AttributeConstants.LONG_DESC);
    }

    public String getSizesAttrValueString() {
        return this.getAttribute(AttributeConstants.SIZES);
    }

    public String getSrcSetAttrValueString() {
        return this.getAttribute(AttributeConstants.SRCSET);
    }

    public String getUseMap() {
        return this.getAttribute(AttributeConstants.USE_MAP);
    }

    public String getDecoding() {
        return this.getAttribute(AttributeConstants.DECODING);
    }

    public String getFetchPriority() {
        return this.getAttribute(AttributeConstants.FETCH_PRIORITY);
    }

    @Override
    public String getCrossOrigin() {
        return this.getAttribute(AttributeConstants.CROSSORIGIN);
    }

    @Override
    public String getReferrerPolicy() {
        return this.getAttribute(AttributeConstants.REFERRERPOLICY);
    }
}
