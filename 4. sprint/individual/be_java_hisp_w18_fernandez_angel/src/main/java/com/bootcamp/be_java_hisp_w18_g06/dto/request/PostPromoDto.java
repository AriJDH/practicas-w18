package com.bootcamp.be_java_hisp_w18_g06.dto.request;

import com.bootcamp.be_java_hisp_w18_g06.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostPromoDto {
    private int user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private String category;
    private double price;
    private Boolean has_promo;
    private Double discount;
}
