package com.starhub.sites.service;

import com.starhub.sites.api.dto.TileDTO;

import java.util.List;

/**
 * Created by Hiep Dang on 1/24/2017.
 */
public interface TilesService {
    List<TileDTO> getTileByPageType(String pageType);

    void setTiles(List<TileDTO> tileDTOs);
}
