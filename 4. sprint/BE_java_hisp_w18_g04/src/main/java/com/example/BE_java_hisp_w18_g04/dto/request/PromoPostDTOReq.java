package com.example.BE_java_hisp_w18_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PromoPostDTOReq {
    private Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTOReq product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
