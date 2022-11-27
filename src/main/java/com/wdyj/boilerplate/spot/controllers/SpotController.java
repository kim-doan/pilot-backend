package com.wdyj.boilerplate.spot.controllers;

import com.wdyj.boilerplate.spot.dto.SpotDetailDto;
import com.wdyj.boilerplate.spot.dto.SpotResponseDto;
import com.wdyj.boilerplate.spot.services.SpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spots")
@RequiredArgsConstructor
public class SpotController {
    private final SpotService spotService;

    @GetMapping
    public ResponseEntity<SpotResponseDto> getSpotList() {
        SpotResponseDto result = SpotResponseDto.builder()
                .spot_list(spotService.getSpotList())
                .build();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{spot_id}")
    public ResponseEntity<SpotDetailDto> getSpotDetail(@PathVariable("spot_id") String spot_id) {
        SpotDetailDto result = spotService.getSpotDetail(spot_id);

        return ResponseEntity.ok(result);
    }
}
