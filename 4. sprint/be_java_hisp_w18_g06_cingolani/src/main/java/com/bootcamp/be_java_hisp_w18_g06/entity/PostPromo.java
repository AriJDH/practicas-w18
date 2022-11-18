package com.bootcamp.be_java_hisp_w18_g06.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostPromo extends Post{
    private boolean has_promo;
    private double discount;
}
