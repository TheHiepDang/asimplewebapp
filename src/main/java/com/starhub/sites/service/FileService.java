package com.starhub.sites.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Hiep Dang on 2/3/2017.
 */
public interface FileService {
    String upload(MultipartFile file);
}
