package com.wdyj.boilerplate.bbs.services;

import com.wdyj.boilerplate.bbs.models.Post;
import com.wdyj.boilerplate.bbs.models.Category;
import com.wdyj.boilerplate.bbs.repositories.PostRepository;
import com.wdyj.boilerplate.bbs.repositories.CategoryRepository;
import com.wdyj.boilerplate.constants.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @Mock
    private CategoryRepository categoryRepository;

    private PostService postService;
    private CategoryService categoryService;

    @Test
    void insertTest() {
        //given
        final LocalDateTime now = LocalDateTime.now();

        final Category category = Category.builder()
                .name("test")
                .regDate(now)
                .delYn(Constants.NO)
                .build();
        given(categoryRepository.save(category))
        .willReturn(
                Category.builder()
                        .id(1L)
                        .name("test")
                        .regDate(now)
                        .delYn(Constants.NO)
                        .build()
        );

        final Post post =
                Post.builder()
                        .title("title")
                        .categoryId(category.getId())
                        .content("content")
                        .regDate(now)
                        .delYn(Constants.NO)
                        .build();
        given(postRepository.save(post))
                .willReturn(
                        Post.builder()
                                .id(1L)
                                .title("title")
                                .categoryId(category.getId())
                                .content("content")
                                .regDate(now)
                                .delYn(Constants.NO)
                                .build()
                );
        //when
//        final Category svedCategory = categoryService.insertCategory(category);
//        final Board savedBoard =
    }
}