package com.wdyj.boilerplate.bbs.services;

import com.wdyj.boilerplate.bbs.dto.CategoryRequest;
import com.wdyj.boilerplate.bbs.models.Category;
import com.wdyj.boilerplate.bbs.repositories.CategoryRepository;
import com.wdyj.boilerplate.constants.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAllByDelYnEquals(Constants.NO);
    }

    @Transactional
    public Long insertCategory(CategoryRequest categoryRequest) {
        Category category = Category.builder()
                .name(categoryRequest.getName())
                .regDate(LocalDateTime.now())
                .delYn(Constants.NO)
                .build();

        return categoryRepository.save(category).getId();
    }

    @Transactional
    public Long updateCategory(Long id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 없습니다. id=" + id));

        category.setName(categoryRequest.getName());
        category.setModDate(LocalDateTime.now());

        return categoryRepository.save(category).getId();
    }

    @Transactional
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 카테고리가 없습니다. id=" + id));

        category.setDelYn(Constants.YES);
    }
}
