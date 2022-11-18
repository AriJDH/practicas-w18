package com.example.covid.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SymptomDTORes {
    private String name;
    private String severityLevel;
}
