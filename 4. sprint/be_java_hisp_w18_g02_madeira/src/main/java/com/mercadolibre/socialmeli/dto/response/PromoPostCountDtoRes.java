package com.mercadolibre.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoPostCountDtoRes {
    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("promo_products_count")
    private Integer promoProductsCount;

}
