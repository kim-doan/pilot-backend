package com.wdyj.boilerplate.common.controllers;

import com.wdyj.boilerplate.common.dto.CommonResponseDTO;
import com.wdyj.boilerplate.common.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/")
@RequiredArgsConstructor
public class CommonController {

    private final FileService fileService;
    @GetMapping("/heath")
    public ResponseEntity<CommonResponseDTO> health() {
        return ResponseEntity.ok(new CommonResponseDTO("E0000", "OK", new HashMap<String, Objects>()));
    }

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestPart MultipartFile file) {
        fileService.upload(file, "/Users/ba91/upload/");
        return ResponseEntity.ok(new CommonResponseDTO("E0000", "OK", new HashMap<String, Objects>()));
    }

    @GetMapping("/download")
    public ResponseEntity download() {
        Resource resource = fileService.download("/Users/ba91/upload/", "upload-test.png");
        return ResponseEntity.ok()
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
