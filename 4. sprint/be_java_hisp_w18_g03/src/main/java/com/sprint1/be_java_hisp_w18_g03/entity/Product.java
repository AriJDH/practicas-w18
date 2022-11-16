package com.sprint1.be_java_hisp_w18_g03.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer postId;
    private User user;
    private LocalDate date;
    private Product producto;
}
