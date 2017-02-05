package com.starhub.sites.service;

import com.starhub.sites.api.dto.MainBannerDTO;
import com.starhub.sites.common.PageType;
import com.starhub.sites.domain.MainBanner;
import com.starhub.sites.repository.MainBannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Hiep Dang on 1/26/2017.
 */
@Service
public class MainBannerServiceImpl implements MainBannerService {

    @Autowired
    private MainBannerRepository mainBannerRepository;

    @Override
    @Transactional
    public void setBanner(MainBannerDTO mainBannerDTO) {
        mainBannerRepository.save(mainBannerDTO.toMainBannerDomain());
    }

    @Override
    public MainBannerDTO getBannerByPageType(PageType pageType) {
        MainBanner mainBanner = mainBannerRepository.getByPageID(pageType);
        if (mainBanner != null)
            return mainBannerRepository.getByPageID(pageType).toMainBannerDTO();
        return null;
    }
}
