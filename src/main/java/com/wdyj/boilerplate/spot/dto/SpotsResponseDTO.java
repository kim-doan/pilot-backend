package com.wdyj.boilerplate.spot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SpotsResponseDTO {
    private String spot_id;
    private String spot_name;
    private String region;
    private String img_path;
    private List<HashTagDTO> hash_tag_list;
}
