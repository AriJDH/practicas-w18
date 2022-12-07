package com.example.testers.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TestCase {
    private Long id_case;
    private String description;
    private Boolean tested = false;
    private Boolean passed = false;
    private int number_of_tries;
    private LocalDate last_update;
}
