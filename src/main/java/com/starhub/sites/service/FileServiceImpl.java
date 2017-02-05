package com.starhub.sites.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Hiep Dang on 2/3/2017.
 */
@Service
public class FileServiceImpl implements FileService {
    private static final Logger LOG = LoggerFactory.getLogger(FileServiceImpl.class);

    public static final String uploadingdir = System.getProperty("user.dir") + "\\fileUpload\\";

    @Override
    public String upload(MultipartFile file) {
        String fileName;
        if (!file.isEmpty()) {
            try {
                fileName = System.currentTimeMillis() / 1000L + file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream =
                        new BufferedOutputStream(new FileOutputStream(new File(uploadingdir + fileName)));
                buffStream.write(bytes);
                buffStream.close();
                return fileName;
            } catch (Exception e) {
                LOG.error(e.getMessage());
                return null;
            }
        } else {
            LOG.error("Unable to upload. File is empty.");
            return "Unable to upload. File is empty.";
        }
    }
}
