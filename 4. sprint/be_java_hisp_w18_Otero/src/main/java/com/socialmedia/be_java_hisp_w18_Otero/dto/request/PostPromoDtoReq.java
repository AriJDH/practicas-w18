package com.socialmedia.be_java_hisp_w18_Otero.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmedia.be_java_hisp_w18_Otero.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostPromoDtoReq {

    private Integer post_id;
    private Integer user_id;
    private Product product;
    private Integer category;
    private Double price;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private boolean has_promo;
    private double discount;

}
