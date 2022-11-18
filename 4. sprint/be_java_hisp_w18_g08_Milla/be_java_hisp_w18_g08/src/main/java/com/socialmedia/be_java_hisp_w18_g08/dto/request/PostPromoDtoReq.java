package com.socialmedia.be_java_hisp_w18_g08.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmedia.be_java_hisp_w18_g08.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostPromoDtoReq {

    private Integer user_id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;

}
