package com.bootcamp.be_java_hisp_w18_g06.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	@JsonProperty("product_id")
	private Integer productId;
	@JsonProperty("product_name")
	private String productName;
	private String type;
	private String brand;
	private String color;
	private String notes;
}
