package com.yodsarun.interview.modal.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
public class StatusResponse {
    private String message;

    public StatusResponse(String message) {
        this.message = message;
    }
}
