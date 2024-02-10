package com.solvd.carina.articlefinder.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractResponse {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.ABSTRACT_RESPONSE);
    
    private String status;

    private String copyright;

    public AbstractResponse() {
    }

    public AbstractResponse(String status, String copyright) {
        this.status = status;
        this.copyright = copyright;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractResponse that = (AbstractResponse) o;
        return Objects.equals(status, that.status)
                && Objects.equals(copyright, that.copyright);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, copyright);
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.ABSTRACT_RESPONSE;
        String[] fieldNames = {
                "status",
                "copyright"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
