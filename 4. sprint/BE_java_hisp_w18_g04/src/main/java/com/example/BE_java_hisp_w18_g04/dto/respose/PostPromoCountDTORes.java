package com.example.BE_java_hisp_w18_g04.dto.respose;

import com.example.BE_java_hisp_w18_g04.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class PostPromoCountDTORes {
    private Integer user_id;
    private String user_name;
    private Long promo_product_count;
}

