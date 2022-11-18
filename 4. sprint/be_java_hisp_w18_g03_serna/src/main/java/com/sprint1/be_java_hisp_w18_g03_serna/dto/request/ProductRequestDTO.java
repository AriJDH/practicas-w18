package com.sprint1.be_java_hisp_w18_g03_serna.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductRequestDTO {
  @JsonProperty("product_id")
  private Integer productId;
  @JsonProperty("product_name")
  private String productName;
  private String type;
  private String brand;
  private String color;
  private String notes;

}
