package com.wdyj.boilerplate.touristSpot.controller;

import com.wdyj.boilerplate.touristSpot.dto.TouristSpotResponseDto;
import com.wdyj.boilerplate.touristSpot.services.TouristSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/touristSpot")
@RequiredArgsConstructor
public class TouristSpotController {
    private final TouristSpotService touristSpotService;

    @GetMapping("/touristSpots")
    public ResponseEntity<TouristSpotResponseDto> getTouristList(){
        TouristSpotResponseDto result = TouristSpotResponseDto.builder()
                .tourist_spot_list(touristSpotService.getTouristSpotList())
                .build();
        return ResponseEntity.ok(result);
    }
}
