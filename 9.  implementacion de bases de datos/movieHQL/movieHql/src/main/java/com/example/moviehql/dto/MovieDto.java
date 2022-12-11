package com.example.moviehql.dto;

import lombok.Data;

@Data
public class MovieDto {
    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    private Integer length;
    private Integer genreId;
}
