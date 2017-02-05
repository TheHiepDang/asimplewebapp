package com.starhub.sites.api;

import com.starhub.sites.api.dto.HeaderItemDTO;

import java.util.List;

public interface MainHeaderResource {
    void setHeaderItems(List<HeaderItemDTO> headerItemDTOs);

    List<HeaderItemDTO> getMainHeaderItems();
}
