package com.meli.be_java_hisp_w18_g01.dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoCountDTO {
    private long user_id;
    private String user_name;
    private long promo_products_count;
}
