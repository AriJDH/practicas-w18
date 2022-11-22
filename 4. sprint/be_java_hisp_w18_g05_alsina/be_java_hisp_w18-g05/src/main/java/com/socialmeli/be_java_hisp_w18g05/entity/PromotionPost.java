package com.socialmeli.be_java_hisp_w18g05.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PromotionPost extends Post{

    private boolean has_promo;
    private double discount;

    public PromotionPost(Integer post_id, LocalDate date, Product product, Integer category, Double price, boolean has_promo, double discount) {
        super(post_id, date, product, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}