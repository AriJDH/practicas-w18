package com.dh.be_java_hisp_w18_g10.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @JsonProperty("user_id")
    private int userId;
    private int post_id;

    @JsonFormat(timezone = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
    //Agregado para el individual
    private boolean has_promo;
    private double discount;

    public Post(int userId, int post_id, LocalDate date, Product product, int category, double price) {
        this.userId = userId;
        this.post_id = post_id;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;

    }

    public boolean getHas_promo() {
        return this.has_promo;
    }
}
