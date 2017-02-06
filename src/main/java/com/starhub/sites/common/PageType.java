package com.starhub.sites.common;

/**
 * App's page type
 */
public enum PageType {
    MOBILE("MOBILE"),
    MISC("MISC");

    private String pageType;

    PageType(String pageType) {
        this.pageType = pageType;
    }

    public String getPageType() {
        return pageType;
    }
}
