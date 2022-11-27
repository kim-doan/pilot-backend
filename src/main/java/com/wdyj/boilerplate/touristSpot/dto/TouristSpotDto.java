package com.wdyj.boilerplate.touristSpot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TouristSpotDto {

    private Integer spot_id; //관광지 고유 값
    private String name; //관광지 이름
    private String lat; //위도
    private String lng; //경도
    private String img_path; //관광지 대표 이미지

}
