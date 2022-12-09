package com.example.movies_hql.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ActorDTO {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String firstName;

    private String lastName;

    private BigDecimal rating;
}
