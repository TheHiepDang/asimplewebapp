package com.starhub.sites.service;

import com.starhub.sites.api.dto.TileDTO;

import java.util.List;

/**
 * Created by Hiep Dang on 1/24/2017.
 */
public interface TilesService {
    /**
     * @param pageType
     * @return list of all page types
     */
    List<TileDTO> getTileByPageType(String pageType);

    /**
     * @param tileDTOs
     */
    void setTiles(List<TileDTO> tileDTOs);
}
