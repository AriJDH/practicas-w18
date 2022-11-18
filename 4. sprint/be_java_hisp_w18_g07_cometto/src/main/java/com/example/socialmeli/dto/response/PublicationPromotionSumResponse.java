package com.example.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationPromotionSumResponse {


    private Integer userId;
    private String userName;
    private Integer promo_products_sum;
}
