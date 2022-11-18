package com.mercadolibre.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer id;
    private LocalDate date;
    private Integer category;
    private Double price;
    private Product product;
    private Boolean hasPromo;
    private Double discount;

    public Post(Integer id, LocalDate date, Integer category, Double price, Product product) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.price = price;
        this.product = product;
        this.hasPromo = false;
        this.discount = Double.valueOf(0);
    }
}
