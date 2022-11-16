package com.dh.be_java_hisp_w18_g10.dto.require;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostDTOreq {
    private int user_id;
    private String date;
    private ProductDTOreq product;
    private int category;
    private double price;
}

