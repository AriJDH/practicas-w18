package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoPostDTOres {

    private int user_id;
    private int post_id;
    private String date;
    private ProductDTOres product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
