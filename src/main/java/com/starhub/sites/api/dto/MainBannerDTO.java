package com.starhub.sites.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.starhub.sites.common.PageType;
import com.starhub.sites.domain.MainBanner;

/**
 * Created by Hiep Dang on 1/26/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainBannerDTO extends DTO {
    private String title;
    private String description;
    private String backgroundIMGURL;
    private String CTAText;
    private String CTAURL;

    public MainBanner toMainBannerDomain() {
        MainBanner mainBanner = new MainBanner();
        mainBanner.setBackgroundIMGURL(this.backgroundIMGURL);
        mainBanner.setCTAText(this.CTAText);
        mainBanner.setCTAURL(this.CTAURL);
        mainBanner.setDescription(this.description);
        mainBanner.setTitle(this.title);
        /*Always unique, however should be replaced by Enum in reality*/
        mainBanner.setId(1);
        mainBanner.setPageType(PageType.MOBILE);
        return mainBanner;
    }

    public MainBannerDTO() {
    }

    public MainBannerDTO(String title, String description, String backgroundIMGURL, String CTAText, String CTAURL) {
        this.title = title;
        this.description = description;
        this.backgroundIMGURL = backgroundIMGURL;
        this.CTAText = CTAText;
        this.CTAURL = CTAURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackgroundIMGURL() {
        return backgroundIMGURL;
    }

    public void setBackgroundIMGURL(String backgroundIMGURL) {
        this.backgroundIMGURL = backgroundIMGURL;
    }

    public String getCTAText() {
        return CTAText;
    }

    public void setCTAText(String CTAText) {
        this.CTAText = CTAText;
    }

    public String getCTAURL() {
        return CTAURL;
    }

    public void setCTAURL(String CTAURL) {
        this.CTAURL = CTAURL;
    }
}
