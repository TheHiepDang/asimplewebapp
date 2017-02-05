package com.starhub.sites.api;

import com.starhub.sites.api.dto.MainBannerDTO;

public interface MainBannerResource {
    void setBanner(MainBannerDTO mainBannerDTO);
    MainBannerDTO getBanner(String pageType);
}
