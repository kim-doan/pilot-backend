package com.wdyj.boilerplate.touristSpot.services;

import com.wdyj.boilerplate.mapper.TouristSpotMapper;
import com.wdyj.boilerplate.touristSpot.dto.TouristSpotDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TouristSpotService {
    private final TouristSpotMapper touristSpotMapper;

    @Transactional
    public List<TouristSpotDto> getTouristSpotList() {
        return touristSpotMapper.getTouristSpotList();
    }
}
