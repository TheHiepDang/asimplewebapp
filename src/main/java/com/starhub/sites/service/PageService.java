package com.starhub.sites.service;

import com.starhub.sites.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hiep Dang on 1/27/2017.
 */
public interface PageService {
    List<String> getPageTypes();
}
