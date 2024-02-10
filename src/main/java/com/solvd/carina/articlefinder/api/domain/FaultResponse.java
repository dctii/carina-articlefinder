package com.solvd.carina.articlefinder.api.domain;

import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class FaultResponse {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.FAULT_RESPONSE);

    Fault fault;

    public FaultResponse() {
    }

    public FaultResponse(Fault fault) {
        this.fault = fault;
    }

    public Fault getFault() {
        return fault;
    }

    public void setFault(Fault fault) {
        this.fault = fault;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FaultResponse that = (FaultResponse) o;
        return Objects.equals(fault, that.fault);
    }

    public int hashCode() {
        return Objects.hash(fault);
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.FAULT_RESPONSE;
        String[] fieldNames = {
                "fault"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
