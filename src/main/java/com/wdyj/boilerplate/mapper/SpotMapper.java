package com.wdyj.boilerplate.mapper;

import com.wdyj.boilerplate.spot.model.Spot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpotMapper {
    List<Spot> getSpotList();
}
