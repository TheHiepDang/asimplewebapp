package com.starhub.sites.service;

import com.starhub.sites.api.dto.MainBannerDTO;
import com.starhub.sites.common.PageType;

/**
 * Created by Hiep Dang on 1/24/2017.
 */
public interface MainBannerService {
    /**
     * @param mainBannerDTO
     */
    void setBanner(MainBannerDTO mainBannerDTO);

    /**
     * @param pageType
     * @return app's banner
     */
    MainBannerDTO getBannerByPageType(PageType pageType);
}
