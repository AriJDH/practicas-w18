package com.example.qatester.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class TestCaseDto {
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate last_update;
}
