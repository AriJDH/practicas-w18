package com.example.qatester.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TestCaseResponseDTO {
    private Long idCase;
    private String description;
    private boolean tested;
    private boolean pased;
    private int numberOfTries;
    private LocalDate lastUpdate;
}
