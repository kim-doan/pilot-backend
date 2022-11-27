package com.wdyj.boilerplate.spot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SpotResponseDto {
    private String result_code = "200";
    private String result_msg = "성공했습니다.";
    private List<SpotDto> spot_list;
}
