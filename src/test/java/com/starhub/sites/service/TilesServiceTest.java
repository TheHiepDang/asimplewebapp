package com.starhub.sites.service;

import com.starhub.sites.api.dto.TileDTO;
import com.starhub.sites.common.PageType;
import com.starhub.sites.service.TilesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TilesServiceTest {

    @Autowired
    private TilesService tilesService;

    @Test
    public void testGetSetTileByPageType() throws Exception {
        List<TileDTO> tileDTOList = new ArrayList<>();
        tileDTOList.add(new TileDTO());
        tileDTOList.add(new TileDTO());
        tileDTOList.add(new TileDTO());
        tileDTOList.add(new TileDTO());

        tilesService.setTiles(tileDTOList);
        List<TileDTO> tileDTOs = tilesService.getTileByPageType(PageType.MOBILE.toString());
        assertEquals(4, tileDTOs.size());
    }
}