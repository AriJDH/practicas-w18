package com.bootcamp.be_java_hisp_w18_g06.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostPromoCountDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
