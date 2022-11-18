package com.bootcamp.be_java_hisp_w18_g06.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class Post {
    private int post_id=0;
    private int user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private String category;
    private double price;
    private Boolean has_promo;
    private Double discount;

    public Post( int user_id, LocalDate date, Product product, String category, double price) {
        this.post_id += 1;
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public Post( int user_id, LocalDate date, Product product, String category, double price, Boolean has_promo, Double discount) {
        this.post_id +=1;
        this.user_id = user_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
