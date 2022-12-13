package com.example.demo.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Document(indexName = "products")
public class Product {

	@Id private String id;
	private String name;
	private String type;
	private Double price;
	private Double cost;
	private Integer quantity;
	
	public void setId(String id) {
	this.id = id;
	}
}
