package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PromoResDTO {
    private int post_id;
    private String user_name;
    private int promo_products_count;
}
