package com.javamultiplex.service;

import com.javamultiplex.model.Product;
import com.javamultiplex.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Rohit Agarwal on 15/02/20 9:16 pm
 * @copyright www.javamultiplex.com
 */
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(Integer customerId) {
        //Added to get java.net.SocketTimeoutException: Read timed out in Customer Service
//        try{
//            Thread.sleep(4000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }//
        return productRepository.getProducts(customerId);
    }
}
