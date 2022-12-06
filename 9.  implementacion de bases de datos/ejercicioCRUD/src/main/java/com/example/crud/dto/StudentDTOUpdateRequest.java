package com.example.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StudentDTOUpdateRequest {
    Long id;
    String name;
    String lastname;
}
