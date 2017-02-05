package com.starhub.sites.domain;

import com.starhub.sites.api.dto.TileDTO;
import com.starhub.sites.common.PageType;
import javax.persistence.*;

@Entity
@Table(name = "TILE")
public class Tile extends BaseDomain {
    @Column(name = "page_type")
    @Enumerated(EnumType.STRING)
    private PageType pageType;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "img_url")
    private String imageURL;
    @Column(name = "cta_text")
    private String CTAText;
    @Column(name = "cta_url")
    private String CTAURL;
    @Column(name = "subtitles")
    private String subtitles;
    @Column(name = "subtitles_2")
    private String subtitles_2;
    @Column(name = "subtitles_3")
    private String subtitles_3;

    public TileDTO toTileDTO(){
        TileDTO tileDTO = new TileDTO();
        tileDTO.setCTAText(this.CTAText);
        tileDTO.setCTAURL(this.CTAURL);
        tileDTO.setDescription(this.description);
        tileDTO.setImageURL(this.imageURL);
        tileDTO.setSubtitles(this.subtitles);
        tileDTO.setSubtitles_2(this.subtitles_2);
        tileDTO.setSubtitles_3(this.subtitles_3);
        tileDTO.setTitle(this.title);
        return tileDTO;
    }

    public Tile() {
    }

    public Tile(PageType pageType, String title, String description, String imageURL, String CTAText, String CTAURL, String subtitles, String subtitles_2, String subtitles_3) {
        this.pageType = pageType;
        this.title = title;
        this.description = description;
        this.imageURL = imageURL;
        this.CTAText = CTAText;
        this.CTAURL = CTAURL;
        this.subtitles = subtitles;
        this.subtitles_2 = subtitles_2;
        this.subtitles_3 = subtitles_3;
    }

    public PageType getPageType() {
        return pageType;
    }

    public void setPageType(PageType pageType) {
        this.pageType = pageType;
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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public String getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(String subtitles) {
        this.subtitles = subtitles;
    }

    public String getSubtitles_2() {
        return subtitles_2;
    }

    public void setSubtitles_2(String subtitles_2) {
        this.subtitles_2 = subtitles_2;
    }

    public String getSubtitles_3() {
        return subtitles_3;
    }

    public void setSubtitles_3(String subtitles_3) {
        this.subtitles_3 = subtitles_3;
    }
}
