package com.wdyj.boilerplate.spot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SpotDto {
    private String spot_id;
    private String spot_name;
    private String region;
    private String img_path;
    private String[] hash_tag_list;
}
