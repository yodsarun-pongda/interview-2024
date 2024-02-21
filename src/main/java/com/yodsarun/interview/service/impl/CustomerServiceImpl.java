package com.yodsarun.interview.service.impl;

import com.yodsarun.interview.entity.CustomerEntity;
import com.yodsarun.interview.modal.CustomerResponse;
import com.yodsarun.interview.modal.common.ResponseModal;
import com.yodsarun.interview.repository.CustomerRepository;
import com.yodsarun.interview.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

//    public SearchCustomerServiceImpl(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    public ResponseEntity<ResponseModal<List<CustomerResponse>>> getAllCustomer() {
        try {
            List<CustomerEntity> customerList = customerRepository.findAll();
            log.info("Found customer on database: {}", customerList.size());

            var responseList = new ArrayList<CustomerResponse>();
            customerList.forEach(item -> {
                responseList.add(
                        CustomerResponse.builder()
                                .firstName(item.getFirstName())
                                .lastName(item.getLastName())
                                .build()
                );
            });

            return buildResponse(responseList);
        } catch (Exception e) {
            log.error("Error occurred when get All customer from database", e);
            return ResponseEntity.internalServerError()
                    .body(new ResponseModal<>("failed"));
        }
    }

    private ResponseEntity<ResponseModal<List<CustomerResponse>>> buildResponse(
        List<CustomerResponse> customerResponses
    ) {
        return ResponseEntity.ok()
            .body(new ResponseModal<List<CustomerResponse>>("success").setData(customerResponses));
    }
}
