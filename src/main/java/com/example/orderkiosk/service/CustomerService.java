package com.example.orderkiosk.service;

import com.example.orderkiosk.domain.CreateCustomer;
import com.example.orderkiosk.domain.Customer;
import com.example.orderkiosk.domain.CustomerDto;
import com.example.orderkiosk.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public CustomerDto newCustomer(CreateCustomer customer){
        Customer entity = Customer.newCustomer(customer);
        Customer saved = customerRepository.save(entity);
        return CustomerDto.builder()
                .address(saved.getAddress())
                .name(saved.getName())
                .phoneNumber(saved.getPhoneNumber())
                .build();
    }
}
