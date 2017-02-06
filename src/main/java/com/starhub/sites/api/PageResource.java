package com.starhub.sites.api;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PageResource {
    /**
     * @return path to homepage
     */
    String homePage();

    /**
     * @return list of all available pageTypes
     */
    List<String> getPageTypes();

    /**
     * @param file
     * @return name of the uploaded file
     */
    String upload(MultipartFile file);
}
