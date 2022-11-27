package com.wdyj.boilerplate.bbs.controllers;

import com.wdyj.boilerplate.bbs.dto.CategoryRequest;
import com.wdyj.boilerplate.bbs.models.Category;
import com.wdyj.boilerplate.bbs.services.CategoryService;
import com.wdyj.boilerplate.response.model.EntityIdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bbs")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PostMapping("/categories")
    public ResponseEntity<EntityIdResponse<Long>> insertCategory(@RequestBody CategoryRequest categoryRequest) {
        Long insertedId = categoryService.insertCategory(categoryRequest);
        return new ResponseEntity<>(new EntityIdResponse<>(insertedId), HttpStatus.CREATED);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<EntityIdResponse<Long>> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) {
        Long updatedId = categoryService.updateCategory(id, categoryRequest);
        return new ResponseEntity<>(new EntityIdResponse<>(updatedId), HttpStatus.OK);
    }

    @DeleteMapping("/categories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
