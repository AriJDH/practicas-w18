package com.meli.be_java_hisp_w18_g01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostsDiscountDTO {
    private long user_id;
    private long post_id;
    private String date;
    private ProductDTO product;
    private String category;
    private double price;
    private boolean has_promo;
    private Double discount;

}
