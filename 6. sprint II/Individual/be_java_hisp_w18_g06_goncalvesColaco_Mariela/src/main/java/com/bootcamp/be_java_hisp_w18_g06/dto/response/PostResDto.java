package com.bootcamp.be_java_hisp_w18_g06.dto.response;

import com.bootcamp.be_java_hisp_w18_g06.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class PostResDto {
    @JsonProperty("post_id")
    private Integer postId;
    @JsonProperty("user_Id")
    private Integer userId;
    private LocalDate date;
    private Product product;
    private String category;
    private Double price;
}
