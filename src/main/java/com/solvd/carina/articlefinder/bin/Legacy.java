package com.solvd.carina.articlefinder.bin;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Legacy {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.LEGACY);

    @JsonAlias({"thumbnail", "wide", "xlarge"})
    private String url;
    @JsonAlias({"thumbnailwidth", "widewidth", "xlargewidth"})
    private Integer width;
    @JsonAlias({"thumbnailheight", "wideheight", "xlargeheight"})
    private Integer height;

    public Legacy() {
    }

    public Legacy(String url, Integer width, Integer height) {
        this.url = url;
        this.width = width;
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if (url != null) {
            this.url = url;
        }
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        if (width != null) {
            this.width = width;
        }
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        if (height != null) {
            this.height = height;
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Legacy that = (Legacy) o;
        return Objects.equals(url, that.url)
                && Objects.equals(width, that.width)
                && Objects.equals(height, that.height);
    }

    public int hashCode() {
        return Objects.hash(url, width, height);
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.LEGACY;
        String[] fieldNames = {
                "url",
                "width",
                "height"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
