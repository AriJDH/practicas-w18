package com.example.test_case_with_mysql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class TestDTO {

    private Long id;

    private String description;

    private Boolean tested;

    private Boolean passed;

    private int number_of_tries;

    private LocalDate last_update;
}
