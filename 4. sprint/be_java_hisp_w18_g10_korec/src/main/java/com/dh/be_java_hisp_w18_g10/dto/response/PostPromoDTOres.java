package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDTOres {

    private int user_id;
    private int post_id;
    private String date;
    private ProductDTOres product;
    private int category;
    private double price;
    //----------------------------AGREGADO PARA EL INDIVIDUAL------------------------------------
    private boolean has_promo;
    private double discount;
}
