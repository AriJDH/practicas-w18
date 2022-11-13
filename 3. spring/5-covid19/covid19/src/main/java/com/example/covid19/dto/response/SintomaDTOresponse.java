package com.example.covid19.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SintomaDTOresponse {
    private int codigo;
    private String nameSymptom;
    private String riskLevel;
}
