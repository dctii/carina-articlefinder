package com.solvd.carina.articlefinder.bin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleSearchMeta {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.ARTICLE_SEARCH_META);
    @JsonProperty("hits")
    private Integer hits;
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("time")
    private Integer time;

    public ArticleSearchMeta() {
    }

    public ArticleSearchMeta(Integer hits, Integer offset, Integer time) {
        this.hits = hits;
        this.offset = offset;
        this.time = time;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleSearchMeta that = (ArticleSearchMeta) o;
        return Objects.equals(hits, that.hits)
                && Objects.equals(offset, that.offset)
                && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hits, offset, time);
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.ARTICLE_SEARCH_META;
        String[] fieldNames = {
                "hits",
                "offset",
                "time"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
