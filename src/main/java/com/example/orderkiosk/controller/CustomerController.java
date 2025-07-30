package com.example.orderkiosk.controller;


import com.example.orderkiosk.domain.CreateCustomer;
import com.example.orderkiosk.domain.CustomerDto;
import com.example.orderkiosk.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/api/v1/customers")
    public Response<CustomerDto> createCustomer(
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ) {
        return Response.success(customerService.newCustomer(
                CreateCustomer.builder()
                        .address(address)
                        .name(name)
                        .phoneNumber(phoneNumber)
                        .build())
        );
    }
}
