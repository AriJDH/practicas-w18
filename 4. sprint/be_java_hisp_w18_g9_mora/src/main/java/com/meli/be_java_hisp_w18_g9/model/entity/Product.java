package com.meli.be_java_hisp_w18_g9.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    // ? =============== Attributes =============== ?

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("product_name")
    private String productName;

    private String type;

    private String brand;

    private String color;

    private String notes;

}
