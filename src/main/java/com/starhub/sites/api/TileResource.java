package com.starhub.sites.api;

import com.starhub.sites.api.dto.TileDTO;

import java.util.List;

public interface TileResource {
    /**
     * @param pageType
     * @return list of tiles that match the given pageType
     */
    List<TileDTO> getTileByPageType(String pageType);

    /**
     * @param tileDTOs
     */
    void setTile(List<TileDTO> tileDTOs);
}
