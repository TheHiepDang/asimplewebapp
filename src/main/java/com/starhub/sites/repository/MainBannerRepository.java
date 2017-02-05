package com.starhub.sites.repository;

import com.starhub.sites.common.PageType;
import com.starhub.sites.domain.MainBanner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Hiep Dang on 1/27/2017.
 */
@Repository
public interface MainBannerRepository extends GenericRepository {
    @Query("FROM MainBanner mb WHERE mb.pageType = :pageType")
    MainBanner getByPageID(@Param("pageType") PageType pageType);
}
