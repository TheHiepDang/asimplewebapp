package com.starhub.sites.domain;

import com.starhub.sites.api.dto.MainBannerDTO;
import com.starhub.sites.common.PageType;
import javax.persistence.*;

@Entity
@Table(name = "MAIN_BANNER")
public class MainBanner extends BaseDomain {
    @Column(name = "page_type")
    @Enumerated(EnumType.STRING)
    private PageType pageType;
    @Column(name = "bgimg_url")
    private String backgroundIMGURL;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "cta_text")
    private String CTAText;
    @Column(name = "cta_url")
    private String CTAURL;

    public MainBannerDTO toMainBannerDTO() {
        MainBannerDTO mainBannerDTO = new MainBannerDTO();
        mainBannerDTO.setBackgroundIMGURL(this.backgroundIMGURL);
        mainBannerDTO.setCTAText(this.CTAText);
        mainBannerDTO.setCTAURL(this.CTAURL);
        mainBannerDTO.setDescription(this.description);
        mainBannerDTO.setTitle(this.title);
        return mainBannerDTO;
    }

    public MainBanner(PageType pageType, String backgroundIMGURL, String title, String description, String CTAText, String CTAURL) {
        this.pageType = pageType;
        this.backgroundIMGURL = backgroundIMGURL;
        this.title = title;
        this.description = description;
        this.CTAText = CTAText;
        this.CTAURL = CTAURL;
    }

    public MainBanner() {
    }

    public PageType getPageType() {
        return pageType;
    }

    public void setPageType(PageType pageType) {
        this.pageType = pageType;
    }

    public String getBackgroundIMGURL() {
        return backgroundIMGURL;
    }

    public void setBackgroundIMGURL(String backgroundIMGURL) {
        this.backgroundIMGURL = backgroundIMGURL;
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
