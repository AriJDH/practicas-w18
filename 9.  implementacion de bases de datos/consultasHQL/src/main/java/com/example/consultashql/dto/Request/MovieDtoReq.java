package com.example.consultashql.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDtoReq {
    private Integer id;
    private Date crearedAt;
    private Date updatedAt;
    private String title;
    private Double rating;
    private Integer awards;
    private Date releaseDate;
    private Integer length;
    private Integer genreId;
}
