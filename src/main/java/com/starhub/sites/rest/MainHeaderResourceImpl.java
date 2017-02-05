package com.starhub.sites.rest;

import com.starhub.sites.api.MainHeaderResource;
import com.starhub.sites.api.dto.HeaderItemDTO;
import com.starhub.sites.service.MainHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Hiep Dang on 1/24/2017.
 */
@Controller
@RequestMapping("/api/starhub/mainHeader")
public class MainHeaderResourceImpl implements MainHeaderResource {

    @Autowired
    private MainHeaderService mainHeaderService;

    @Override
    @RequestMapping(value = "/setHeader", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void setHeaderItems(@RequestBody List<HeaderItemDTO> headerItemDTOs) {
        mainHeaderService.setHeaderItemsBatch(headerItemDTOs);
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<HeaderItemDTO> getMainHeaderItems() {
        return mainHeaderService.getMainHeaderItems();
    }
}
