package com.socialmedia.be_java_hisp_w18_Otero.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostCountDto {
    private Integer user_id;
    private String user_name;
    private int promo_products_count;
}
