package com.wdyj.boilerplate.bbs.dto;

import lombok.*;

@Getter @Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
    private Long id;

    private String name;
}
