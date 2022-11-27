package com.wdyj.boilerplate.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter @Setter
@AllArgsConstructor
public class PageInfo<T> {
    private int page;
    private int size;
    private int totalPage;
    private long totalElements;

    private boolean isNext;

    private boolean isPrev;

    public PageInfo(Page<T> page) {
        this.page = page.getPageable().getPageNumber();
        this.size = page.getPageable().getPageSize();
        this.totalPage = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.isNext = page.hasNext();
        this.isPrev = page.hasPrevious();
    }
}
