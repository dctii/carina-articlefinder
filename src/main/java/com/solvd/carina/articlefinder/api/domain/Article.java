package com.solvd.carina.articlefinder.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carina.articlefinder.exception.InvalidKeywordException;
import com.solvd.carina.articlefinder.exception.InvalidMultimediaItemException;
import com.solvd.carina.articlefinder.util.ClassConstants;
import com.solvd.carina.articlefinder.util.StringFormatters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    private static final Logger LOGGER = LogManager.getLogger(ClassConstants.ARTICLE);
    @JsonProperty("_id")
    private String id;

    @JsonProperty("abstract")
    private String abstractString;

    @JsonProperty("web_url")
    private String webUrl;

    @JsonProperty("snippet")
    private String snippet;

    @JsonProperty("lead_paragraph")
    private String leadParagraph;
    @JsonProperty("source")
    private String source;

    @JsonProperty("multimedia")
    List<MultimediaItem> multimediaList;
    @JsonProperty("headline")
    Headline headline;

    @JsonProperty("keywords")
    List<Keyword> keywords;

    @JsonProperty("pub_date")
    String pubDate;

    @JsonProperty("document_type")
    private String documentType;

    @JsonProperty("news_desk")
    private String newsDesk;

    @JsonProperty("section_name")
    private String sectionName;
    Byline byline;

    @JsonProperty("type_of_material")
    private String typeOfMaterial;

    @JsonProperty("word_count")
    private Integer wordCount;
    private String uri;

    public Article() {
        this.multimediaList = new ArrayList<>();
        this.keywords = new ArrayList<>();
    }

    public Article(
            String id, String abstractString, String webUrl,
            String snippet, String leadParagraph, String source,
            List<MultimediaItem> multimediaList, Headline headline, List<Keyword> keywords,
            String pubDate, String documentType, String newsDesk,
            String sectionName, Byline byline, String typeOfMaterial,
            Integer wordCount, String uri
    ) {
        this.id = id;
        this.abstractString = abstractString;
        this.webUrl = webUrl;
        this.snippet = snippet;
        this.leadParagraph = leadParagraph;
        this.source = source;
        this.multimediaList = multimediaList;
        this.headline = headline;
        this.keywords = keywords;
        this.pubDate = pubDate;
        this.documentType = documentType;
        this.newsDesk = newsDesk;
        this.sectionName = sectionName;
        this.byline = byline;
        this.typeOfMaterial = typeOfMaterial;
        this.wordCount = wordCount;
        this.uri = uri;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbstractString() {
        return abstractString;
    }

    public void setAbstractString(String abstractString) {
        this.abstractString = abstractString;
    }


    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getLeadParagraph() {
        return leadParagraph;
    }

    public void setLeadParagraph(String leadParagraph) {
        this.leadParagraph = leadParagraph;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<MultimediaItem> getMultimediaList() {
        return multimediaList;
    }

    public void setMultimediaList(List<MultimediaItem> multimediaList) {
        this.multimediaList = multimediaList;
    }

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getNewsDesk() {
        return newsDesk;
    }

    public void setNewsDesk(String newsDesk) {
        this.newsDesk = newsDesk;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Byline getByline() {
        return byline;
    }

    public void setByline(Byline byline) {
        this.byline = byline;
    }

    public String getTypeOfMaterial() {
        return typeOfMaterial;
    }

    public void setTypeOfMaterial(String typeOfMaterial) {
        this.typeOfMaterial = typeOfMaterial;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }


    public String getUriString() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void addKeyword(Keyword keyword) {
        if (keyword != null) {
            if (keywords == null) {
                keywords = new ArrayList<>();
            }
            keywords.add(keyword);
            LOGGER.info("Keyword added: " + keyword);
        } else {
            LOGGER.error("Keyword cannot be null");
            throw new InvalidKeywordException("Keyword cannot be null");
        }
    }

    public void addMultimediaItem(MultimediaItem multimediaItem) {
        if (multimediaItem != null) {
            if (multimediaList == null) {
                multimediaList = new ArrayList<>();
            }
            multimediaList.add(multimediaItem);
            LOGGER.info("Multimedia item added: " + multimediaItem);
        } else {
            LOGGER.error("Attempted to add null multimedia item.");
            throw new InvalidMultimediaItemException("Attempted to add null multimedia item.");
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article that = (Article) o;
        return Objects.equals(id, that.id)
                && Objects.equals(abstractString, that.abstractString)
                && Objects.equals(webUrl, that.webUrl)
                && Objects.equals(snippet, that.snippet)
                && Objects.equals(leadParagraph, that.leadParagraph)
                && Objects.equals(source, that.source)
                && Objects.equals(multimediaList, that.multimediaList)
                && Objects.equals(headline, that.headline)
                && Objects.equals(keywords, that.keywords)
                && Objects.equals(pubDate, that.pubDate)
                && Objects.equals(documentType, that.documentType)
                && Objects.equals(newsDesk, that.newsDesk)
                && Objects.equals(sectionName, that.sectionName)
                && Objects.equals(byline, that.byline)
                && Objects.equals(typeOfMaterial, that.typeOfMaterial)
                && Objects.equals(wordCount, that.wordCount)
                && Objects.equals(uri, that.uri);
    }

    public int hashCode() {
        return Objects.hash(
                id, abstractString, webUrl,
                snippet, leadParagraph, source,
                multimediaList, headline, keywords,
                pubDate, documentType, newsDesk,
                sectionName, byline, typeOfMaterial,
                wordCount, uri
        );
    }

    @Override
    public String toString() {
        Class<?> currClass = ClassConstants.ARTICLE;
        String[] fieldNames = {
                "id",
                "abstractString",
                "webUrl",
                "snippet",
                "leadParagraph",
                "source",
                "multimediaList",
                "headline",
                "keywords",
                "pubDate",
                "documentType",
                "newsDesk",
                "sectionName",
                "byline",
                "typeOfMaterial",
                "wordCount",
                "uri"
        };

        String fieldsString = StringFormatters.buildFieldsString(this, fieldNames);
        return StringFormatters.buildToString(currClass, fieldNames, fieldsString);
    }
}
