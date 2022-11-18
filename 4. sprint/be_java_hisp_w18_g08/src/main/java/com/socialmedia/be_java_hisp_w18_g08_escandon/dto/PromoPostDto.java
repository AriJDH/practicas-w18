package com.socialmedia.be_java_hisp_w18_g08_escandon.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialmedia.be_java_hisp_w18_g08_escandon.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PromoPostDto {

    private Integer user_id;
    private Integer post_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDto product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
