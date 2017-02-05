package com.starhub.sites.service;

import com.starhub.sites.api.dto.HeaderItemDTO;
import com.starhub.sites.domain.HeaderItem;
import com.starhub.sites.repository.MainHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiep Dang on 1/26/2017.
 */
@Service
public class MainHeaderServiceImpl implements MainHeaderService {

    @Autowired
    private MainHeaderRepository mainHeaderRepository;

    @Override
    @Transactional
    public void setHeaderItemsBatch(List<HeaderItemDTO> headerItemDTOs) {
        List<HeaderItem> headerItems = new ArrayList<>();
        /*Should be replaced by an enum that's bound to the DB's id in reality e.g (FIRST, SECOND, THIRD)*/
        int id = 1;
        for (HeaderItemDTO headerItemDTO : headerItemDTOs) {
            headerItemDTO.setId(id++);
            headerItems.add(headerItemDTO.toMainHeaderDomain());
        }

//        List<HeaderItem> headerItems = headerItemDTOs.stream().map(HeaderItemDTO::toMainHeaderDomain).collect(Collectors.toList());
        mainHeaderRepository.save(headerItems);
    }

    @Override
    public List<HeaderItemDTO> getMainHeaderItems() {
        return mainHeaderRepository.findAll();
    }
}
