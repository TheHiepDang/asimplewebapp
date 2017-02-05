package com.starhub.sites.service;

import com.starhub.sites.api.dto.MainBannerDTO;
import com.starhub.sites.common.PageType;
import org.springframework.stereotype.Service;

/**
 * Created by Hiep Dang on 1/24/2017.
 */
public interface MainBannerService {
    void setBanner(MainBannerDTO mainBannerDTO);
    MainBannerDTO getBannerByPageType(PageType pageType);
}
