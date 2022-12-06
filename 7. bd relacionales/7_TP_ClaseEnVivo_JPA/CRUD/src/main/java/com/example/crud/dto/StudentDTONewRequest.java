package com.example.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentDTONewRequest {
    private String dni;
    private String name;
    private String lastname;
}
