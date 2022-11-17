package com.dh.be_java_hisp_w18_g10.entity;

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
    private LocalDate date;
    private Product product;
    private int category;
    private double price;

}
