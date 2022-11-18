package com.example.BE_java_hisp_w18_g04.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromo extends Post{
    private Boolean has_promo;
    private Double discount;
}
