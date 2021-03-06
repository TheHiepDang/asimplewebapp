package com.starhub.sites.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hiep Dang on 1/27/2017.
 */
@Repository
public interface MainHeaderRepository extends GenericRepository {
    @Override
    @Query("from HeaderItem")
    List findAll();
}
