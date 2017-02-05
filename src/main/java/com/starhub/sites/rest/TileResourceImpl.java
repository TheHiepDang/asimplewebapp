package com.starhub.sites.rest;

import com.starhub.sites.api.TileResource;
import com.starhub.sites.api.dto.TileDTO;
import com.starhub.sites.service.TilesService;
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
@RequestMapping("/api/starhub/tile")
public class TileResourceImpl implements TileResource {

    @Autowired
    private TilesService TilesService;

    @Override
    @RequestMapping(value = "/{pageType}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<TileDTO> getTileByPageType(@PathVariable String pageType) {
        return TilesService.getTileByPageType(pageType);
    }

    @Override
    @RequestMapping(value = "/setTile", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void setTile(@RequestBody List<TileDTO> tileDTOs) {
        TilesService.setTiles(tileDTOs);
    }
}
