package com.solvd.carina.articlefinder.bin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.exception.InvalidPersonException;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Byline {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.BYLINE);
    @JsonProperty("original")
    private String original;

    @JsonProperty("person")
    List<Person> personList;
    @JsonProperty("organization")
    private String organization;

    public Byline() {
        this.personList = new ArrayList<>();
    }

    public Byline(String original, List<Person> personList, String organization) {
        this.original = original;
        this.personList = personList;
        this.organization = organization;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void addPerson(Person person) {
        if (person != null) {
            if (personList == null) {
                personList = new ArrayList<>();
            }
            personList.add(person);
            LOGGER.info("Person added: " + person);
        } else {
            LOGGER.error("Person cannot be null.");
            throw new InvalidPersonException("Person cannot be null");
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byline that = (Byline) o;
        return Objects.equals(original, that.original)
                && Objects.equals(personList, that.personList)
                && Objects.equals(organization, that.organization);
    }

    public int hashCode() {
        return Objects.hash(original, personList, organization);
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.BYLINE;
        String[] fieldNames = {
                "original",
                "personList",
                "organization"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
