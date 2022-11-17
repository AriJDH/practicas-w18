package com.meli.be_java_hisp_w18_g01.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoIdDTO {
    private long user_id;
    private long post_id;
    private String date;
    private ProductDTO product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;
}
