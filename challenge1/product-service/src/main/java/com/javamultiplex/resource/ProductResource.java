package com.javamultiplex.resource;

import com.javamultiplex.model.Product;
import com.javamultiplex.model.ProductList;
import com.javamultiplex.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductResource {

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/customer/{customerId}/products")
    public ProductList getProducts(@PathVariable Integer customerId) {
        List<Product> products = productService.getProducts(customerId);
        return new ProductList(products);
    }
}
