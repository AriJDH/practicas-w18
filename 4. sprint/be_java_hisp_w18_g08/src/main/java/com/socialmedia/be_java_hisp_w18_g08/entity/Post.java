package com.socialmedia.be_java_hisp_w18_g08.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer post_id;
    private Integer user_id;
    private Product product;
    private Integer category;
    private Double price;
    private LocalDate date;
}
