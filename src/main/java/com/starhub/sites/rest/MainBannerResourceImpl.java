package com.starhub.sites.rest;

import com.starhub.sites.api.MainBannerResource;
import com.starhub.sites.api.dto.MainBannerDTO;
import com.starhub.sites.common.PageType;
import com.starhub.sites.service.MainBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Hiep Dang on 1/24/2017.
 */
@Controller
@RequestMapping("/api/starhub/mainBanner")
public class MainBannerResourceImpl implements MainBannerResource {

    @Autowired
    private MainBannerService mainBannerService;

    @Override
    @RequestMapping(value = "/setBanner", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void setBanner(@RequestBody MainBannerDTO mainBannerDTO) {
        mainBannerService.setBanner(mainBannerDTO);
    }

    @Override
    @RequestMapping(value = "/{pageType}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public MainBannerDTO getBanner(@PathVariable String pageType) {
        return mainBannerService.getBannerByPageType(PageType.valueOf(pageType));
    }
}
