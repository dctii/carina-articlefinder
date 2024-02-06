package com.solvd.carina.articlefinder.bin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleSearchResponse extends AbstractResponse {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.ARTICLE_SEARCH_RESPONSE);
    @JsonProperty("response")
    private Response response;

    @JsonProperty("meta")
    private ArticleSearchMeta meta;

    public ArticleSearchResponse() {
    }

    public ArticleSearchResponse(String status, String copyright, Response response, ArticleSearchMeta meta) {
        super(status, copyright);
        this.response = response;
        this.meta = meta;
    }

    @JsonProperty("status")
    public String getStatus() {
        return super.getStatus();
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        super.setStatus(status);
    }

    @JsonProperty("copyright")
    public String getCopyright() {
        return super.getCopyright();
    }

    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        super.setCopyright(copyright);
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public ArticleSearchMeta getMeta() {
        return meta;
    }

    public void setMeta(ArticleSearchMeta meta) {
        this.meta = meta;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleSearchResponse)) return false;
        if (!super.equals(o)) return false;
        ArticleSearchResponse that = (ArticleSearchResponse) o;
        return Objects.equals(response, that.response)
                && Objects.equals(meta, that.meta);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), response, meta);
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.ARTICLE_SEARCH_RESPONSE;
        String[] fieldNames = {
                "response",
                "meta"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
