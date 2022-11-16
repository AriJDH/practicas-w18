package com.bootcamp.be_java_hisp_w18_g06.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {

    private int post_id;
    private int user_id;
    private LocalDate date;
    private Product product;
    private String category;
    private double price;
    
}
