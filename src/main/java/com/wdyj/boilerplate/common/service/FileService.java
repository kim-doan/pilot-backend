package com.wdyj.boilerplate.common.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {

    @Value("${file.basePath}")
    private String BASE_PATH;

    public void upload(MultipartFile file, String path) {
        path = (BASE_PATH + path).replaceAll("//", "/");
        log.info("file name: {}", file.getOriginalFilename());
        log.info("file path: {}", path);
        File dest = new File(path + file.getOriginalFilename());
        try {
            dest.getParentFile().mkdirs();
            file.transferTo(dest);
        } catch (Exception e) {
            log.error("file upload error: {}", e.getMessage());
        }
    }

    public Resource download(String path, String fileName) {
        try {
            Path file = Paths.get(path).resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file : " + fileName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read the file : " + fileName, e);
        }
    }
}
