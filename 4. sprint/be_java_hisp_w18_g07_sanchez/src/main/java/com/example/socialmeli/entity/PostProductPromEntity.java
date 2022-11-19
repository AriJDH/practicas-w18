package com.example.socialmeli.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostProductPromEntity {

    private Integer id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Integer userId;
    private Integer productId;
    private Integer category;
    private Double price;
    private boolean hasPromo;
    private double discount;
}
