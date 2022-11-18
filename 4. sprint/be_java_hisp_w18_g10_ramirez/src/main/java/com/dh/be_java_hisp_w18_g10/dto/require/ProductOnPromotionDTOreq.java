package com.dh.be_java_hisp_w18_g10.dto.require;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductOnPromotionDTOreq {
    private int user_id;
    private String date;
    private ProductDTOreq product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;
}
