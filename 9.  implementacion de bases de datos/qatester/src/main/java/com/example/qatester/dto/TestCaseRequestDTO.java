package com.example.qatester.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
 @Getter
 @AllArgsConstructor
 @NoArgsConstructor
 @Data
public class TestCaseRequestDTO {
    private String description;
    private boolean tested;
    private boolean pased;
    private int number_of_tries;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate last_update;
}
