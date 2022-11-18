package com.socialmeli.be_java_hisp_w18g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PromoPostDTOResponse {
    private Integer user_id;
    private Integer post_id;
    private String date;
    private ProductDTOResponse product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}