package com.wdyj.boilerplate.spot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SpotResponseDto {
    private String result_code;
    private String result_msg;
    private List<SpotDto> spot_list;

    public SpotResponseDto(String result_code, String result_msg, List<SpotDto> spot_list) {
        this.result_code = "200";
        this.result_msg = "성공했습니다.";
        this.spot_list = spot_list;
    }
}
