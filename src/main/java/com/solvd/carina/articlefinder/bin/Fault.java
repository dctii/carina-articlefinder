package com.solvd.carina.articlefinder.bin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Fault {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.FAULT);

    @JsonProperty("faultstring")
    private String faultString;

    @JsonProperty("detail")
    FaultDetail detail;

    public Fault() {
    }

    public Fault(String faultString, FaultDetail detail) {
        this.faultString = faultString;
        this.detail = detail;
    }

    public String getFaultString() {
        return faultString;
    }

    public void setFaultString(String faultString) {
        this.faultString = faultString;
    }

    public FaultDetail getDetail() {
        return detail;
    }

    public void setDetail(FaultDetail detail) {
        this.detail = detail;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fault that = (Fault) o;
        return Objects.equals(faultString, that.faultString)
                && Objects.equals(detail, that.detail);
    }

    public int hashCode() {
        return Objects.hash(faultString, detail);
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.FAULT;
        String[] fieldNames = {
                "faultString",
                "detail"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
