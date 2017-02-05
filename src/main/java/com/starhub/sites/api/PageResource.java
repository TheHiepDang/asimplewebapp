package com.starhub.sites.api;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PageResource {
    String homePage();
    List<String> getPageTypes();
    String upload(MultipartFile file);
}
