package com.mercadolibre.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDto {
    @JsonProperty("product_id")
    private Integer id;
    @JsonProperty("product_name")
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
