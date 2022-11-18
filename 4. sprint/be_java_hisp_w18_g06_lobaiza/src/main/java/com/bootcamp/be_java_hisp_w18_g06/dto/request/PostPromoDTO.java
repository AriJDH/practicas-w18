package com.bootcamp.be_java_hisp_w18_g06.dto.request;

import com.bootcamp.be_java_hisp_w18_g06.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostPromoDTO {
    private int post_id;
    private int user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private String category;
    private double price;

    // NUEVO
    private boolean has_promo;
    private double discount;
}
