package com.wdyj.boilerplate.bbs.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.wdyj.boilerplate.bbs.models.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@Builder
public class PostResponse {
    private Long id;

    private String title;

    private String content;

    private String writer;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private CategoryResponse category;

    @QueryProjection
    public PostResponse(Long id, String title, String content, String writer, LocalDateTime regDate, LocalDateTime modDate, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.regDate = regDate;
        this.modDate = modDate;
        this.category = CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
