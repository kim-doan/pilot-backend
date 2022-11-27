package com.wdyj.boilerplate.bbs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostRequest {
    private Long categoryId;

    private String title;

    private String content;
}
