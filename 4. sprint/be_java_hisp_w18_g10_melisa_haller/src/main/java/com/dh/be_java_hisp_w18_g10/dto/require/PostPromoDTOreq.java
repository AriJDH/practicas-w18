package com.dh.be_java_hisp_w18_g10.dto.require;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostPromoDTOreq {
    //US 0010
    private int user_id;
    private String date;
    private ProductDTOreq product;
    private int category;
    private double price;
    private boolean has_promo; //US0010
    private double discount; //US0010

}
