package com.solvd.carina.articlefinder.bin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class FaultDetail {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.FAULT_DETAIL);
    @JsonProperty("errorcode")
    private String errorCode;

    public FaultDetail() {
    }

    public FaultDetail(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FaultDetail that = (FaultDetail) o;
        return Objects.equals(errorCode, that.errorCode);
    }

    public int hashCode() {
        return Objects.hash(errorCode);
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.FAULT_DETAIL;
        String[] fieldNames = {
                "errorCode"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
