package com.example.covid19.dto.request;

import com.example.covid19.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PersonaDTOrequest {
    private String name;
    private String lastname;
    private int age;
    private String sintomas;
}
