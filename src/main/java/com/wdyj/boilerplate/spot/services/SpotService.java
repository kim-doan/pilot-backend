package com.wdyj.boilerplate.spot.services;

import com.wdyj.boilerplate.mapper.SpotMapper;
import com.wdyj.boilerplate.spot.dto.SpotDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SpotService {
    private final SpotMapper spotMapper;

    @Transactional
    public List<SpotDto> getSpotList() {

        return spotMapper.getSpotList().stream().map(spot -> {
            if(spot.getPoi_hashtag() != null) {
                spot.setHash_tag_list(spot.getPoi_hashtag().split("#"));
            }
            return spot;
        }).collect(Collectors.toList());
    }

}
