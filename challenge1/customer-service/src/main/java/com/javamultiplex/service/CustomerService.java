package com.javamultiplex.service;

import com.javamultiplex.model.Customer;
import com.javamultiplex.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Integer customerId){
        return customerRepository.getCustomer(customerId);
    }
}
