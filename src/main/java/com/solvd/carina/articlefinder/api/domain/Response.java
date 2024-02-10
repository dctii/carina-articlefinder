package com.solvd.carina.articlefinder.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.exception.InvalidArticleException;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.RESPONSE);

    @JsonProperty("docs")
    List<Article> docs;

    public Response() {
        this.docs = new ArrayList<>();
    }

    public Response(List<Article> docs) {
        this.docs = docs;
    }

    public List<Article> getDocs() {
        return docs;
    }

    public void setDocs(List<Article> docs) {
        this.docs = docs;
    }

    public void addArticle(Article article) {
        if (article != null) {
            docs.add(article);
            LOGGER.info("Article added: " + article);
        } else {
            LOGGER.error("Article added cannot be null");
            throw new InvalidArticleException("Article added cannot be null");
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response that = (Response) o;
        return Objects.equals(docs, that.docs);
    }

    public int hashCode() {
        return Objects.hash(docs);
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.RESPONSE;
        String[] fieldNames = {
                "docs"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
