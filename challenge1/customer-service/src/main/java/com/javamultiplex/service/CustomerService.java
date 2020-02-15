package com.javamultiplex.service;

import com.javamultiplex.model.Customer;
import com.javamultiplex.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rohit Agarwal on 15/02/20 9:16 pm
 * @copyright www.javamultiplex.com
 */
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
