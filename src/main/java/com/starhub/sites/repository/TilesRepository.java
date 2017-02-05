package com.starhub.sites.repository;

import com.starhub.sites.common.PageType;
import com.starhub.sites.domain.Tile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hiep Dang on 1/27/2017.
 */
@Repository
public interface TilesRepository extends GenericRepository {
    @Query("FROM Tile t WHERE t.pageType = ?")
    List<Tile> getByPageType(PageType pageType);
}
