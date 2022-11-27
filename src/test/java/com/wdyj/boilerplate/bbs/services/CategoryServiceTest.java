package com.wdyj.boilerplate.bbs.services;

import com.wdyj.boilerplate.bbs.models.Category;
import com.wdyj.boilerplate.bbs.repositories.CategoryRepository;
import com.wdyj.boilerplate.constants.Constants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("local")
class CategoryServiceTest {

    @Mock
    private Category category;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @DisplayName("카테고리 등록 테스트")
    @Rollback
    void insertCategory() {
        //given
        Category category = Category.builder()
                .name("The Board is 3Views")
                .regDate(LocalDateTime.now())
                .delYn(Constants.NO)
                .build();
        //when
        Category savedCategory = categoryRepository.save(category);

        //then
        Optional<Category> findCategory = categoryRepository.findById(savedCategory.getId());
        Assertions.assertThat(findCategory.isPresent()).isEqualTo(true);

    }
}