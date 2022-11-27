package com.wdyj.boilerplate.bbs.repositories.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wdyj.boilerplate.bbs.dto.CategoryResponse;
import com.wdyj.boilerplate.bbs.dto.PostResponse;
import com.wdyj.boilerplate.bbs.dto.QPostResponse;
import com.wdyj.boilerplate.bbs.models.Category;
import com.wdyj.boilerplate.bbs.models.QCategory;
import com.wdyj.boilerplate.bbs.models.QPost;
import com.wdyj.boilerplate.bbs.repositories.custom.PostRepositoryCustom;
import com.wdyj.boilerplate.constants.Constants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class PostRepositoryImpl extends QuerydslRepositorySupport implements PostRepositoryCustom {

    public PostRepositoryImpl() {
        super(Category.class);
    }


    @Override
    public Page<PostResponse> findAllByDelYnFalse(Pageable pageable) {
        JPAQueryFactory query = new JPAQueryFactory(this.getEntityManager());

        QPost post = QPost.post;
        QCategory category = QCategory.category;

        BooleanBuilder builder = new BooleanBuilder();

        builder.and(post.delYn.eq(Constants.NO));
        builder.and(category.delYn.eq(Constants.NO));

        List<PostResponse> content = query.select(new QPostResponse(
                post.id,
                post.title,
                post.content,
                post.writer,
                post.regDate,
                post.modDate,
                post.category
                ))
                .from(post)
                .innerJoin(post.category, category)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long totalCount = query.select(Wildcard.count)
                .from(post)
                .where(builder)
                .fetch()
                .get(0);

        return new PageImpl<>(content, pageable, totalCount);
    }
}
