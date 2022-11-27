package com.wdyj.boilerplate.touristSpot.dto;

import com.wdyj.boilerplate.spot.dto.SpotDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TouristSpotResponseDto {
    private String result_code;
    private String result_msg;
    private List<TouristSpotDto> tourist_spot_list;

    public TouristSpotResponseDto(String result_code, String result_msg, List<TouristSpotDto> tourist_spot_list) {
        this.result_code = "200";
        this.result_msg = "성공했습니다.";
        this.tourist_spot_list = tourist_spot_list;
    }
}
