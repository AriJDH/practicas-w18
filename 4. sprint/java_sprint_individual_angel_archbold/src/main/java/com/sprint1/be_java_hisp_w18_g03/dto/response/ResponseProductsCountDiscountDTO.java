package com.sprint1.be_java_hisp_w18_g03.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseProductsCountDiscountDTO {
  @JsonProperty("user_id")
  private Integer userId;

  @JsonProperty("user_name")
  private String userName;

  @JsonProperty("promo_products_count")
  private Integer ProductsWithDiscount;
}
