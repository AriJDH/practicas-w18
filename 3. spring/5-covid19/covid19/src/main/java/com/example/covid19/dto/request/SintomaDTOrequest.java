package com.example.covid19.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SintomaDTOrequest {
    private int codigo;
    private String nameSymptom;
    private String riskLevel;
}
