package com.javamultiplex.repository;

import com.javamultiplex.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepository {

    private static Map<Integer, List<Product>> map = new HashMap<>();

    static {
        Product product1 = new Product(1, "Laptop", "Apple_2019");
        Product product2 = new Product(2, "Washing Machine", "Samsung_2018");
        Product product3 = new Product(3, "Mobile Phone", "MI_2020");
        Product product4 = new Product(4, "Freezer", "Samsung_2017");
        Product product5 = new Product(5, "AC", "Hitachi_2017");
        map.put(1, Arrays.asList(product1, product3));
        map.put(2, Arrays.asList(product1, product4, product2));
        map.put(3, Arrays.asList(product1, product4));
        map.put(4, Arrays.asList(product4, product3, product2));
        map.put(5, Arrays.asList(product1, product2, product5));
    }

    public List<Product> getProducts(Integer customerId) {
        if (map.containsKey(customerId)) {
            return map.get(customerId);
        } else {
            return new ArrayList<>();
        }
    }
}
