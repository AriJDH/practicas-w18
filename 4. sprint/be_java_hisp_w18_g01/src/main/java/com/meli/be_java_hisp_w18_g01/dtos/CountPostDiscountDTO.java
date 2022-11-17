package com.meli.be_java_hisp_w18_g01.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountPostDiscountDTO {
    private long user_id;
    private String user_name;
    private int promo_products_count;
}
