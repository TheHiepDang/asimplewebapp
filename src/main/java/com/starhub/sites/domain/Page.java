package com.starhub.sites.domain;

import com.starhub.sites.common.PageType;

import javax.persistence.*;

@Entity
@Table(name = "PAGE")
public class Page extends BaseDomain {
    @Column(name = "page_type")
    @Enumerated(EnumType.STRING)
    private PageType pageType;

    public PageType getPageType() {
        return pageType;
    }

    public void setPageType(PageType pageType) {
        this.pageType = pageType;
    }
}
