package com.solvd.carina.articlefinder.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BadResponse extends AbstractResponse {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.BAD_RESPONSE);

    public BadResponse() {
    }

    public BadResponse(String status, String copyright) {
        super(status, copyright);
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


    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.BAD_RESPONSE;
        String[] fieldNames = {
                "status",
                "copyright"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
