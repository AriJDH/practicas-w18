package com.example.test_case_with_mysql.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateTestCaseDTO {

    private String description;

    private Boolean tested;

    private Boolean passed;

    private int number_of_tries;
}
