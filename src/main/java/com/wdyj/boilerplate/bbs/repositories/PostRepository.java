package com.wdyj.boilerplate.bbs.repositories;

import com.wdyj.boilerplate.bbs.models.Post;
import com.wdyj.boilerplate.bbs.repositories.custom.PostRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {
    @EntityGraph(value = "Post.withCategory")
    Page<Post> findAllByDelYnEquals(String delYn, Pageable pageable);
}
