package com.socialmeli.be_java_hisp_w18g05.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NewPromotionPostDTORequest {

    private Integer user_id;
    private String date;
    private ProductDTORequest product;
    private Integer category;
    private Double price;
    private boolean has_promo;
    private double discount;

}
