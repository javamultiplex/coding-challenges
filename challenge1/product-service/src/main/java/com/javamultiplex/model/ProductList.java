package com.javamultiplex.model;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class ProductList implements Serializable {
    private static final long serialVersionUID = 2215259135638751008L;
    private List<Product> products;

    public ProductList(List<Product> products) {
        this.products = products;
    }
}
