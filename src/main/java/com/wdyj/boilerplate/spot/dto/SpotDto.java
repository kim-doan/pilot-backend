package com.wdyj.boilerplate.spot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpotDto {
    private String spot_id;
    private String spot_name;
    private String region;
    private String img_path;

    @JsonIgnore
    private String poi_hashtag;

    private String[] hash_tag_list;
}
