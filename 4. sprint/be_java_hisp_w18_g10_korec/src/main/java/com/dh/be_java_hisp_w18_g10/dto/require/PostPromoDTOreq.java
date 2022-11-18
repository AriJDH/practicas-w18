package com.dh.be_java_hisp_w18_g10.dto.require;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostPromoDTOreq {
    private int user_id;
    private String date;
    private ProductDTOreq product;
    private int category;
    private double price;
    //Agregado para el individual
    private boolean has_promo;
    private double discount;

    public boolean getHas_promo() {
        return has_promo;
    }
}
