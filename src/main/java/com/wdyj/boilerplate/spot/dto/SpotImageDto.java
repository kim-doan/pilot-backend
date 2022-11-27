package com.wdyj.boilerplate.spot.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpotImageDto {
    private String id;
    private String spot_name;
    private String path;
    private LocalDateTime time;
    private String likeYn;
}
