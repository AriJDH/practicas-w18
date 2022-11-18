package com.bootcamp.be_java_hisp_w18_g06.dto.request;

import com.bootcamp.be_java_hisp_w18_g06.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PromoPostDTO {
	
	private int user_id;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate date;
	private Product product;
	private int category;
	private double price;
	private boolean has_promo;
	private double discount;
	
}
