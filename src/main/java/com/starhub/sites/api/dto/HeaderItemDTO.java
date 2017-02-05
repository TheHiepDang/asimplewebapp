package com.starhub.sites.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.starhub.sites.domain.HeaderItem;

/**
 * Created by Hiep Dang on 1/26/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeaderItemDTO extends DTO {
    private Integer id;
    private String URL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public HeaderItem toMainHeaderDomain() {
        HeaderItem headerItem = new HeaderItem();
        headerItem.setId(this.id);
        headerItem.setURL(this.URL);
        return headerItem;
    }

    public HeaderItemDTO(String URL) {
        this.URL = URL;
    }

    public HeaderItemDTO() {
    }
}
