package com.javamultiplex.model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Product implements Serializable {
    private static final long serialVersionUID = -5678280823052845L;
    private Integer id;
    private String name;
    private String model;

    public Product(Integer id, String name, String model) {
        this.id = id;
        this.name = name;
        this.model = model;
    }
}