package com.wdyj.boilerplate.bbs.models;

import com.wdyj.boilerplate.bbs.dto.CategoryRequest;
import com.wdyj.boilerplate.bbs.dto.CategoryResponse;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@ToString
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(updatable = false)
    private LocalDateTime regDate;

    @Column(insertable = false)
    private LocalDateTime modDate;

    private String delYn;

    public Category(CategoryRequest categoryRequest) {
        this.name = categoryRequest.getName();
    }

    public CategoryResponse toCategoryResponse() {
        return CategoryResponse.builder()
                .id(this.id)
                .name(this.name)
                .build();
    }
}
