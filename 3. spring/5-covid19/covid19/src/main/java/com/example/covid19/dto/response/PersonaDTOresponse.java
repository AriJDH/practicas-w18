package com.example.covid19.dto.response;

import com.example.covid19.entity.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PersonaDTOresponse {
    private String name;
    private String lastname;
    private int age;
    private List<Sintoma> sintomas;
}
