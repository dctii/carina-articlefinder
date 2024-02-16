package com.solvd.carina.articlefinder.web.components.generalpage;

public enum SiteIndexOption {
    HOME_PAGE("Home Page", "/"),
    WORLD("World", "/section/world"),
    CORONAVIRUS("Coronavirus", "/news-event/coronavirus"),
    U_S("U.S.", "/section/us"),
    POLITICS("Politics", "/section/politics"),
    NEW_YORK("New York", "/section/nyregion"),
    BUSINESS("Business", "/section/business"),
    TECH("Tech", "/section/technology"),
    SCIENCE("Science", "/section/science"),
    SPORTS("Sports", "/section/sports");

    private final String displayName;
    private final String subPath;

    SiteIndexOption(String displayName, String path) {
        this.displayName = displayName;
        this.subPath = path;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSubPath() {
        return subPath;
    }
}
