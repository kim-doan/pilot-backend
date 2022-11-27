package com.wdyj.boilerplate.bbs.repositories;

import com.wdyj.boilerplate.bbs.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByDelYnEquals(String delYn);

    Optional<Category> findByIdAndDelYn(Long id, String delYn);
}
