package com.sports.sports.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonDTO {
    private String name;
    private String lastname;
    private String sport;
}
