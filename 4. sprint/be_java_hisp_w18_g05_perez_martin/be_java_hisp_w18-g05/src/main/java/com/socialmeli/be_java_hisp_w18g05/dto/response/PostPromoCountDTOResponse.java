package com.socialmeli.be_java_hisp_w18g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class PostPromoCountDTOResponse {

    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;

}
