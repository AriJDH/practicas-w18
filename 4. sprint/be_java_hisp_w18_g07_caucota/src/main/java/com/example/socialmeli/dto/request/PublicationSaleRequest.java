package com.example.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class PublicacionSaleRequest {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    @JsonProperty("product")
    private ProductRequest productRequest;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
