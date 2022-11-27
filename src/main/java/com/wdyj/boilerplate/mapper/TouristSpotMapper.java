package com.wdyj.boilerplate.mapper;

import com.wdyj.boilerplate.touristSpot.dto.TouristSpotDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TouristSpotMapper {
    List<TouristSpotDto> getTouristSpotList();
}
