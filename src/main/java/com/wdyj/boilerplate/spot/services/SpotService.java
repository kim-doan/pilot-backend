package com.wdyj.boilerplate.spot.services;

import com.wdyj.boilerplate.mapper.SpotMapper;
import com.wdyj.boilerplate.spot.dto.SpotDto;
import com.wdyj.boilerplate.spot.model.Spot;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SpotService {
    private final SpotMapper spotMapper;

    @Transactional
    public List<SpotDto> getSpotList() {
        List<Spot> spotList = spotMapper.getSpotList();

        List<SpotDto> dtoList = new ArrayList<>();

        for (Spot spot : spotList) {
            SpotDto spotDto = SpotDto.builder()
                    .spot_id(spot.getPoiSeq())
                    .spot_name(spot.getPoiName())
                    .region(spot.getPoiRegion())
                    .build();

            dtoList.add(spotDto);
        }

        return dtoList;
    }

}
