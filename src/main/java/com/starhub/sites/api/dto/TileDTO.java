package com.starhub.sites.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.starhub.sites.common.PageType;
import com.starhub.sites.domain.Tile;

/**
 * Created by Hiep Dang on 1/26/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TileDTO extends DTO {
    private String title;
    private String description;
    private String imageURL;
    private String CTAText;
    private String CTAURL;
    private String subtitles;
    private String subtitles_2;
    private String subtitles_3;

    public Tile toTileDomain(Integer id) {
        Tile tile = new Tile();
        tile.setCTAText(this.CTAText);
        tile.setCTAURL(this.CTAURL);
        tile.setDescription(this.description);
        tile.setImageURL(this.imageURL);
        tile.setSubtitles(this.subtitles);
        tile.setSubtitles_2(this.subtitles_2);
        tile.setSubtitles_3(this.subtitles_3);
        tile.setTitle(this.title);
        tile.setId(id);
        tile.setPageType(PageType.MOBILE);
        return tile;
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
