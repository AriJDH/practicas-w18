package com.demohql.mysql.entities.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {

    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    private Integer length;
    private Integer genreId;

}
