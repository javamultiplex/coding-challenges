package com.javamultiplex.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Customer implements Serializable {
    private static final long serialVersionUID = -3195573264049448013L;
    private Integer id;
    private String name;
    private String address;
    @Setter
    private List<Product> products;

    public Customer(Integer id, String name,String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public List<Product> getProducts() {
        if (products==null){
            return new ArrayList<>();
        }
        return products;
    }
}
