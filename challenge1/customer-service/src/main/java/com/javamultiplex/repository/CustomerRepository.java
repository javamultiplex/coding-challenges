package com.javamultiplex.repository;

import com.javamultiplex.client.ProductApiClient;
import com.javamultiplex.model.Customer;
import com.javamultiplex.model.ProductList;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohit Agarwal on 15/02/20 9:16 pm
 * @copyright www.javamultiplex.com
 */
@Repository
public class CustomerRepository {

    private static Map<Integer, Customer> map = new HashMap<>();

    static {
        map.put(1, new Customer(1, "Rohit Agarwal", "Gurgaon"));
        map.put(2, new Customer(2, "Bhavna Agarwal", "Rudrapur"));
        map.put(3, new Customer(3, "Arpit Kumar", "Delhi"));
        map.put(4, new Customer(4, "Ram Kumar", "Bengaluru"));
        map.put(5, new Customer(5, "Ravi Kishan", "Pune"));
    }

    private final ProductApiClient productApiClient;

    public CustomerRepository(ProductApiClient productApiClient) {
        this.productApiClient = productApiClient;
    }

    public Customer getCustomer(Integer customerId) {
        if (map.containsKey(customerId)) {
            Customer customer = map.get(customerId);
            ProductList products = productApiClient.getProducts(customerId);
            customer.setProducts(products.getProducts());
            return customer;
        } else {
            return new Customer();
        }
    }
}
