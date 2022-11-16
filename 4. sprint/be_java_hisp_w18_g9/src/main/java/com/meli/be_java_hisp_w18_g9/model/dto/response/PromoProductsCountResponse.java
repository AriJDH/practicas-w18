package com.meli.be_java_hisp_w18_g9.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoProductsCountResponse {

    // ? =============== Attributes =============== ?

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("promo_products_count")
    private Integer promoProductsCount;

}
