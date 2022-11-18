package com.dh.be_java_hisp_w18_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostProductsPromotionDTOres {

    private int user_id;
    private String user_name;
    private int promo_products_count;
}
