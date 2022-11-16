package com.sprint1.be_java_hisp_w18_g03.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {
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

    public Post() {
        this.hasPromo = false;
        this.discount = 0d ;
    }
}
