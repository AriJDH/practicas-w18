package com.socialmedia.be_java_hisp_w18_g08.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostPromo extends Post {

    private boolean has_promo;
    private double discount;

    public PostPromo(Integer post_id, Integer user_id, Product product, Integer category, Double price, LocalDate date, boolean has_promo, double discount) {
        super(post_id, user_id, product, category, price, date);
        this.has_promo = has_promo;
        this.discount = discount;
    }

}
