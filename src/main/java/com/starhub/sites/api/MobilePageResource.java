package com.starhub.sites.api;

import com.starhub.sites.api.dto.HeaderItemDTO;
import com.starhub.sites.api.dto.MainBannerDTO;
import com.starhub.sites.api.dto.TileDTO;

import java.util.List;

public interface MobilePageResource {
    /**
     * @param headerItemDTOs
     * @param mainBannerDTO
     * @param tileDTOs
     */
    void saveTemplate(List<HeaderItemDTO> headerItemDTOs, MainBannerDTO mainBannerDTO, List<TileDTO> tileDTOs);
}
