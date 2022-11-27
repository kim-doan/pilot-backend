package com.wdyj.boilerplate.bbs.repositories.custom;

import com.wdyj.boilerplate.bbs.dto.PostResponse;
import com.wdyj.boilerplate.bbs.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryCustom {
    Page<PostResponse> findAllByDelYnFalse(Pageable pageable);
}
