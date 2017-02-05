package com.starhub.sites.api;

import com.starhub.sites.api.dto.TileDTO;

import java.util.List;

public interface TileResource {
    List<TileDTO> getTileByPageType(String pageType);
    void setTile(List<TileDTO> tileDTOs);
}
