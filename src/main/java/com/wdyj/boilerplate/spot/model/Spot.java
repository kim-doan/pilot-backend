package com.wdyj.boilerplate.spot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Spot {
    // 관심여행지 순번
    private String poiSeq;

    // 지역 명
    private String poiRegion;

    // 관심여행지 명
    private String poiName;

    // 관심여행지 소개
    private String poiInformation;

    // 작성 일자
    private LocalDateTime poiDt;

    // 위도
    private Double poiLat;

    // 경도
    private Double poiLon;

    // 관심여행지 구분
    private String poiType;

    // 작성자 아이디
    private String poiId;
}
