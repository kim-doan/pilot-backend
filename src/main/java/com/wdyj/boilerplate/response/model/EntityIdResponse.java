package com.wdyj.boilerplate.response.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EntityIdResponse<T> {
    private T id;

    public EntityIdResponse(T id) {
        this.id = id;
    }
}
