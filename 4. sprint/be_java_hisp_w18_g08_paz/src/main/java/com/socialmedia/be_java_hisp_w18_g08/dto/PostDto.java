package com.socialmedia.be_java_hisp_w18_g08.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmedia.be_java_hisp_w18_g08.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private Integer post_id;
    private Integer user_id;
    private Product product;
    private Integer category;
    private Double price;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Boolean has_promo=false;
    private Double discount=0.0;

    public PostDto(Integer post_id, Integer user_id, Product product, Integer category, Double price, LocalDate date) {
        this.post_id = post_id;
        this.user_id = user_id;
        this.product = product;
        this.category = category;
        this.price = price;
        this.date = date;
    }
}
