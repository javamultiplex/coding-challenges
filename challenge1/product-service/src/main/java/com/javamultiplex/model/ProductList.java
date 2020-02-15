package com.javamultiplex.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rohit Agarwal on 15/02/20 9:16 pm
 * @copyright www.javamultiplex.com
 */
@Getter
@NoArgsConstructor
public class ProductList implements Serializable {
    private static final long serialVersionUID = 2215259135638751008L;
    private List<Product> products;
    public ProductList(List<Product> products) {
        this.products = products;
    }
}
