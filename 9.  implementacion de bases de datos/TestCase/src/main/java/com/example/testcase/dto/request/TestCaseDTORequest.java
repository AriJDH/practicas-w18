package com.example.testcase.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDTORequest {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    private LocalDate last_update;
}