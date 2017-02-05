package com.starhub.sites.service;

import com.starhub.sites.domain.Page;
import com.starhub.sites.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiep Dang on 1/27/2017.
 */
@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageRepository pageRepository;

    @Override
    public List<String> getPageTypes() {
        List<String> pageTypes = new ArrayList<>();
        for (Object page : pageRepository.findAll()) {
            pageTypes.add(((Page) page).getPageType().getPageType());
        }
        return pageTypes;
    }
}
