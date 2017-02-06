package com.starhub.sites.api;

import com.starhub.sites.api.dto.HeaderItemDTO;

import java.util.List;

public interface MainHeaderResource {
    /**
     * @param headerItemDTOs
     */
    void setHeaderItems(List<HeaderItemDTO> headerItemDTOs);

    /**
     * @return list of all header items
     */
    List<HeaderItemDTO> getMainHeaderItems();
}
