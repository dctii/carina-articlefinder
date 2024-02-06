package com.solvd.carina.articlefinder.util;

import com.solvd.carina.articlefinder.exception.InvalidDateFormatException;
import com.solvd.carina.articlefinder.exception.InvalidFacetFieldException;
import com.solvd.carina.articlefinder.exception.OutOfPageRangeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QueryStringBuilder {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.QUERY_STRING_BUILDER);
    private final List<QueryParameter> queryParameters;


    public QueryStringBuilder() {
        this.queryParameters = new ArrayList<>();
    }

    public QueryStringBuilder(List<QueryParameter> queryParameters) {
        this.queryParameters = queryParameters;
    }

    public QueryStringBuilder addParam(String key, String value) {
        queryParameters.add(new QueryParameter(key, value));
        return this;
    }

    public QueryStringBuilder addParam(QueryParameter queryParameter) {
        queryParameters.add(queryParameter);
        return this;
    }

    public QueryStringBuilder addQueryParam(String value) {
        queryParameters.add(new QueryParameter(QueryParametersConstants.QUERY, value));
        return this;
    }

    public QueryStringBuilder addBeginDateParam(String value) {
        value = formatDateString(value);

        queryParameters.add(new QueryParameter(QueryParametersConstants.BEGIN_DATE, value));
        return this;
    }

    public QueryStringBuilder addEndDateParam(String value) {
        value = formatDateString(value);

        queryParameters.add(new QueryParameter(QueryParametersConstants.END_DATE, value));
        return this;
    }

    public QueryStringBuilder addDateRangeParams(String beginDate, String endDate) {
        return addBeginDateParam(beginDate)
                .addEndDateParam(endDate);
    }

    public QueryStringBuilder addDateParam(String date) {
        // will constrain results to a target date
        return addDateRangeParams(date, date);
    }


    public QueryStringBuilder addFacetFieldsParam(String value) {
        if (QueryParametersConstants.ALLOWED_FACET_FIELDS_VALUES.contains(value)) {
            queryParameters.add(new QueryParameter(QueryParametersConstants.FACET_FIELDS, value));
        } else {
            LOGGER.error("Invalid facet field");
            throw new InvalidFacetFieldException("Invalid facet field");
        }
        return this;
    }


    public QueryStringBuilder addFacetFilterParam(String value) {
        queryParameters.add(new QueryParameter(QueryParametersConstants.FACET_FIELDS, value));
        return this;
    }

    public QueryStringBuilder addFieldListParam(String value) {
        queryParameters.add(new QueryParameter(QueryParametersConstants.FIELD_LIST, value));
        return this;
    }

    public QueryStringBuilder addFilterQueryParam(String value) {
        queryParameters.add(new QueryParameter(QueryParametersConstants.FILTER_QUERY, value));
        return this;
    }

    public QueryStringBuilder addPageNumberParam(String value) {
        queryParameters.add(new QueryParameter(QueryParametersConstants.PAGE_NUMBER, value));
        return this;
    }

    public QueryStringBuilder addPageNumberParam(int value) {
        if (value >= 0 && value <= 100) {
            queryParameters.add(new QueryParameter(QueryParametersConstants.PAGE_NUMBER, value));
        } else {
            LOGGER.error("Page number in query parameter is outside of range: must be '0 ≤ value ≤ 100'");
            throw new OutOfPageRangeException("Page number in query parameter is outside of range: must be '0 ≤ value ≤ 100'");
        }
        return this;
    }

    public QueryStringBuilder addSortParam(String value) {
        queryParameters.add(new QueryParameter(QueryParametersConstants.SORT, value));
        return this;
    }

    public QueryStringBuilder addSortByNewestParam() {
        return addParam(QueryParametersConstants.SORT_NEWEST);
    }

    public QueryStringBuilder addSortByOldestParam() {
        return addParam(QueryParametersConstants.SORT_OLDEST);
    }

    public QueryStringBuilder addSortByRelevanceParam() {
        return addParam(QueryParametersConstants.SORT_RELEVANCE);
    }

    public String build() {
        return queryParameters.stream()
                .map(QueryParameter::toString)
                .collect(Collectors.joining(StringConstants.AMPERSAND));
    }

    private String formatDateString(String dateString) {
        LocalDate date;
        try {
            date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (DateTimeParseException e) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                date = LocalDate.parse(dateString, formatter);
            } catch (DateTimeParseException ex) {
                throw new InvalidDateFormatException(e.getMessage());
            }
        }
        return date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.QUERY_STRING_BUILDER;
        String[] fieldNames = {
                "queryParameters"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }

}
