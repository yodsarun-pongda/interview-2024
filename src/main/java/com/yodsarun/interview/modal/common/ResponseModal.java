package com.yodsarun.interview.modal.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModal<T> extends CommonResponse {
    private T data;

    public ResponseModal(String message) {
        super(new StatusResponse(message));
    }

    public ResponseModal<T> setData(T data) {
        this.data = data;
        return this;
    }
}
