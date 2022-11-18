package com.meli.be_java_hisp_w18_g01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostDTO {
    private long user_id;
    private String date;
    private ProductDTO product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;
}
