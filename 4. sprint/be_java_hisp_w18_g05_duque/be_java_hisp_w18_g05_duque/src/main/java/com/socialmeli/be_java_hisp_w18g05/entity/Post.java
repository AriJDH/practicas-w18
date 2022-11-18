package com.socialmeli.be_java_hisp_w18g05.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data

public class Post {
    private Integer post_id;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean has_promo=Boolean.FALSE;
    private Double discount=0.0;

    public Post(Integer post_id, LocalDate date, Product product, Integer category, Double price) {
        this.post_id = post_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public Post(Integer post_id, LocalDate date, Product product, Integer category, Double price, Boolean has_promo, Double discount) {
        this.post_id = post_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
