package com.javamultiplex.resource;

import com.javamultiplex.model.Customer;
import com.javamultiplex.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerResource {

    private final CustomerService customerService;

    @Autowired
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer/{customerId}")
    public Customer getProducts(@PathVariable Integer customerId) {
        return customerService.getCustomer(customerId);
    }
}
