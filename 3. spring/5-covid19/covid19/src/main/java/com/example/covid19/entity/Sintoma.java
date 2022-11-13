package com.example.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Sintoma {
    private int codigo;
    private String nameSymptom;
    private String riskLevel;

}
