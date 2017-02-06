package com.starhub.sites.api;

import com.starhub.sites.api.dto.MainBannerDTO;

public interface MainBannerResource {
    /**
     * @param mainBannerDTO
     */
    void setBanner(MainBannerDTO mainBannerDTO);

    /**
     * @param pageType
     * @return the page's banner
     */
    MainBannerDTO getBanner(String pageType);
}
