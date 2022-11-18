package com.socialmeli.be_java_hisp_w18g05.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NewPromoPostDTORequest {
    private Integer user_id;
    private String date;
    private ProductDTORequest product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
