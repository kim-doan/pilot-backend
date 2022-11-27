package com.wdyj.boilerplate.mapper;

import com.wdyj.boilerplate.spot.dto.SpotDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpotMapper {
    List<SpotDto> getSpotList();
}
