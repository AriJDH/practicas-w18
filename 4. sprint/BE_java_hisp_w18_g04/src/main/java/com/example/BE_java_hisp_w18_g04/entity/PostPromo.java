package com.example.BE_java_hisp_w18_g04.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromo {
    private Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double disscount;
}
