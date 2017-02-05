package com.starhub.sites.rest;

import com.starhub.sites.api.PageResource;
import com.starhub.sites.service.FileService;
import com.starhub.sites.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Hiep Dang on 1/27/2017.
 */
@Controller
@RequestMapping("/api/starhub/page")
public class PageResourceImpl implements PageResource {

    @Autowired
    private PageService pageService;

    @Autowired
    private FileService fileService;

    @Override
    @RequestMapping("/")
    public String homePage() {
        return "index.html";
    }

    @Override
    @RequestMapping(value = "/pageTypes", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<String> getPageTypes() {
        return pageService.getPageTypes();
    }

    @RequestMapping(value = "/upload", headers = "content-type=multipart/*", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public @ResponseBody String upload(@RequestParam("file") MultipartFile file) {
        return fileService.upload(file);
    }
}
