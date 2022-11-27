package com.wdyj.boilerplate.spot.controllers;

import com.wdyj.boilerplate.spot.dto.SpotResponseDto;
import com.wdyj.boilerplate.spot.services.SpotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/spot")
public class SpotController {
    private final SpotService spotService;

    public SpotController(SpotService spotService) {
        this.spotService = spotService;
    }

    @GetMapping("/spots")
    public ResponseEntity<SpotResponseDto> getSpotList() {
        SpotResponseDto result = SpotResponseDto.builder()
                .spot_list(spotService.getSpotList())
                .build();

        return ResponseEntity.ok(result);
    }
}