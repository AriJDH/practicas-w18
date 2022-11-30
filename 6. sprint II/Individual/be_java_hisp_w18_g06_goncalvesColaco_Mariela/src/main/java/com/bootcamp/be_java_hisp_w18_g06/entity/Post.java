package com.bootcamp.be_java_hisp_w18_g06.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class Post {
	@JsonProperty("post_id")
	private Integer postId = 0;
	@JsonProperty("user_id")
	private Integer userId;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;
	private Product product;
	private String category;
	private Double price;
	
	public Post(Integer userId,
	            LocalDate date,
	            Product product,
	            String category,
	            Double price) {
		this.postId += 1;
		this.userId = userId;
		this.date = date;
		this.product = product;
		this.category = category;
		this.price = price;
	}
}
