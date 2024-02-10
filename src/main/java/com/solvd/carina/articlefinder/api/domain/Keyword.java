package com.solvd.carina.articlefinder.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Keyword {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.KEYWORD);
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;
    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("major")
    private String major;

    public Keyword() {
    }

    public Keyword(
            String name, String value, Integer rank,
            String major
    ) {
        this.name = name;
        this.value = value;
        this.rank = rank;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyword that = (Keyword) o;
        return Objects.equals(name, that.name)
                && Objects.equals(value, that.value)
                && Objects.equals(rank, that.rank)
                && Objects.equals(major, that.major);
    }

    public int hashCode() {
        return Objects.hash(
                name, value, rank,
                major
        );
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.KEYWORD;
        String[] fieldNames = {
                "name",
                "value",
                "rank",
                "major"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
