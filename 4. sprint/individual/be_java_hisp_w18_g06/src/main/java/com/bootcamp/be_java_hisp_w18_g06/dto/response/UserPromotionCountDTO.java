package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPromotionCountDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}

