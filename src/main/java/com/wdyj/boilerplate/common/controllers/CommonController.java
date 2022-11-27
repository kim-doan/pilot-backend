package com.wdyj.boilerplate.common.controllers;

import com.wdyj.boilerplate.common.dto.CommonResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("/")
public class CommonController {

    @GetMapping("/heath")
    public ResponseEntity<CommonResponseDTO> health() {
        return ResponseEntity.ok(new CommonResponseDTO("E0000", "OK", new HashMap<String, Objects>()));
    }
}
