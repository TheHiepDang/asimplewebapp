package com.starhub.sites.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HEADER_ITEM")
public class HeaderItem extends BaseDomain {
    @Column(name = "url")
    private String URL;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public HeaderItem() {
    }

    public HeaderItem(String URL) {
        this.URL = URL;
    }
}
