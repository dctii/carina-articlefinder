package com.solvd.carina.articlefinder.bin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.PERSON);

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("middlename")
    private String middleName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("qualifier")
    private String qualifier;
    @JsonProperty("title")
    private String title;
    @JsonProperty("role")
    private String role;
    @JsonProperty("organization")
    private String organization;

    @JsonProperty("rank")
    private Integer rank;

    public Person() {
    }

    public Person(
            String firstName, String middleName, String lastName,
            String qualifier, String title, String role,
            String organization, Integer rank
    ) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.qualifier = qualifier;
        this.title = title;
        this.role = role;
        this.organization = organization;
        this.rank = rank;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return Objects.equals(firstName, that.firstName)
                && Objects.equals(middleName, that.middleName)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(qualifier, that.qualifier)
                && Objects.equals(title, that.title)
                && Objects.equals(role, that.role)
                && Objects.equals(organization, that.organization)
                && Objects.equals(rank, that.rank);
    }

    public int hashCode() {
        return Objects.hash(
                firstName, middleName, lastName,
                qualifier, title, role,
                organization, rank
        );
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.PERSON;
        String[] fieldNames = {
                "firstName",
                "middleName",
                "lastName",
                "qualifier",
                "title",
                "role",
                "organization",
                "rank"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
