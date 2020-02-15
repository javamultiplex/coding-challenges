package com.javamultiplex.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@NoArgsConstructor
public class ProductList implements Serializable {
    private static final long serialVersionUID = 2215259135638751008L;
    private List<Product> products;
}
