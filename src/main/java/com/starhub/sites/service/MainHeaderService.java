package com.starhub.sites.service;

import com.starhub.sites.api.dto.HeaderItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hiep Dang on 1/24/2017.
 */
public interface MainHeaderService {
    List<HeaderItemDTO> getMainHeaderItems();
    void setHeaderItemsBatch(List<HeaderItemDTO> headerItemDTOs);
}
