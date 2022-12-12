package com.mercadolibre.practica.HQL.con.movies.db.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MovieDTO {
    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    private Integer length;

}
