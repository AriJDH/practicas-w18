package com.sprint1.be_java_hisp_w18_g03_serna.entity;

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

    public Product(Integer productId, String productName, String type, String brand, String color, String notes, Category category, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
        this.category = category;
        this.price = price;
        this.hasPromo = false;
        this.discount = 0d ;
    }
}
