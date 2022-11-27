package com.wdyj.boilerplate.response.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter @Setter
public class PageResponse<T> {
    private PageInfo<T> page;
    private List<T> data;

    public PageResponse(Page<T> data) {
        this.page = new PageInfo<>(data);
        this.data = data.getContent();
    }
}
