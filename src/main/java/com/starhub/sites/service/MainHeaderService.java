package com.starhub.sites.service;

import com.starhub.sites.api.dto.HeaderItemDTO;

import java.util.List;

/**
 * Created by Hiep Dang on 1/24/2017.
 */
public interface MainHeaderService {
    /**
     * @return list of all header items
     */
    List<HeaderItemDTO> getMainHeaderItems();

    /**
     * @param headerItemDTOs
     */
    void setHeaderItemsBatch(List<HeaderItemDTO> headerItemDTOs);
}
