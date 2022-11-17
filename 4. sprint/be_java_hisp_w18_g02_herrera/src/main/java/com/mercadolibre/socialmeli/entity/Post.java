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
    private boolean hasPromo;
    private Double discount;
}
