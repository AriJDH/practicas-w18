package com.example.consultashql.dto.Response;

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
public class GenreDtoResp {
    private Integer id;
    private Date crearedAt;
    private Date updatedAt;
    private String name;
    private Integer ranking;
    private Integer active;
    private Integer rating;
}

