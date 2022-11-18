package com.socialmeli.be_java_hisp_w18g05.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Post {
    private Integer post_id;
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;

    private Boolean has_promo;
    private Double discount;

}
