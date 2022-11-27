package com.wdyj.boilerplate.common.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponseDTO<T> {
    private String result_code;
    private String result_msg;
    private T contents;
}
