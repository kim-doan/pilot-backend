package com.wdyj.boilerplate.bbs.services;

import com.wdyj.boilerplate.bbs.dto.PostRequest;
import com.wdyj.boilerplate.bbs.dto.PostResponse;
import com.wdyj.boilerplate.bbs.models.Category;
import com.wdyj.boilerplate.bbs.models.Post;
import com.wdyj.boilerplate.bbs.repositories.CategoryRepository;
import com.wdyj.boilerplate.bbs.repositories.PostRepository;
import com.wdyj.boilerplate.constants.Constants;
import com.wdyj.boilerplate.exception.CategoryNotFoundException;
import com.wdyj.boilerplate.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

    private final CategoryRepository categoryRepository;

    public Page<PostResponse> getPosts(Pageable pageable) {
        return postRepository.findAllByDelYnFalse(pageable);
    }

    @Transactional
    public Long insertPost(PostRequest postRequest) {
        Optional<Category> findCategory = categoryRepository.findByIdAndDelYn(postRequest.getCategoryId(), Constants.NO);
        if (findCategory.isEmpty()) {
            throw new CategoryNotFoundException();
        }

        return postRepository.save(new Post(postRequest)).getId();
    }

    @Transactional
    public Long updatePost(Long id, PostRequest postRequest) {
        Optional<Category> findCategory = categoryRepository.findByIdAndDelYn(postRequest.getCategoryId(), Constants.NO);
        if (findCategory.isEmpty()) {
            throw new CategoryNotFoundException();
        }
        Category category = findCategory.get();
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Board not found"));

        post.setCategoryId(category.getId());
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setModDate(LocalDateTime.now());

        return postRepository.save(post).getId();
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException());

        post.setModDate(LocalDateTime.now());
        post.setDelYn(Constants.YES);
    }
}
