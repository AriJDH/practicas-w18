package com.sprint1.be_java_hisp_w18_g03.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint1.be_java_hisp_w18_g03.entity.Post;
import com.sprint1.be_java_hisp_w18_g03.entity.Product;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseProductsWithDiscountDTO {
  @JsonProperty("user_id")
  private Integer userId;

  @JsonProperty("user_name")
  private String userName;

  @JsonProperty("posts")
  private List<Product> ProductsWithDiscount;
}
