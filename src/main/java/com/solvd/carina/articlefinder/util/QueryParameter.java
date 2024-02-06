package com.solvd.carina.articlefinder.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QueryParameter {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.QUERY_PARAMETER);
    private String key;
    private String value;

    public QueryParameter() {
    }

    public QueryParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public QueryParameter(String key, int value) {
        this.key = key;
        this.value = String.valueOf(value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

}
