package com.solvd.carina.articlefinder.bin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Headline {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.HEADLINE);
    @JsonProperty("main")
    private String main;
    @JsonProperty("kicker")
    private String kicker;

    @JsonProperty("content_kicker")
    private String contentKicker;
    @JsonProperty("print_headline")
    private String printHeadline;
    @JsonProperty("name")
    private String name;
    @JsonProperty("seo")
    private String seo;
    @JsonProperty("sub")
    private String sub;

    public Headline() {
    }

    public Headline(
            String main, String kicker, String contentKicker,
            String printHeadline, String name, String seo,
            String sub
    ) {
        this.main = main;
        this.kicker = kicker;
        this.contentKicker = contentKicker;
        this.printHeadline = printHeadline;
        this.name = name;
        this.seo = seo;
        this.sub = sub;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getKicker() {
        return kicker;
    }

    public void setKicker(String kicker) {
        this.kicker = kicker;
    }

    public String getContentKicker() {
        return contentKicker;
    }

    public void setContentKicker(String contentKicker) {
        this.contentKicker = contentKicker;
    }

    public String getPrintHeadline() {
        return printHeadline;
    }

    public void setPrintHeadline(String printHeadline) {
        this.printHeadline = printHeadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeo() {
        return seo;
    }

    public void setSeo(String seo) {
        this.seo = seo;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Headline that = (Headline) o;
        return Objects.equals(main, that.main)
                && Objects.equals(kicker, that.kicker)
                && Objects.equals(contentKicker, that.contentKicker)
                && Objects.equals(printHeadline, that.printHeadline) && Objects.equals(name, that.name)
                && Objects.equals(seo, that.seo) && Objects.equals(sub, that.sub);
    }

    public int hashCode() {
        return Objects.hash(
                main, kicker, contentKicker,
                printHeadline, name, seo,
                sub
        );
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.HEADLINE;
        String[] fieldNames = {
                "main",
                "kicker",
                "contentKicker",
                "printHeadline",
                "name",
                "seo",
                "sub"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
