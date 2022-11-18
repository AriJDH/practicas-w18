package com.bootcamp.be_java_hisp_w18_g06.entity;

import lombok.Data;

@Data
public class PostPromo extends Post {
    private Boolean has_promo;
    private double discount;
}
