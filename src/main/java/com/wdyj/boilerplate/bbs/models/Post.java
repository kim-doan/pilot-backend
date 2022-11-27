package com.wdyj.boilerplate.bbs.models;

import com.wdyj.boilerplate.bbs.dto.PostRequest;
import com.wdyj.boilerplate.bbs.dto.PostResponse;
import com.wdyj.boilerplate.constants.Constants;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Builder
@NamedEntityGraph(name = "Post.withCategory", attributeNodes = @NamedAttributeNode("category"))
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    private Long categoryId;

    private String title;

    private String content;

    private String writer;

    @Column(updatable = false)
    private LocalDateTime regDate;

    @Column(insertable = false)
    private LocalDateTime modDate;

    private String delYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;

    public Post(PostRequest postRequest) {
        this.categoryId = postRequest.getCategoryId();
        this.title = postRequest.getTitle();
        this.content = postRequest.getContent();
        this.regDate = LocalDateTime.now();
        this.delYn = Constants.NO;
    }

    public PostResponse toPostResponse() {
        return PostResponse.builder()
                .id(this.id)
                .title(this.title)
                .content(this.content)
                .writer(this.writer)
                .regDate(this.regDate)
                .modDate(this.modDate)
                .category(this.category.toCategoryResponse())
                .build();
    }
}
