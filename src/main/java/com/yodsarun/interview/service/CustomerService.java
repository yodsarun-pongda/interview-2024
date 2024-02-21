package com.yodsarun.interview.service;

import com.yodsarun.interview.modal.CustomerResponse;
import com.yodsarun.interview.modal.common.ResponseModal;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {
    ResponseEntity<ResponseModal<List<CustomerResponse>>> getAllCustomer();
}
