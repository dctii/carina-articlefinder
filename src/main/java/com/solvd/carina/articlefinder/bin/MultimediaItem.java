package com.solvd.carina.articlefinder.bin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MultimediaItem {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.MULTIMEDIA_ITEM);
    @JsonProperty("rank")
    private Integer rank;

    @JsonProperty("subtype")
    private String subtype;
    @JsonProperty("caption")
    private String caption;
    @JsonProperty("credit")
    private String credit;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("legacy")
    Legacy legacy;
    @JsonProperty("subType")
    private String subType;
    @JsonProperty("crop_name")
    private String cropName;

    public MultimediaItem() {
    }

    public MultimediaItem(
            Integer rank, String subtype, String caption,
            String credit, String type, String url,
            Integer height, Integer width, Legacy legacy,
            String subType, String cropName
    ) {
        this.rank = rank;
        this.subtype = subtype;
        this.caption = caption;
        this.credit = credit;
        this.type = type;
        this.url = url;
        this.height = height;
        this.width = width;
        this.legacy = legacy;
        this.subType = subType;
        this.cropName = cropName;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public Legacy getLegacy() {
        return legacy;
    }

    public void setLegacy(Legacy legacy) {
        this.legacy = legacy;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultimediaItem that = (MultimediaItem) o;
        return Objects.equals(rank, that.rank)
                && Objects.equals(subtype, that.subtype)
                && Objects.equals(caption, that.caption)
                && Objects.equals(credit, that.credit)
                && Objects.equals(type, that.type)
                && Objects.equals(url, that.url)
                && Objects.equals(height, that.height)
                && Objects.equals(width, that.width)
                && Objects.equals(legacy, that.legacy)
                && Objects.equals(subType, that.subType)
                && Objects.equals(cropName, that.cropName);
    }

    public int hashCode() {
        return Objects.hash(
                rank, subtype, caption,
                credit, type, url,
                height, width, legacy,
                subType, cropName
        );
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.MULTIMEDIA_ITEM;
        String[] fieldNames = {
                "rank",
                "subtype",
                "caption",
                "credit",
                "type",
                "url",
                "height",
                "width",
                "legacy",
                "subType",
                "cropName"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }

}
