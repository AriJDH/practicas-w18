package com.example.covid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Symptom {
    private Integer code;
    private String name;
    private String severityLevel;
}
