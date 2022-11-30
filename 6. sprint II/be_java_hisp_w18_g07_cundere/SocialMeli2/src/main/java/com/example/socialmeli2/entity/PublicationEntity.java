package com.example.socialmeli2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationEntity {

    private Integer id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Integer userId;
    private Integer productId;
    private Integer category;
    private Double price;

}
