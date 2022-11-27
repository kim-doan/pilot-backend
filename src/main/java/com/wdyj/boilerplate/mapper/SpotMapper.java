package com.wdyj.boilerplate.mapper;

import com.wdyj.boilerplate.spot.dto.SpotDetailDto;
import com.wdyj.boilerplate.spot.dto.SpotDto;
import com.wdyj.boilerplate.spot.dto.SpotImageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SpotMapper {
    List<SpotDto> getSpotList();
    Optional<SpotDetailDto> getSpotDetail(String spot_id);
    Optional<SpotImageDto> getSpotImage(String spot_id);
}
