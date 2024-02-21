package com.yodsarun.interview.modal.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Data
public class CommonResponse {
    private StatusResponse status;

    public CommonResponse(StatusResponse statusResponse) {
        this.status = statusResponse;
    }

    public CommonResponse(String message) {
        this(new StatusResponse(message));
    }

    CommonResponse() {

    }
}
