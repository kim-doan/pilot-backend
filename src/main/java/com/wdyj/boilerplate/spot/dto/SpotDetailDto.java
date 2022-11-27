package com.wdyj.boilerplate.spot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpotDetailDto {
    private String spot_id;

    private String spot_name;

    private String region;

    private String spot_desc;

    private Integer likes;

    private Integer links;

    private Integer lookups;

    private List<SpotImageDto> img_list;

    private Double lat;

    private Double lng;

    private String contact_line;

    private String home_page;

    private String addr;

    private String hash_tag;

    private String[] hash_tag_list;
}
