package com.yodsarun.interview.controller;

import com.yodsarun.interview.modal.CustomerResponse;
import com.yodsarun.interview.modal.common.ResponseModal;
import com.yodsarun.interview.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/v1")
@RequiredArgsConstructor
public class DemoController {
    private final CustomerService customerService;

    @GetMapping(value = "/hello-world")
    public ResponseEntity<ResponseModal<List<CustomerResponse>>> helloWorld() {
        return customerService.getAllCustomer();
    }
}
