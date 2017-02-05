package com.starhub.sites.service;

import com.starhub.sites.api.dto.TileDTO;
import com.starhub.sites.common.PageType;
import com.starhub.sites.domain.Tile;
import com.starhub.sites.repository.TilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hiep Dang on 1/26/2017.
 */
@Service
public class TilesServiceImpl implements TilesService {

    @Autowired
    private TilesRepository tilesRepository;

    @Override
    public List<TileDTO> getTileByPageType(String pageType) {
        return tilesRepository.getByPageType(PageType.valueOf(pageType)).stream().map(Tile::toTileDTO).collect(Collectors.toList());
    }

    @Override
    public void setTiles(List<TileDTO> tileDTOs) {
        List<Tile> tiles = new ArrayList<>();
        /*Should be replaced by an enum that's bound to the DB's id in reality e.g (FIRST, SECOND, THIRD)*/
        int id = 1;
        for(TileDTO tile : tileDTOs) {
            tiles.add(tile.toTileDomain(id++));
        }
        tilesRepository.save(tiles);
    }


}
