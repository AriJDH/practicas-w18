package com.dh.be_java_hisp_w18_g10.dto.require;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostDTOreq {

    private int user_id;
    private String date;
    private ProductDTOreq product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;

}

// JSON REPRESENTATION
// {
//  "user_id": 0,
//  "date": "",
//  "product": {
//    "product_id": 0,
//    "product_name": "",
//    "type": "",
//    "brand": "",
//    "color": "",
//    "notes": ""
//  },
//  "category": 0,
//  "price": 0.0,
//  "has_promo": false,
//  "discount": 0.0
//}
