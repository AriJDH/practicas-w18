package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostPromoCountDTOres {
    //TODO US 0011 - GET - /products/promo-post/count?user_id={userId}
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
