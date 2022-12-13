package com.example.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	
	private String id;
	private String name;
	private String type;
	private Double price;
	private Double cost;
	private Integer quantity;
}
