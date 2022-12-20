package com.example.consultashql.dto.Response;

import com.example.consultashql.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDtoResp {
    private Integer id;

    private Date createdAt;
    private Date updatedAt;
    private String firstName;
    private String lastName;
    private Double rating;
    private Movie favoriteMovie;
}
