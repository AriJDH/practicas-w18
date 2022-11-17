package com.meli.be_java_hisp_w18_g03_group.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private Category category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public Product() {
        this.hasPromo = false;
        this.discount = 0d ;
    }
}
