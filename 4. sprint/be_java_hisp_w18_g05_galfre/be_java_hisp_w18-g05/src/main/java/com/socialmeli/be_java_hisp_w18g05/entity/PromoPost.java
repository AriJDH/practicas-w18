package com.socialmeli.be_java_hisp_w18g05.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class PromoPost extends Post{
    private Boolean has_promo;
    private Double discount;

    public PromoPost(Integer post_id, LocalDate date, Product product, Integer category, Double price, Boolean has_promo, Double discount) {
        super(post_id, date, product, category, price);
        this.has_promo = has_promo;
        this.discount = discount;
    }
}
