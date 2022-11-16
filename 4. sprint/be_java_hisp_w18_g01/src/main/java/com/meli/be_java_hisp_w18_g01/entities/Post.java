package com.meli.be_java_hisp_w18_g01.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private long post_id;
    private User user;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;

}
