package com.solvd.carina.articlefinder.web.elements.interfaces;

import com.solvd.carina.articlefinder.web.elements.BoringElement;

public interface IHeadline {
    Boolean doesHeadlineExistOnPage(String headlineText);
    BoringElement getHeadline(String headlineText);
}
