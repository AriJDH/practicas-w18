package com.tester.tester.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDTO {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int number_of_tries;
    private String last_update;
}
