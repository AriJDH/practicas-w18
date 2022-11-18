package com.sprint1.be_java_hisp_w18_g03.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private Category category;
    private Double price;
}
